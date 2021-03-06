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

/*<javadoc>*/
/*</javadoc>*/
@Library("Foundation/Foundation.h")
public class NSStreamNetworkServiceType 
    extends Object 
     {

    
    
    
    
    
    /**
     * @since Available in iOS 4.0 and later.
     */
    @GlobalConstant("NSStreamNetworkServiceTypeVoIP")
    public static native NSString VoIPValue();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @GlobalConstant("NSStreamNetworkServiceTypeVideo")
    public static native NSString VideoValue();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @GlobalConstant("NSStreamNetworkServiceTypeBackground")
    public static native NSString BackgroundValue();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @GlobalConstant("NSStreamNetworkServiceTypeVoice")
    public static native NSString VoiceValue();

}
