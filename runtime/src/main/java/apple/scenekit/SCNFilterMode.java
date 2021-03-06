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


@Library("SceneKit/SceneKit.h")
@Mapping("SCNFilterMode")
public final class SCNFilterMode extends ObjCEnum {
    
    @GlobalConstant("SCNFilterModeNone")
    public static final long None = 0L;
    @GlobalConstant("SCNFilterModeNearest")
    public static final long Nearest = 1L;
    @GlobalConstant("SCNFilterModeLinear")
    public static final long Linear = 2L;


}
