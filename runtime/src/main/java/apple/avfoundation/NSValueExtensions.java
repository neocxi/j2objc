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
public final class NSValueExtensions 
    extends NSExtensions 
     {

    
    
    private NSValueExtensions() {}
    
    
    
    
    
    
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Mapping("valueWithCMTime:")
    public static native NSValue create(CMTime time);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Mapping("valueWithCMTimeRange:")
    public static native NSValue create(CMTimeRange timeRange);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Mapping("valueWithCMTimeMapping:")
    public static native NSValue create(CMTimeMapping timeMapping);
    
}