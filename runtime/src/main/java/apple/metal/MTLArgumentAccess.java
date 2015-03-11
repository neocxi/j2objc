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


@Mapping("MTLArgumentAccess")
public final class MTLArgumentAccess extends ObjCEnum {
    
    @GlobalConstant("MTLArgumentAccessReadOnly")
    public static final long ReadOnly = 0L;
    @GlobalConstant("MTLArgumentAccessReadWrite")
    public static final long ReadWrite = 1L;
    @GlobalConstant("MTLArgumentAccessWriteOnly")
    public static final long WriteOnly = 2L;
    

}
