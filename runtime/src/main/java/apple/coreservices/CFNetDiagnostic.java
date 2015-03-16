package apple.coreservices;


import java.io.*;
import java.nio.*;
import java.util.*;
import com.google.j2objc.annotations.*;
import com.google.j2objc.runtime.*;
import com.google.j2objc.runtime.block.*;
import apple.audiotoolbox.*;
import apple.corefoundation.*;
import apple.coregraphics.*;
import apple.coreservices.*;
import apple.foundation.*;


/*<javadoc>*/
/*</javadoc>*/
@Library("CFNetwork/CFNetwork.h")
public class CFNetDiagnostic 
    extends CFType 
     {

    
    
    protected CFNetDiagnostic() {}
    
    
    
    
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalFunction("CFNetDiagnosticCreateWithStreams")
    protected static native CFNetDiagnostic create(CFAllocator alloc, CFReadStream readStream, CFWriteStream writeStream);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalFunction("CFNetDiagnosticCreateWithURL")
    protected static native CFNetDiagnostic create(CFAllocator alloc, NSURL url);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalFunction("CFNetDiagnosticSetName")
    public static native void setName(CFNetDiagnostic details, String name);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalFunction("CFNetDiagnosticDiagnoseProblemInteractively")
    public static native CFNetDiagnosticStatus diagnoseProblemInteractively(CFNetDiagnostic details);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalFunction("CFNetDiagnosticCopyNetworkStatusPassively")
    protected static native CFNetDiagnosticStatus getNetworkStatusPassively(CFNetDiagnostic details, Todo description);
    
}
