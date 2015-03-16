package apple.audiotoolbox;


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
import apple.opengles.*;
import apple.coreaudio.*;
import apple.coremedia.*;





@Mapping("AudioQueueParameterEvent") @Library("AudioToolbox/AudioToolbox.h")
public class AudioQueueParameterEvent 
    extends Struct 
     {

    
    protected AudioQueueParameterEvent() {}
    
    
    @DotMapping("mID")
    public native int getMID();
    @DotMapping("mValue")
    public native float getMValue();
    
    public static native AudioQueueParameterEvent create(int mID, float mValue) /*-[
        AudioQueueParameterEvent __new = { .mID = mID, .mValue = mValue };
        return __new;
    ]-*/;
    public static native AudioQueueParameterEvent copyWithmID(AudioQueueParameterEvent original, int mID) /*-[
        AudioQueueParameterEvent __new = { .mID = mID, .mValue = original.mValue };
        return __new;
    ]-*/;

    
    public static native AudioQueueParameterEvent copyWithmValue(AudioQueueParameterEvent original, float mValue) /*-[
        AudioQueueParameterEvent __new = { .mID = original.mID, .mValue = mValue };
        return __new;
    ]-*/;

    
}
