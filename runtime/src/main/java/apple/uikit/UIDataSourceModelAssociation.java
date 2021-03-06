package apple.uikit;


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
import apple.coreanimation.*;
import apple.coredata.*;
import apple.coreimage.*;
import apple.coretext.*;
import apple.corelocation.*;


@Library("UIKit/UIKit.h") @Mapping("UIDataSourceModelAssociation")
public interface UIDataSourceModelAssociation 
     {

    
    


    
    @Mapping("modelIdentifierForElementAtIndexPath:inView:")
    String getElementModelIdentifier(NSIndexPath idx, UIView view);
    @Mapping("indexPathForElementWithModelIdentifier:inView:")
    NSIndexPath getElementIndexPath(String identifier, UIView view);

    /*<adapter>*/
    /*</adapter>*/
}
