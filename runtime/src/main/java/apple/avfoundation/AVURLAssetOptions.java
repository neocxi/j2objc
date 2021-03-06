package apple.avfoundation;


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
import apple.coreanimation.*;
import apple.coreaudio.*;
import apple.coremedia.*;
import apple.corevideo.*;
import apple.mediatoolbox.*;

/*<javadoc>*/
/*</javadoc>*/
@Library("AVFoundation/AVFoundation.h")
public class AVURLAssetOptions 
    extends Object 
     {

    
    
    
    
    
    /**
     * @since Available in iOS 4.0 and later.
     */
    @GlobalConstant("AVURLAssetPreferPreciseDurationAndTimingKey")
    public static native String PreferPreciseDurationAndTimingKey();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @GlobalConstant("AVURLAssetReferenceRestrictionsKey")
    public static native String ReferenceRestrictionsKey();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @GlobalConstant("AVURLAssetHTTPCookiesKey")
    public static native String HTTPCookiesKey();

}
