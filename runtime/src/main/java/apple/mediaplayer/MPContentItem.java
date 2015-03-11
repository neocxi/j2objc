package apple.mediaplayer;


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



/**
 * @since Available in iOS 7.1 and later.
 */

@Library("MediaPlayer") @Mapping("MPContentItem")
public class MPContentItem 
    extends NSObject 
     {

    
    
    public MPContentItem() {}
    @Mapping("initWithIdentifier:")
    public MPContentItem(String identifier) { }
    
    
    @Mapping("identifier")
    public native String getIdentifier();
    @Mapping("title")
    public native String getTitle();
    public native void setTitle(String v);
    @Mapping("subtitle")
    public native String getSubtitle();
    public native void setSubtitle(String v);
    @Mapping("artwork")
    public native MPMediaItemArtwork getArtwork();
    public native void setArtwork(MPMediaItemArtwork v);
    @Mapping("isContainer")
    public native boolean isContainer();
    public native void setContainer(boolean v);
    @Mapping("isPlayable")
    public native boolean isPlayable();
    public native void setPlayable(boolean v);
    @Mapping("playbackProgress")
    public native float getPlaybackProgress();
    public native void setPlaybackProgress(float v);
    
    
    
    
    
}
