package apple.foundation;


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
import apple.uikit.*;
import apple.coreanimation.*;
import apple.coredata.*;
import apple.coremedia.*;
import apple.security.*;
import apple.dispatch.*;





@Library("Foundation") @Mapping("NSKeyedArchiver")
public class NSKeyedArchiver 
    extends NSCoder 
     {

    
    
    public NSKeyedArchiver() {}
    @Mapping("initForWritingWithMutableData:")
    public NSKeyedArchiver(NSMutableData data) { }
    
    
    @Mapping("delegate")
    public native NSKeyedArchiverDelegate getDelegate();
    public native void setDelegate(NSKeyedArchiverDelegate v);
    @Mapping("outputFormat")
    public native @Representing("NSPropertyListFormat") @MachineSizedUInt long getOutputFormat();
    public native void setOutputFormat(@Representing("NSPropertyListFormat") @MachineSizedUInt long v);
    
    
    
    /**
     * @since Available in iOS 7.0 and later.
     */
    @GlobalConstant("NSKeyedArchiveRootObjectKey")
    public static native String ArchiveRootObjectKey();
    
    @Mapping("finishEncoding")
    public native void finishEncoding();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Mapping("setRequiresSecureCoding:")
    public native void setRequiresSecureCoding(boolean b);
    @Mapping("archivedDataWithRootObject:")
    public static native NSData archive(Object rootObject);
    @Mapping("archiveRootObject:toFile:")
    private static native boolean archiveRootObject(Object rootObject, String path);
    
}
