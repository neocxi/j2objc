package apple.avfoundation;


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
import apple.dispatch.*;
import apple.coreanimation.*;
import apple.coreaudio.*;
import apple.coremedia.*;
import apple.corevideo.*;
import apple.mediatoolbox.*;


/**
 * @since Available in iOS 4.0 and later.
 */
@Library("AVFoundation/AVFoundation.h") @Mapping("AVVideoCompositionLayerInstruction")
public class AVVideoCompositionLayerInstruction 
    extends NSObject 
    implements NSCopying {

    
    
    @Mapping("init")
    public AVVideoCompositionLayerInstruction() { }

    
    @Mapping("trackID")
    public native int getTrackID();

    
    
    @Mapping("getTransformRampForTime:startTransform:endTransform:timeRange:")
    public native boolean getTransformRamp(CMTime time, CGAffineTransform startTransform, CGAffineTransform endTransform, CMTimeRange timeRange);
    @Mapping("getOpacityRampForTime:startOpacity:endOpacity:timeRange:")
    public native boolean getOpacityRamp(CMTime time, Todo startOpacity, Todo endOpacity, CMTimeRange timeRange);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Mapping("getCropRectangleRampForTime:startCropRectangle:endCropRectangle:timeRange:")
    public native boolean getCropRectangleRamp(CMTime time, CGRect startCropRectangle, CGRect endCropRectangle, CMTimeRange timeRange);
    @Mapping("copyWithZone:")
    public native Object copyWithZone$(NSZone zone);

}
