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
@Library("Foundation")
public class NSURLProtectionSpaceProtocol 
    extends Object 
     {

    
    
    
    
    
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalConstant("NSURLProtectionSpaceHTTP")
    protected static native NSString HTTPValue();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalConstant("NSURLProtectionSpaceHTTPS")
    protected static native NSString HTTPSValue();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalConstant("NSURLProtectionSpaceFTP")
    protected static native NSString FTPValue();
    
}
