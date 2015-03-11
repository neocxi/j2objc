package apple.coregraphics;


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





@Mapping("CGPatternCallbacks")
 class CGPatternCallbacks 
    extends Struct 
     {

    
    protected CGPatternCallbacks() {}
    
    
    @DotMapping("version")
    public native int getVersion();
    
    public static native CGPatternCallbacks copyWithversion(CGPatternCallbacks original, int version) /*-[
        original.version = version;
        return __new;
    ]-*/;

    
    
    
}
