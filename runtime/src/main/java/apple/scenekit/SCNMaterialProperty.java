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


@Library("SceneKit/SceneKit.h") @Mapping("SCNMaterialProperty")
public class SCNMaterialProperty 
    extends NSObject 
    implements SCNAnimatable {

    
    
    @Mapping("init")
    public SCNMaterialProperty() { }

    
    @Mapping("contents")
    public native Object getContents();
    @Mapping("setContents:")
    public native void setContents(Object v);
    @Mapping("intensity")
    public native @MachineSizedFloat double getIntensity();
    @Mapping("setIntensity:")
    public native void setIntensity(@MachineSizedFloat double v);
    @Mapping("minificationFilter")
    public native @Representing("SCNFilterMode") long getMinificationFilter();
    @Mapping("setMinificationFilter:")
    public native void setMinificationFilter(@Representing("SCNFilterMode") long v);
    @Mapping("magnificationFilter")
    public native @Representing("SCNFilterMode") long getMagnificationFilter();
    @Mapping("setMagnificationFilter:")
    public native void setMagnificationFilter(@Representing("SCNFilterMode") long v);
    @Mapping("mipFilter")
    public native @Representing("SCNFilterMode") long getMipFilter();
    @Mapping("setMipFilter:")
    public native void setMipFilter(@Representing("SCNFilterMode") long v);
    @Mapping("contentsTransform")
    public native SCNMatrix4 getContentsTransform();
    @Mapping("setContentsTransform:")
    public native void setContentsTransform(SCNMatrix4 v);
    @Mapping("wrapS")
    public native @Representing("SCNWrapMode") long getWrapS();
    @Mapping("setWrapS:")
    public native void setWrapS(@Representing("SCNWrapMode") long v);
    @Mapping("wrapT")
    public native @Representing("SCNWrapMode") long getWrapT();
    @Mapping("setWrapT:")
    public native void setWrapT(@Representing("SCNWrapMode") long v);
    @Mapping("borderColor")
    public native Object getBorderColor();
    @Mapping("setBorderColor:")
    public native void setBorderColor(Object v);
    @Mapping("mappingChannel")
    public native @MachineSizedSInt long getMappingChannel();
    @Mapping("setMappingChannel:")
    public native void setMappingChannel(@MachineSizedSInt long v);
    @Mapping("maxAnisotropy")
    public native @MachineSizedFloat double getMaxAnisotropy();
    @Mapping("setMaxAnisotropy:")
    public native void setMaxAnisotropy(@MachineSizedFloat double v);

    
    
    @Mapping("materialPropertyWithContents:")
    public static native SCNMaterialProperty create(Object contents);
    @Mapping("addAnimation:forKey:")
    public native void addAnimation(CAAnimation animation, String key);
    @Mapping("removeAllAnimations")
    public native void removeAllAnimations();
    @Mapping("removeAnimationForKey:")
    public native void removeAnimation(String key);
    @Mapping("animationKeys")
    public native List<String> getAnimationKeys();
    @Mapping("animationForKey:")
    public native CAAnimation getAnimation(String key);
    @Mapping("pauseAnimationForKey:")
    public native void pauseAnimation(String key);
    @Mapping("resumeAnimationForKey:")
    public native void resumeAnimation(String key);
    @Mapping("isAnimationForKeyPaused:")
    public native boolean isAnimationPaused(String key);
    @Mapping("removeAnimationForKey:fadeOutDuration:")
    public native void removeAnimation(String key, @MachineSizedFloat double duration);

}
