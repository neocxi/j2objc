package apple.coreservices;


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





@Mapping("CFNetServiceClientContext")
 class CFNetServiceClientContext 
    extends Struct 
     {

    
    protected CFNetServiceClientContext() {}
    
    
    @DotMapping("version")
    public native @MachineSizedSInt long getVersion();
    
    public static native CFNetServiceClientContext copyWithversion(CFNetServiceClientContext original, @MachineSizedSInt long version) /*-[
        original.version = version;
        return __new;
    ]-*/;

    
    
    
    
    
}
