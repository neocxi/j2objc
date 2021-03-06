package apple.accounts;


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

/*<javadoc>*/
/*</javadoc>*/
@Library("Accounts/Accounts.h")
public class ACFacebookAudience 
    extends Object 
     {

    
    
    
    
    
    /**
     * @since Available in iOS 6.0 and later.
     */
    @GlobalConstant("ACFacebookAudienceEveryone")
    public static native NSString EveryoneValue();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @GlobalConstant("ACFacebookAudienceFriends")
    public static native NSString FriendsValue();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @GlobalConstant("ACFacebookAudienceOnlyMe")
    public static native NSString OnlyMeValue();

}
