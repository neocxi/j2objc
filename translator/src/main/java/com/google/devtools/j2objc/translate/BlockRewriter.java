package com.google.devtools.j2objc.translate;

import com.google.common.collect.Lists;
import com.google.devtools.j2objc.ast.AnonymousClassDeclaration;
import com.google.devtools.j2objc.ast.Assignment;
import com.google.devtools.j2objc.ast.Block;
import com.google.devtools.j2objc.ast.BodyDeclaration;
import com.google.devtools.j2objc.ast.ClassInstanceCreation;
import com.google.devtools.j2objc.ast.ConditionalExpression;
import com.google.devtools.j2objc.ast.Expression;
import com.google.devtools.j2objc.ast.InfixExpression;
import com.google.devtools.j2objc.ast.MethodDeclaration;
import com.google.devtools.j2objc.ast.NativeStatement;
import com.google.devtools.j2objc.ast.NullLiteral;
import com.google.devtools.j2objc.ast.SimpleName;
import com.google.devtools.j2objc.ast.SimpleType;
import com.google.devtools.j2objc.ast.SingleVariableDeclaration;
import com.google.devtools.j2objc.ast.Statement;
import com.google.devtools.j2objc.ast.TreeVisitor;
import com.google.devtools.j2objc.ast.TypeDeclaration;
import com.google.devtools.j2objc.ast.VariableDeclarationFragment;
import com.google.devtools.j2objc.ast.VariableDeclarationStatement;
import com.google.devtools.j2objc.types.GeneratedMethodBinding;
import com.google.devtools.j2objc.types.GeneratedTypeBinding;
import com.google.devtools.j2objc.types.GeneratedVariableBinding;
import com.google.devtools.j2objc.types.IOSBlockTypeBinding;
import com.google.devtools.j2objc.types.IOSTypeBinding;
import com.google.devtools.j2objc.types.Types;
import com.google.devtools.j2objc.util.BindingUtil;
import com.google.j2objc.annotations.Representing;

import org.eclipse.jdt.core.dom.IAnnotationBinding;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.IVariableBinding;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Generated;
import javax.naming.Binding;

/**
 * This class only handles the rewriting of block parameter into corresponding Java class
 */
public class BlockRewriter extends TreeVisitor {

  public static int blockCounter = 0;

  @Override
  public boolean visit(TypeDeclaration node) {
    return !BindingUtil.isAdapter(node.getTypeBinding()) && !BindingUtil.isMappedToNative(node.getTypeBinding());
  }

  @Override
  public void endVisit(MethodDeclaration node) {
    IMethodBinding binding = node.getMethodBinding();

    for (int i = 0; i < binding.getParameterTypes().length; i++) {
      IAnnotationBinding annotation = BindingUtil.getAnnotation(
          binding.getParameterAnnotations(i), com.google.j2objc.annotations.Block.class);
      if (annotation != null) {
        Block body = node.getBody();
        // allow for native methods
        if (body != null) {
          insertBlockWrappingStatement(node.getBody(), node, annotation, i);
        }
      }
    }
  }

  private void insertBlockWrappingStatement(
      Block body, MethodDeclaration node, IAnnotationBinding annotation, int i) {
    IMethodBinding binding = node.getMethodBinding();
    IAnnotationBinding blockAnno = BindingUtil.getAnnotation(
        binding.getParameterAnnotations(i),
        com.google.j2objc.annotations.Block.class
    );
    ITypeBinding blockTpe = binding.getParameterTypes()[i];

    String[] argObjs = BindingUtil.BlockBridge.paramTypes(blockAnno, blockTpe);
    List<String> args = Lists.newArrayList();
    for (Object argObj : argObjs) {
      args.add((String) argObj);
    }
    IOSBlockTypeBinding nativeBlockType = BindingUtil.getBlockType(
        binding.getParameterAnnotations(i),
        blockTpe
    );
    assert nativeBlockType != null;

    ITypeBinding blockInterfaceType = binding.getParameterTypes()[i];
    IMethodBinding runMethod = BindingUtil.BlockBridge.runMethod(blockAnno, blockInterfaceType);

    // rewrite the parameter's type to be the native block type
    // TODO: this approach here has a problem, it messes up the binding info, the new method's
    //  declaring class doesn't contain this new method
    GeneratedMethodBinding newMethodBinding = new GeneratedMethodBinding(binding, true);
    newMethodBinding.setParameter(i, nativeBlockType);
    node.setMethodBinding(newMethodBinding);
    SingleVariableDeclaration oldVarDecl = node.getParameters().get(i);
    SingleVariableDeclaration newVarDecl =
        new SingleVariableDeclaration(oldVarDecl);
    newVarDecl.setType(new SimpleType(nativeBlockType));
    IVariableBinding oldVarBinding = newVarDecl.getVariableBinding();
    GeneratedVariableBinding newVarBinding =
        new GeneratedVariableBinding(oldVarBinding.getName(), oldVarBinding.getModifiers(),
                                     nativeBlockType, oldVarBinding.isField(), oldVarBinding.isParameter(),
                                     oldVarBinding.getDeclaringClass(), oldVarBinding.getDeclaringMethod());
    newVarDecl.setVariableBinding(newVarBinding);
    node.getParameters().set(i, newVarDecl);

    // ignore generic version for now

    GeneratedMethodBinding methodBinding = new GeneratedMethodBinding(runMethod, true);

    methodBinding.setModifiers(0);
    MethodDeclaration method = new MethodDeclaration(methodBinding, /*copyParam*/ true);

    final String blockLocalId = "__$block";
    StringBuilder blockCall = new StringBuilder();
    String blockRet = BindingUtil.BlockBridge.returnType(blockAnno, blockTpe);
    if (!blockRet.equals("void")) {
      blockCall.append("return ");
    }

    blockCall.append(blockLocalId);
    blockCall.append("(");
    boolean first = true;
    for (SingleVariableDeclaration var : method.getParameters()) {
      if (first) {
        first = false;
      } else {
        blockCall.append(", ");
      }
      blockCall.append(var.getName());
    }
    blockCall.append(");");

    final IVariableBinding originalVarBinding = node.getParameters().get(i).getVariableBinding();
    NativeStatement nativeInvoke = new NativeStatement(blockCall.toString());
    method.setBody(new Block());
    method.getBody().getStatements().add(
      new VariableDeclarationStatement(
        new GeneratedVariableBinding(blockLocalId, 0, nativeBlockType, false, false, null,
                                     method.getMethodBinding()),
        new SimpleName(originalVarBinding)
    ));
    method.getBody().getStatements().add(nativeInvoke);

    GeneratedTypeBinding blockTypeBinding =
        new GeneratedTypeBinding(
            "$block" + (BlockRewriter.blockCounter++), binding.getDeclaringClass().getPackage(), Types.getNSObject(),
            false, null, binding.getDeclaringClass()
        );
    blockTypeBinding.addInterface(blockInterfaceType);
    blockTypeBinding.addMethod(method.getMethodBinding());

    AnonymousClassDeclaration anon =
        new AnonymousClassDeclaration(blockTypeBinding, Lists.newArrayList((BodyDeclaration) method));
    ClassInstanceCreation newObj =
        new ClassInstanceCreation(
            new GeneratedMethodBinding(null, "<init>", 0, Types.instance.ast.resolveWellKnownType("java.lang.Void"), null, blockTypeBinding, true, false),
            false /* think about it*/, null,
            new SimpleType(blockInterfaceType), new LinkedList<Expression>(), anon);
    ConditionalExpression nullWraper =
        new ConditionalExpression(
            blockInterfaceType,
            new InfixExpression(
                Types.instance.ast.resolveWellKnownType("boolean"),
                InfixExpression.Operator.EQUALS,
                new NullLiteral(),
                new SimpleName(originalVarBinding)
            ),
            new NullLiteral(),
            newObj
        );

    final String wrappedBlockIdent = "__wrapped_" + node.getParameters().get(i).getName();
    final GeneratedVariableBinding wrappedBlockBinding =
        new GeneratedVariableBinding(wrappedBlockIdent, 0, blockInterfaceType, false, false, null, binding);
    VariableDeclarationFragment varDecl =
        new VariableDeclarationFragment(wrappedBlockBinding, nullWraper);
    List<Statement> stmts = body.getStatements();

    // rewrite all the references to original parameter
    TreeVisitor bindingRewriter = new TreeVisitor() {
      @Override
      public void endVisit(SimpleName node) {
        IBinding thisType = node.getBinding();
        if (thisType.getName().equals(originalVarBinding.getName())) {
          node.setBinding(wrappedBlockBinding);
          node.setIdentifier(wrappedBlockIdent);
        }
      }
    };

    for (Statement stmt : stmts) {
      stmt.accept(bindingRewriter);
    }

    stmts.add(0, new VariableDeclarationStatement(varDecl));
  }
}
