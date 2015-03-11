package apple.mapkit;


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
import apple.corelocation.*;
import apple.uikit.*;
import apple.dispatch.*;



/**
 * @since Available in iOS 4.0 and later.
 */

@Library("MapKit") @Mapping("MKShape")
public class MKShape 
    extends NSObject 
    implements MKAnnotation {

    
    
    public MKShape() {}
    
    
    @Mapping("title")
    public native String getTitle();
    public native void setTitle(String v);
    @Mapping("subtitle")
    public native String getSubtitle();
    public native void setSubtitle(String v);
    @Mapping("coordinate")
    public native CLLocationCoordinate2D getCoordinate();
    public native void setCoordinate(CLLocationCoordinate2D v);
    
    
    
    
    
}
