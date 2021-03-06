package apple.foundation;


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
import apple.uikit.*;
import apple.coreanimation.*;
import apple.coredata.*;
import apple.coremedia.*;
import apple.security.*;
import apple.dispatch.*;


@Library("Foundation/Foundation.h") @Mapping("NSMutableData")
public class NSMutableData 
    extends NSData 
     {

    
    
    public NSMutableData() {}
    @Mapping("initWithCapacity:")
    public NSMutableData(@MachineSizedUInt long capacity) { }

    


    
    
    @Mapping("appendBytes:length:")
    public native void appendBytes(VoidPtr bytes, @MachineSizedUInt long length);
    @Mapping("appendData:")
    public native void append(NSData other);
    @Mapping("increaseLengthBy:")
    public native void increaseLength(@MachineSizedUInt long extraLength);
    @Mapping("replaceBytesInRange:withBytes:")
    public native void replaceBytes(NSRange range, VoidPtr bytes);
    @Mapping("resetBytesInRange:")
    public native void reset(NSRange range);
    @Mapping("setData:")
    public native void setData(NSData data);
    @Mapping("replaceBytesInRange:withBytes:length:")
    public native void replaceBytes(NSRange range, VoidPtr replacementBytes, @MachineSizedUInt long replacementLength);

}
