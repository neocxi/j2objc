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





@Library("PassKit/PassKit.h") @Mapping("PKPaymentAuthorizationViewControllerDelegate")
public interface PKPaymentAuthorizationViewControllerDelegate 
    extends NSObjectProtocol {

    
    
    
    
    
    @Mapping("paymentAuthorizationViewController:didAuthorizePayment:completion:")
    void didAuthorizePayment(PKPaymentAuthorizationViewController controller, PKPayment payment, @Block VoidBlock1<PKPaymentAuthorizationStatus> completion);
    @Mapping("paymentAuthorizationViewControllerDidFinish:")
    void didFinish(PKPaymentAuthorizationViewController controller);
    @Mapping("paymentAuthorizationViewController:didSelectShippingMethod:completion:")
    void didSelectShippingMethod(PKPaymentAuthorizationViewController controller, PKShippingMethod shippingMethod, Todo completion);
    @Mapping("paymentAuthorizationViewController:didSelectShippingAddress:completion:")
    void didSelectShippingAddress(PKPaymentAuthorizationViewController controller, ABRecord address, Todo completion);
    
    /*<adapter>*/
    /*</adapter>*/
}