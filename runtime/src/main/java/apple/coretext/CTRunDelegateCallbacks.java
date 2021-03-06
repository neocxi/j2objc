package apple.coretext;


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


@Mapping("CTRunDelegateCallbacks") @Library("CoreText/CoreText.h")
 class CTRunDelegateCallbacks 
    extends Struct 
     {

    
    private CTRunDelegateCallbacks() {}
    
    
    @DotMapping("version")
    public native @MachineSizedSInt long getVersion();

    
}
