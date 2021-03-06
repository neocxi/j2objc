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
public class AVVideoCleanAperture 
    extends Object 
     {

    
    
    
    
    
    /**
     * @since Available in iOS 4.0 and later.
     */
    @GlobalConstant("AVVideoCleanApertureWidthKey")
    public static native String WidthKey();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @GlobalConstant("AVVideoCleanApertureHeightKey")
    public static native String HeightKey();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @GlobalConstant("AVVideoCleanApertureHorizontalOffsetKey")
    public static native String HorizontalOffsetKey();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @GlobalConstant("AVVideoCleanApertureVerticalOffsetKey")
    public static native String VerticalOffsetKey();

}
