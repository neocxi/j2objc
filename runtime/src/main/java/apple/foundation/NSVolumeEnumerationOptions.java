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



/**
 * @since Available in iOS 4.0 and later.
 */

@Library("Foundation/Foundation.h")
@Mapping("NSVolumeEnumerationOptions")
public final class NSVolumeEnumerationOptions extends ObjCEnum {
    
    @GlobalConstant("NSVolumeEnumerationSkipHiddenVolumes")
    public static final long SkipHiddenVolumes = 2L;
    @GlobalConstant("NSVolumeEnumerationProduceFileReferenceURLs")
    public static final long ProduceFileReferenceURLs = 4L;
    

}
