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


/*<javadoc>*/
/*</javadoc>*/
@Library("SceneKit")
public class SCNSceneAttribute 
    extends Object 
     {

    
    
    
    
    
    @GlobalConstant("SCNSceneStartTimeAttributeKey")
    protected static native NSString StartTimeValue();
    @GlobalConstant("SCNSceneEndTimeAttributeKey")
    protected static native NSString EndTimeValue();
    @GlobalConstant("SCNSceneFrameRateAttributeKey")
    protected static native NSString FrameRateValue();
    @GlobalConstant("SCNSceneUpAxisAttributeKey")
    protected static native NSString UpAxisValue();
    
}
