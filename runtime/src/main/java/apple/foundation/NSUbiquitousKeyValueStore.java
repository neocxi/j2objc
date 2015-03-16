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
 * @since Available in iOS 5.0 and later.
 */

@Library("Foundation/Foundation.h") @Mapping("NSUbiquitousKeyValueStore")
public class NSUbiquitousKeyValueStore 
    extends NSObject 
     {

    
    
    public NSUbiquitousKeyValueStore() {}
    
    
    @Mapping("dictionaryRepresentation")
    public native NSDictionary<NSString, NSObject> asDictionary();
    
    
    
    /**
     * @since Available in iOS 5.0 and later.
     */
    @GlobalConstant("NSUbiquitousKeyValueStoreDidChangeExternallyNotification")
    public static native NSString DidChangeExternallyNotification();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @GlobalConstant("NSUbiquitousKeyValueStoreChangeReasonKey")
    protected static native NSString ChangeReasonKey();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @GlobalConstant("NSUbiquitousKeyValueStoreChangedKeysKey")
    protected static native NSString ChangedKeysKey();
    
    @Mapping("objectForKey:")
    public native Object get(String aKey);
    @Mapping("setObject:forKey:")
    protected native void setObject(Object anObject, String aKey);
    @Mapping("removeObjectForKey:")
    public native void remove(String aKey);
    @Mapping("stringForKey:")
    public native String getString(String aKey);
    @Mapping("arrayForKey:")
    public native NSArray<?> getArray(String aKey);
    @Mapping("dictionaryForKey:")
    public native NSDictionary<?, ?> getDictionary(String aKey);
    @Mapping("dataForKey:")
    public native NSData getData(String aKey);
    @Mapping("longLongForKey:")
    public native long getLong(String aKey);
    @Mapping("doubleForKey:")
    public native double getDouble(String aKey);
    @Mapping("boolForKey:")
    public native boolean getBoolean(String aKey);
    @Mapping("setString:forKey:")
    protected native void setString(String aString, String aKey);
    @Mapping("setData:forKey:")
    protected native void setData(NSData aData, String aKey);
    @Mapping("setArray:forKey:")
    protected native void setArray(NSArray<?> anArray, String aKey);
    @Mapping("setDictionary:forKey:")
    protected native void setDictionary(NSDictionary<?, ?> aDictionary, String aKey);
    @Mapping("setLongLong:forKey:")
    protected native void setLongLong(long value, String aKey);
    @Mapping("setDouble:forKey:")
    protected native void setDouble(double value, String aKey);
    @Mapping("setBool:forKey:")
    protected native void setBool(boolean value, String aKey);
    @Mapping("synchronize")
    public native boolean synchronize();
    @Mapping("defaultStore")
    public static native NSUbiquitousKeyValueStore getDefaultStore();
    
}
