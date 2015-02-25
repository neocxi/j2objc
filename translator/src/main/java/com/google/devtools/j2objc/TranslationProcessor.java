/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.devtools.j2objc;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.devtools.j2objc.ast.CompilationUnit;
import com.google.devtools.j2objc.ast.PackageDeclaration;
import com.google.devtools.j2objc.ast.TreeConverter;
import com.google.devtools.j2objc.file.RegularInputFile;
import com.google.devtools.j2objc.file.InputFile;
import com.google.devtools.j2objc.gen.GenerationUnit;
import com.google.devtools.j2objc.gen.ObjectiveCHeaderGenerator;
import com.google.devtools.j2objc.gen.ObjectiveCImplementationGenerator;
import com.google.devtools.j2objc.gen.ObjectiveCSegmentedHeaderGenerator;
import com.google.devtools.j2objc.translate.AbstractMethodRewriter;
import com.google.devtools.j2objc.translate.AnonymousClassConverter;
import com.google.devtools.j2objc.translate.ArrayRewriter;
import com.google.devtools.j2objc.translate.Autoboxer;
import com.google.devtools.j2objc.translate.CastResolver;
import com.google.devtools.j2objc.translate.ComplexExpressionExtractor;
import com.google.devtools.j2objc.translate.ConstantBranchPruner;
import com.google.devtools.j2objc.translate.DeadCodeEliminator;
import com.google.devtools.j2objc.translate.DestructorGenerator;
import com.google.devtools.j2objc.translate.EnhancedForRewriter;
import com.google.devtools.j2objc.translate.EnumRewriter;
import com.google.devtools.j2objc.translate.Functionizer;
import com.google.devtools.j2objc.translate.GwtConverter;
import com.google.devtools.j2objc.translate.InitializationNormalizer;
import com.google.devtools.j2objc.translate.InnerClassExtractor;
import com.google.devtools.j2objc.translate.JavaCloneWriter;
import com.google.devtools.j2objc.translate.JavaToIOSMethodTranslator;
import com.google.devtools.j2objc.translate.NilCheckResolver;
import com.google.devtools.j2objc.translate.OcniExtractor;
import com.google.devtools.j2objc.translate.OperatorRewriter;
import com.google.devtools.j2objc.translate.OuterReferenceFixer;
import com.google.devtools.j2objc.translate.OuterReferenceResolver;
import com.google.devtools.j2objc.translate.Rewriter;
import com.google.devtools.j2objc.translate.StaticVarRewriter;
import com.google.devtools.j2objc.translate.TypeSorter;
import com.google.devtools.j2objc.translate.UnsequencedExpressionRewriter;
import com.google.devtools.j2objc.translate.VarargsRewriter;
import com.google.devtools.j2objc.translate.VariableRenamer;
import com.google.devtools.j2objc.types.HeaderImportCollector;
import com.google.devtools.j2objc.types.IOSTypeBinding;
import com.google.devtools.j2objc.types.ImplementationImportCollector;
import com.google.devtools.j2objc.types.Import;
import com.google.devtools.j2objc.util.DeadCodeMap;
import com.google.devtools.j2objc.util.ErrorUtil;
import com.google.devtools.j2objc.util.FileUtil;
import com.google.devtools.j2objc.util.JdtParser;
import com.google.devtools.j2objc.util.NameTable;
import com.google.devtools.j2objc.util.PathClassLoader;
import com.google.devtools.j2objc.util.TimeTracker;

import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.processing.Processor;

/**
 * Processes source files by translating each source into an Objective-C header
 * and an Objective-C source file.
 *
 * @author Tom Ball, Keith Stanger
 */
class TranslationProcessor extends FileProcessor {

  private static final Logger logger = Logger.getLogger(TranslationProcessor.class.getName());

  private final DeadCodeMap deadCodeMap;

  Queue<InputFile> pendingFiles = new ArrayDeque<InputFile>();

  /*
  The below two sets assist in building the transitive closure.

  When building the transitive closure of files we need to process,
  we look up these files on the source paths by their estimated compilation unit name.
  This is something like path/to/package/ClassName.java . It's assumed that this will be the
  directory of a file relative to some source file root. For files supplied as arguments,
  where the name of the file may differ from the correct compilation unit path,
  this path is calculated with getRelativePath(String, CompilationUnit). For files built
  in the transitive closure, this is always the relative path of the file
  (otherwise we would never have found it).

  The sets processedFiles and seenFiles track the compilation unit names of files we've already
  processed and seen, respectively. These are used to deduplicate source files so we never process
  a given compilation unit more than once. For some use cases, this is important, like if
  we supply a source or input file that overrides files later on the source file paths.

  TODO(user): Consider whether this logic is correct; in particular, the potential problem of
  depending on InputFiles to have the correct java relative path returned by #getUnitName().
  Right now, this fulfills expected behavior and passes tests. See discussion on cl/86308318 .
   */

  // Relative paths of files that have been processed.
  Set<String> processedFiles = Sets.newHashSet();
  // Relative paths of files that have either been processed or added to pendingfiles.
  Set<String> seenFiles = Sets.newHashSet();

  public TranslationProcessor(JdtParser parser, DeadCodeMap deadCodeMap) {
    super(parser);
    this.deadCodeMap = deadCodeMap;
  }

  @Override
  public void processFiles(Iterable<String> files) {
    if (hasAnnotationProcessors()) {
      processAnnotations(files);
    }

    loadHeaderMappings();

    if (ErrorUtil.errorCount() > 0) {
      // True if any classpath entry is malformed, or batch compilation failed.
      System.exit(ErrorUtil.errorCount());
    }

    super.processFiles(files);
    while (!pendingFiles.isEmpty()) {
      InputFile file = pendingFiles.remove();
      if (!processedFiles.contains(file.getUnitName())) {
        processSource(file);
      }
    }
  }

  private void processAnnotations(Iterable<String> files) {
    File tmpDirectory;
    try {
      tmpDirectory = createTmpDir();
    } catch (IOException e) {
      ErrorUtil.error("failed creating temporary directory: " + e);
      return;
    }
    String tmpDirPath = tmpDirectory.getAbsolutePath();
    List<String> compileArgs = Lists.newArrayList();
    Joiner pathJoiner = Joiner.on(":");
    List<String> sourcePath = Options.getSourcePathEntries();
    sourcePath.add(tmpDirPath);
    compileArgs.add("-sourcepath");
    compileArgs.add(pathJoiner.join(sourcePath));
    compileArgs.add("-classpath");
    List<String> classPath = Options.getClassPathEntries();
    compileArgs.add(pathJoiner.join(classPath));
    compileArgs.add("-encoding");
    compileArgs.add(Options.getCharset().name());
    compileArgs.add("-source");
    compileArgs.add("1.7");
    compileArgs.add("-s");
    compileArgs.add(tmpDirPath);
    if (Options.isVerbose()) {
      compileArgs.add("-XprintProcessorInfo");
    }
    for (String file : files) {
      compileArgs.add(file);
    }
    Map<String, String> batchOptions = Maps.newHashMap();
    batchOptions.put(CompilerOptions.OPTION_Process_Annotations, CompilerOptions.ENABLED);
    batchOptions.put(CompilerOptions.OPTION_GenerateClassFiles, CompilerOptions.DISABLED);
    // Fully qualified name used since "Main" isn't descriptive.
    org.eclipse.jdt.internal.compiler.batch.Main batchCompiler =
        new org.eclipse.jdt.internal.compiler.batch.Main(
            new PrintWriter(System.out), new PrintWriter(System.err), false, batchOptions, null);
    if (!batchCompiler.compile(compileArgs.toArray(new String[0]))) {
      // Any compilation errors will already by displayed.
      ErrorUtil.error("failed batch processing sources");
    } else {
      getParser().addSourcepathEntry(tmpDirPath);
      addGeneratedSources(tmpDirectory, "");
    }
  }

  private static File createTmpDir() throws IOException {
    File tmpDirectory = new File("/tmp/annotation_processing");
    if (!tmpDirectory.mkdir() && !tmpDirectory.exists()) {
      File tmpRoot = File.createTempFile("foo", "bar").getParentFile();
      tmpDirectory = new File(tmpRoot, "annotation_processing");
      tmpDirectory.mkdir();
    }
    return tmpDirectory;
  }

  private void addGeneratedSources(File dir, String currentRelativePath) {
    assert dir.exists() && dir.isDirectory();
    for (File f : dir.listFiles()) {
      String relativeName = currentRelativePath + File.separatorChar + f.getName();
      if (f.isDirectory()) {
        addGeneratedSources(f, relativeName);
      } else {
        if (f.getName().endsWith(".java")) {
          pendingFiles.add(new RegularInputFile(f.getPath(), relativeName));
        }
      }
    }
  }

  @Override
  protected void processSource(InputFile file, String source) {
    if (logger.isLoggable(Level.INFO)) {
      System.out.println("translating " + file.getPath());
    }
    super.processSource(file, source);
  }

  @Override
  protected void processUnit(
      InputFile file, String source, org.eclipse.jdt.core.dom.CompilationUnit unit,
      TimeTracker ticker) {
    String relativePath = getRelativePath(file.getUnitName(), unit);
    processedFiles.add(relativePath);
    seenFiles.add(relativePath);

    CompilationUnit newUnit = TreeConverter.convertCompilationUnit(unit, file, source);

    applyMutations(newUnit, deadCodeMap, ticker);
    ticker.tick("Tree mutations");

    if (unit.types().isEmpty() && !newUnit.getMainTypeName().endsWith("package_info")) {
      logger.finest("skipping dead file " + file.getPath());
      return;
    }

    logger.finest("writing output file(s) to " + Options.getOutputDirectory().getAbsolutePath());

    GenerationUnit generationUnit = GenerationUnit.fromSingleFile(
        file, newUnit, getOutputFileName(file, newUnit));

    generateObjectiveCSource(generationUnit, ticker);
    ticker.tick("Source generation");

    if (Options.buildClosure()) {
      // Add out-of-date dependencies to translation list.
      checkDependencies(newUnit);
    }

    OuterReferenceResolver.cleanup();
  }

  /**
   * Translates a parsed source file, modifying the compilation unit by
   * substituting core Java type and method references with iOS equivalents.
   * For example, <code>java.lang.Object</code> maps to <code>NSObject</code>,
   * and <code>java.lang.String</code> to <code>NSString</code>. The source is
   * also modified to add support for iOS memory management, extract inner
   * classes, etc.
   */
  public static void applyMutations(
      CompilationUnit unit, DeadCodeMap deadCodeMap, TimeTracker ticker) {
    ticker.push();

    if (deadCodeMap != null) {
      new DeadCodeEliminator(unit, deadCodeMap).run(unit);
      ticker.tick("DeadCodeEliminator");
    }

    OuterReferenceResolver.resolve(unit);
    ticker.tick("OuterReferenceResolver");

    // Update code that has GWT references.
    new GwtConverter().run(unit);
    ticker.tick("GwtConverter");

    // Modify AST to be more compatible with Objective C
    new Rewriter().run(unit);
    ticker.tick("Rewriter");

    // Add abstract method stubs.
    new AbstractMethodRewriter(unit).run(unit);
    ticker.tick("AbstractMethodRewriter");

    new VariableRenamer().run(unit);
    ticker.tick("VariableRenamer");

    // Rewrite enhanced for loops into correct C code.
    new EnhancedForRewriter().run(unit);
    ticker.tick("EnhancedForRewriter");

    // Add auto-boxing conversions.
    new Autoboxer().run(unit);
    ticker.tick("Autoboxer");

    // Extract inner and anonymous classes
    new AnonymousClassConverter().run(unit);
    ticker.tick("AnonymousClassConverter");
    new InnerClassExtractor(unit).run(unit);
    ticker.tick("InnerClassExtractor");

    // Normalize init statements
    new InitializationNormalizer().run(unit);
    ticker.tick("InitializationNormalizer");

    // Fix references to outer scope and captured variables.
    new OuterReferenceFixer().run(unit);
    ticker.tick("OuterReferenceFixer");

    // Rewrites expressions that would cause unsequenced compile errors.
    if (Options.extractUnsequencedModifications()) {
      new UnsequencedExpressionRewriter().run(unit);
      ticker.tick("UnsequencedExpressionRewriter");
    }

    // Adds nil_chk calls wherever an expression is dereferenced.
    new NilCheckResolver().run(unit);
    ticker.tick("NilCheckResolver");

    // Before: ArrayRewriter - Adds ArrayCreation nodes.
    // Before: Functionizer - Can't rewrite function arguments.
    new VarargsRewriter().run(unit);
    ticker.tick("VarargsRewriter");

    // Reorders the types so that superclasses are declared before classes that
    // extend them.
    TypeSorter.sortTypes(unit);
    ticker.tick("TypeSorter");

    // Add dealloc/finalize method(s), if necessary.  This is done
    // after inner class extraction, so that each class releases
    // only its own instance variables.
    new DestructorGenerator().run(unit);
    ticker.tick("DestructorGenerator");

    new JavaCloneWriter().run(unit);
    ticker.tick("JavaCloneWriter");

    new ConstantBranchPruner().run(unit);
    ticker.tick("ConstantBranchPruner");

    new OcniExtractor(unit).run(unit);
    ticker.tick("OcniExtractor");

    // After: OcniExtractor - So that native methods can be correctly
    //   functionized.
    new Functionizer().run(unit);
    ticker.tick("Functionizer");

    // After: Functionizer - Changes bindings on MethodDeclaration nodes.
    // Before: StaticVarRewriter, OperatorRewriter - Doesn't know how to handle
    //   the hasRetainedResult flag on ClassInstanceCreation nodes.
    new JavaToIOSMethodTranslator(Options.getMethodMappings()).run(unit);
    ticker.tick("JavaToIOSMethodTranslator");

    new StaticVarRewriter().run(unit);
    ticker.tick("StaticVarRewriter");

    new OperatorRewriter().run(unit);
    ticker.tick("OperatorRewriter");

    // After: StaticVarRewriter, OperatorRewriter - They set the
    //   hasRetainedResult on ArrayCreation nodes.
    new ArrayRewriter().run(unit);
    ticker.tick("ArrayRewriter");

    new EnumRewriter().run(unit);
    ticker.tick("EnumRewriter");

    // Breaks up deeply nested expressions such as chained method calls.
    // Should be one of the last translations because other mutations will
    // affect how deep the expressions are.
    new ComplexExpressionExtractor().run(unit);
    ticker.tick("ComplexExpressionExtractor");

    // Should be one of the last translations because methods and functions
    // added in other phases may need added casts.
    new CastResolver().run(unit);
    ticker.tick("CastResolver");

    for (Plugin plugin : Options.getPlugins()) {
      plugin.processUnit(unit);
    }

    // Make sure we still have a valid AST.
    unit.validate();

    ticker.pop();
  }

  /**
   * Returns an output file name appropriate for this CompilationUnit.
   * For example,
   * foo/bar/Mumble.java translates to $(OUTPUT_DIR)/foo/bar/Mumble.m for
   * Objective-C implementation files.  If --no-package-directories is
   * specified, though, the output file is $(OUTPUT_DIR)/Mumble.m.
   * <p>
   * Note: class names are still camel-cased to avoid name collisions.
   */
  static String getOutputFileName(InputFile file, CompilationUnit node) {
    String result;
    if (Options.useSourceDirectories()) {
      result = file.getUnitName();
    } else {
      PackageDeclaration pkg = node.getPackage();
      if (Options.usePackageDirectories() && !pkg.isDefaultPackage()) {
        result = pkg.getName().getFullyQualifiedName().replace('.', File.separatorChar)
            + File.separatorChar + node.getMainTypeName();
      } else {
        result = node.getMainTypeName();
      }
    }

    // Make sure the name is legal...
    if (node.getMainTypeName().equals(NameTable.PACKAGE_INFO_MAIN_TYPE)) {
      return result.replace(NameTable.PACKAGE_INFO_MAIN_TYPE, NameTable.PACKAGE_INFO_FILE_NAME);
    }
    return result;
  }

  public static void generateObjectiveCSource(GenerationUnit unit, TimeTracker ticker) {
    ticker.push();

    // write header
    if (Options.generateSegmentedHeaders()) {
      ObjectiveCSegmentedHeaderGenerator.generate(unit);
    } else {
      ObjectiveCHeaderGenerator.generate(unit);
    }
    ticker.tick("Header generation");

    // write implementation file
    ObjectiveCImplementationGenerator.generate(unit);
    ticker.tick("Implementation generation");

    ticker.pop();
  }

  public void postProcess() {
    for (Plugin plugin : Options.getPlugins()) {
      plugin.endProcessing(Options.getOutputDirectory());
    }

    printHeaderMappings();

    if (logger.isLoggable(Level.INFO)) {
      int nFiles = processedFiles.size();
      System.out.println(String.format(
          "Translated %d %s: %d errors, %d warnings",
          nFiles, nFiles == 1 ? "file" : "files", ErrorUtil.errorCount(),
          ErrorUtil.warningCount()));
      if (Options.finalMethodsAsFunctions()) {
        System.out.println(String.format("Translated %d methods as functions",
            ErrorUtil.functionizedMethodCount()));
      }
    }
  }

  private void checkDependencies(CompilationUnit unit) {
    HeaderImportCollector hdrCollector = new HeaderImportCollector();
    hdrCollector.collect(unit);
    ImplementationImportCollector implCollector = new ImplementationImportCollector();
    implCollector.collect(unit);
    Set<Import> imports = hdrCollector.getForwardDeclarations();
    imports.addAll(hdrCollector.getSuperTypes());
    imports.addAll(implCollector.getImports());
    for (Import imp : imports) {
      maybeAddToClosure(imp.getType());
    }
  }

  private void maybeAddToClosure(ITypeBinding type) {
    if (type instanceof IOSTypeBinding) {
      return;  // Ignore core types.
    }
    String typeName = type.getErasure().getQualifiedName();
    String sourceName = typeName.replace('.', File.separatorChar) + ".java";
    if (seenFiles.contains(sourceName)) {
      return;
    }
    seenFiles.add(sourceName);

    // Check if source file exists.
    String originalTypeName = typeName;
    InputFile inputFile = null;
    try {
      inputFile = FileUtil.findOnSourcePath(sourceName);
    } catch (IOException e) {
      ErrorUtil.warning(e.getMessage());
    }
    while (inputFile == null && !sourceName.isEmpty()) {
      // Check if class exists on classpath.
      // We iteratively slice parts off the typeName until it's exhausted.
      if (findClassFile(typeName)) {
        logger.finest("no source for " + typeName + ", class found");
        return;
      }
      int iDot = typeName.lastIndexOf('.');
      if (iDot == -1) {
        // No more parts to slice.
        ErrorUtil.warning("could not find source path for " + originalTypeName);
        return;
      }
      typeName = typeName.substring(0, iDot);
      sourceName = typeName.replace('.', File.pathSeparatorChar) + ".java";
      if (seenFiles.contains(sourceName)) {
        return;
      }
      try {
        inputFile = FileUtil.findOnSourcePath(sourceName);
      } catch (IOException e) {
        ErrorUtil.warning(e.getMessage());
      }
    }

    // Check if the source file is older than the generated header file.
    File headerSource = new File(Options.getOutputDirectory(), sourceName.replace(".java", ".h"));
    if (headerSource.exists() && inputFile != null
        && inputFile.lastModified() < headerSource.lastModified()) {
      return;
    }
    pendingFiles.add(inputFile);
  }

  private boolean findClassFile(String typeName) {
    // Zip/jar files always use forward slashes.
    String path = typeName.replace('.', '/') + ".class";
    InputFile f = null;
    try {
      f = FileUtil.findOnSourcePath(path);
    } catch (IOException e) {
      ErrorUtil.warning(e.getMessage());
    }
    if (f != null) {
      return true;
    }
    // See if it's a JRE class.
    try {
      Class.forName(typeName);
      return true;
    } catch (ClassNotFoundException e) {
      // Fall-through.
    }
    return false;
  }

  static void printHeaderMappings() {
    if (Options.getOutputHeaderMappingFile() != null) {
      Map<String, String> headerMappings = Options.getHeaderMappings();
      File outputMappingFile = Options.getOutputHeaderMappingFile();

      try {
        if (!outputMappingFile.exists()) {
          outputMappingFile.getParentFile().mkdirs();
          outputMappingFile.createNewFile();
        }
        PrintWriter writer = new PrintWriter(outputMappingFile);

        for (String className : headerMappings.keySet()) {
          writer.println(String.format("%s=%s", className, headerMappings.get(className)));
        }

        writer.close();
      } catch (IOException e) {
        ErrorUtil.error(e.getMessage());
      }
    }
  }

  static void loadHeaderMappings() {
    Map<String, String> headerMappings = Options.getHeaderMappings();

    List<String> headerMappingFiles = Options.getHeaderMappingFiles();
    List<Properties> headerMappingProps = new ArrayList<Properties>();

    try {
      if (headerMappingFiles == null) {
        try {
          headerMappingProps.add(FileUtil.loadProperties(Options.DEFAULT_HEADER_MAPPING_FILE));
        } catch (FileNotFoundException e) {
          // Don't fail if mappings aren't configured and the default mapping is absent.
        }
      } else {
        for (String resourceName : headerMappingFiles) {
          headerMappingProps.add(FileUtil.loadProperties(resourceName));
        }
      }
    } catch (IOException e) {
      ErrorUtil.error(e.getMessage());
    }

    for (Properties mappings : headerMappingProps) {
      Enumeration<?> keyIterator = mappings.propertyNames();
      while (keyIterator.hasMoreElements()) {
        String key = (String) keyIterator.nextElement();
        headerMappings.put(key, mappings.getProperty(key));
      }
    }
  }

  /**
   * Check whether any javax.annotation.processing.Processor services are defined on
   * the declared classpath. This is checked here to avoid batch compiling sources
   * in case any might have annotations that should be processed.
   */
  private boolean hasAnnotationProcessors() {
    ServiceLoader<Processor> serviceLoader = ServiceLoader.load(
        Processor.class, new PathClassLoader(Options.getClassPathEntries()));
    Iterator<Processor> iterator = serviceLoader.iterator();
    return iterator.hasNext();
  }
}
