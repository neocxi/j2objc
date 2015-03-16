package apple.metal;


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
import apple.dispatch.*;



/**
 * @since Available in iOS 8.0 and later.
 */

@Library("Metal/Metal.h")
@Mapping("MTLVertexStepFunction")
public final class MTLVertexStepFunction extends ObjCEnum {
    
    @GlobalConstant("MTLVertexStepFunctionConstant")
    public static final long Constant = 0L;
    @GlobalConstant("MTLVertexStepFunctionPerVertex")
    public static final long PerVertex = 1L;
    @GlobalConstant("MTLVertexStepFunctionPerInstance")
    public static final long PerInstance = 2L;
    

}
