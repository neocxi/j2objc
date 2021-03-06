package apple.externalaccessory;


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
import apple.dispatch.*;


@Library("ExternalAccessory/ExternalAccessory.h") @Mapping("EAWiFiUnconfiguredAccessoryBrowserDelegate")
public interface EAWiFiUnconfiguredAccessoryBrowserDelegate 
    extends NSObjectProtocol {

    
    


    
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Mapping("accessoryBrowser:didUpdateState:")
    void didUpdateState(EAWiFiUnconfiguredAccessoryBrowser browser, @Representing("EAWiFiUnconfiguredAccessoryBrowserState") long state);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Mapping("accessoryBrowser:didFindUnconfiguredAccessories:")
    void didFindUnconfiguredAccessories(EAWiFiUnconfiguredAccessoryBrowser browser, NSSet<?> accessories);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Mapping("accessoryBrowser:didRemoveUnconfiguredAccessories:")
    void didRemoveUnconfiguredAccessories(EAWiFiUnconfiguredAccessoryBrowser browser, NSSet<?> accessories);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Mapping("accessoryBrowser:didFinishConfiguringAccessory:withStatus:")
    void didFinishConfiguringAccessory(EAWiFiUnconfiguredAccessoryBrowser browser, EAWiFiUnconfiguredAccessory accessory, @Representing("EAWiFiUnconfiguredAccessoryConfigurationStatus") long status);

    /*<adapter>*/
    /*</adapter>*/
}
