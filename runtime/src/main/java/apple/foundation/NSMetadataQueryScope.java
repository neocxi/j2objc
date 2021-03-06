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
@Library("Foundation/Foundation.h")
public class NSMetadataQueryScope 
    extends Object 
     {

    
    
    
    
    
    /**
     * @since Available in iOS 5.0 and later.
     */
    @GlobalConstant("NSMetadataQueryUbiquitousDocumentsScope")
    public static native NSString UbiquitousDocumentsValue();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @GlobalConstant("NSMetadataQueryUbiquitousDataScope")
    public static native NSString UbiquitousDataValue();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @GlobalConstant("NSMetadataQueryAccessibleUbiquitousExternalDocumentsScope")
    public static native NSString AccessibleUbiquitousExternalDocumentsValue();

}
