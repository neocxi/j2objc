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
 * @since Available in iOS 8.0 and later.
 */

@Library("AVFoundation") @Mapping("AVAudioUnitTimePitch")
public class AVAudioUnitTimePitch 
    extends AVAudioUnitTimeEffect 
     {

    
    
    public AVAudioUnitTimePitch() {}
    @Mapping("initWithAudioComponentDescription:")
    public AVAudioUnitTimePitch(AudioComponentDescription audioComponentDescription) { }
    
    
    @Mapping("rate")
    public native float getRate();
    public native void setRate(float v);
    @Mapping("pitch")
    public native float getPitch();
    public native void setPitch(float v);
    @Mapping("overlap")
    public native float getOverlap();
    public native void setOverlap(float v);
    
    
    
    
    
}
