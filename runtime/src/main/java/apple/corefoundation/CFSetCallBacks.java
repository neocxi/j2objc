package apple.corefoundation;


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
import apple.dispatch.*;
import apple.foundation.*;





@Mapping("CFSetCallBacks") @Library("CoreFoundation/CoreFoundation.h")
 class CFSetCallBacks 
    extends Struct 
     {

    
    protected CFSetCallBacks() {}
    
    
    @DotMapping("version")
    public native @MachineSizedSInt long getVersion();
    
    public static native CFSetCallBacks copyWithversion(CFSetCallBacks original, @MachineSizedSInt long version) /*-[
        original.version = version;
        return original;
    ]-*/;

    
    
    
    
    
    
}
