package apple.corefoundation;


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
import apple.dispatch.*;
import apple.foundation.*;


/*<javadoc>*/
/*</javadoc>*/
@Library("CoreFoundation/CoreFoundation.h")
public class CFStreamPair 
    extends Object 
     {

    
    
    
    
    
    @GlobalFunction("CFStreamCreateBoundPair")
    protected static native void create(CFAllocator alloc, Todo readStream, Todo writeStream, @MachineSizedSInt long transferBufferSize);
    @GlobalFunction("CFStreamCreatePairWithSocket")
    protected static native void create(CFAllocator alloc, int sock, Todo readStream, Todo writeStream);
    @GlobalFunction("CFStreamCreatePairWithSocketToHost")
    protected static native void create(CFAllocator alloc, String host, int port, Todo readStream, Todo writeStream);
    @GlobalFunction("CFStreamCreatePairWithPeerSocketSignature")
    protected static native void create(CFAllocator alloc, CFSocketSignature signature, Todo readStream, Todo writeStream);
    
}
