package apple.coreanimation;


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
import apple.coreimage.*;
import apple.coretext.*;
import apple.opengles.*;
import apple.metal.*;





@Library("QuartzCore") @Mapping("CADisplayLink")
public class CADisplayLink 
    extends NSObject 
     {

    
    
    
    
    
    @Mapping("timestamp")
    public native double getTimestamp();
    @Mapping("duration")
    public native double getDuration();
    @Mapping("isPaused")
    public native boolean isPaused();
    public native void setPaused(boolean v);
    @Mapping("frameInterval")
    public native @MachineSizedSInt long getFrameInterval();
    public native void setFrameInterval(@MachineSizedSInt long v);
    
    
    
    @Mapping("addToRunLoop:forMode:")
    public native void addToRunLoop(NSRunLoop runloop, String mode);
    @Mapping("removeFromRunLoop:forMode:")
    public native void removeFromRunLoop(NSRunLoop runloop, String mode);
    @Mapping("invalidate")
    public native void invalidate();
    @Mapping("displayLinkWithTarget:selector:")
    public static native CADisplayLink create(Object target, Selector sel);
    
}
