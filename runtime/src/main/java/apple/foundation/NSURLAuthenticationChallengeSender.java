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


@Library("Foundation/Foundation.h") @Mapping("NSURLAuthenticationChallengeSender")
public interface NSURLAuthenticationChallengeSender 
    extends NSObjectProtocol {

    
    


    
    @Mapping("useCredential:forAuthenticationChallenge:")
    void useCredential(NSURLCredential credential, NSURLAuthenticationChallenge challenge);
    @Mapping("continueWithoutCredentialForAuthenticationChallenge:")
    void continueWithoutCredential(NSURLAuthenticationChallenge challenge);
    @Mapping("cancelAuthenticationChallenge:")
    void cancel(NSURLAuthenticationChallenge challenge);
    @Mapping("performDefaultHandlingForAuthenticationChallenge:")
    void performDefaultHandling(NSURLAuthenticationChallenge challenge);
    @Mapping("rejectProtectionSpaceAndContinueWithChallenge:")
    void rejectProtectionSpaceAndContinue(NSURLAuthenticationChallenge challenge);

    /*<adapter>*/
    /*</adapter>*/
}
