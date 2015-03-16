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

@Library("MapKit/MapKit.h") @Mapping("MKPointAnnotation")
public class MKPointAnnotation 
    extends MKShape 
     {

    
    
    public MKPointAnnotation() {}
    
    
    @Mapping("coordinate")
    public native CLLocationCoordinate2D getCoordinate();
    @Mapping("setCoordinate:")
    public native void setCoordinate(CLLocationCoordinate2D v);
    
    
    
    
    
}
