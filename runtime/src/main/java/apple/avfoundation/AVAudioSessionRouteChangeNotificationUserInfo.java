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
public class AVAudioSessionRouteChangeNotificationUserInfo 
    extends Object 
     {

    
    
    
    
    
    /**
     * @since Available in iOS 6.0 and later.
     */
    @GlobalConstant("AVAudioSessionRouteChangeReasonKey")
    public static native String ReasonKey();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @GlobalConstant("AVAudioSessionRouteChangePreviousRouteKey")
    public static native String PreviousRouteKey();

}
