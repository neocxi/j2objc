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


@Library("Foundation/Foundation.h") @Mapping("NSHTTPCookie")
public class NSHTTPCookie 
    extends NSObject 
     {

    
    
    @Mapping("initWithProperties:")
    public NSHTTPCookie(NSDictionary<?, ?> properties) { }
    @Mapping("init")
    public NSHTTPCookie() { }

    
    @Mapping("properties")
    public native NSDictionary<?, ?> getProperties();
    @Mapping("version")
    public native @MachineSizedUInt long getVersion();
    @Mapping("name")
    public native String getName();
    @Mapping("value")
    public native String getValue();
    @Mapping("expiresDate")
    public native NSDate getExpiresDate();
    @Mapping("isSessionOnly")
    public native boolean isSessionOnly();
    @Mapping("domain")
    public native String getDomain();
    @Mapping("path")
    public native String getPath();
    @Mapping("isSecure")
    public native boolean isSecure();
    @Mapping("isHTTPOnly")
    public native boolean isHTTPOnly();
    @Mapping("comment")
    public native String getComment();
    @Mapping("commentURL")
    public native NSURL getCommentURL();
    @Mapping("portList")
    public native NSArray<?> getPortList();

    
    
    @Mapping("requestHeaderFieldsWithCookies:")
    public static native NSDictionary<?, ?> getRequestHeaderFieldsWithCookies(NSArray<?> cookies);
    @Mapping("cookiesWithResponseHeaderFields:forURL:")
    public static native NSArray<NSHTTPCookie> getCookiesWithResponseHeaderFields(NSDictionary<?, ?> headerFields, NSURL URL);

}
