package apple.passkit;


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
import apple.uikit.*;
import apple.addressbook.*;


/**
 * @since Available in iOS 8.0 and later.
 */
@Library("PassKit/PassKit.h") @Mapping("PKShippingMethod")
public class PKShippingMethod 
    extends PKPaymentSummaryItem 
     {

    
    
    @Mapping("init")
    public PKShippingMethod() { }

    
    @Mapping("identifier")
    public native String getIdentifier();
    @Mapping("setIdentifier:")
    public native void setIdentifier(String v);
    @Mapping("detail")
    public native String getDetail();
    @Mapping("setDetail:")
    public native void setDetail(String v);

    
    


}
