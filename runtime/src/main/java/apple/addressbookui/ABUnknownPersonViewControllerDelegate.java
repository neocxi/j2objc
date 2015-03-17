package apple.addressbookui;


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





@Library("AddressBookUI/AddressBookUI.h") @Mapping("ABUnknownPersonViewControllerDelegate")
public interface ABUnknownPersonViewControllerDelegate 
    extends NSObjectProtocol {

    
    
    
    
    
    @Mapping("unknownPersonViewController:didResolveToPerson:")
    void didResolveToPerson(ABUnknownPersonViewController unknownCardViewController, ABRecord person);
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Mapping("unknownPersonViewController:shouldPerformDefaultActionForPerson:property:identifier:")
    boolean shouldPerformDefaultAction(ABUnknownPersonViewController personViewController, ABRecord person, int property, int identifier);
    
    /*<adapter>*/
    /*</adapter>*/
}