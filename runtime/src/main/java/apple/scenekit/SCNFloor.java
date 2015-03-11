package apple.scenekit;


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
import apple.coreanimation.*;
import apple.dispatch.*;
import apple.glkit.*;
import apple.spritekit.*;
import apple.opengles.*;





@Library("SceneKit") @Mapping("SCNFloor")
public class SCNFloor 
    extends SCNGeometry 
     {

    
    
    public SCNFloor() {}
    
    
    @Mapping("reflectivity")
    public native @MachineSizedFloat double getReflectivity();
    public native void setReflectivity(@MachineSizedFloat double v);
    @Mapping("reflectionFalloffStart")
    public native @MachineSizedFloat double getReflectionFalloffStart();
    public native void setReflectionFalloffStart(@MachineSizedFloat double v);
    @Mapping("reflectionFalloffEnd")
    public native @MachineSizedFloat double getReflectionFalloffEnd();
    public native void setReflectionFalloffEnd(@MachineSizedFloat double v);
    @Mapping("reflectionResolutionScaleFactor")
    public native @MachineSizedFloat double getReflectionResolutionScaleFactor();
    public native void setReflectionResolutionScaleFactor(@MachineSizedFloat double v);
    
    
    
    @Mapping("floor")
    public static native SCNFloor create();
    
}
