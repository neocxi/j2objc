package apple.coremotion;


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



/**
 * @since Available in iOS 8.0 and later.
 */

@Library("CoreMotion") @Mapping("CMPedometer")
public class CMPedometer 
    extends NSObject 
     {

    
    
    public CMPedometer() {}
    
    
    
    
    
    
    @Mapping("queryPedometerDataFromDate:toDate:withHandler:")
    public native void queryPedometerData(NSDate start, NSDate end, @Block VoidBlock2<CMPedometerData, NSError> handler);
    @Mapping("startPedometerUpdatesFromDate:withHandler:")
    public native void startPedometerUpdates(NSDate start, @Block VoidBlock2<CMPedometerData, NSError> handler);
    @Mapping("stopPedometerUpdates")
    public native void stopPedometerUpdates();
    @Mapping("isStepCountingAvailable")
    public static native boolean isStepCountingAvailable();
    @Mapping("isDistanceAvailable")
    public static native boolean isDistanceAvailable();
    @Mapping("isFloorCountingAvailable")
    public static native boolean isFloorCountingAvailable();
    
}
