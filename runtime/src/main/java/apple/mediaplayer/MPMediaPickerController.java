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
 * @since Available in iOS 3.0 and later.
 */

@Library("MediaPlayer") @Mapping("MPMediaPickerController")
public class MPMediaPickerController 
    extends UIViewController 
     {

    
    
    @Mapping("initWithMediaTypes:")
    public MPMediaPickerController(@Representing("MPMediaType") @MachineSizedUInt long mediaTypes) { }
    @Mapping("initWithNibName:bundle:")
    public MPMediaPickerController(String nibNameOrNil, NSBundle nibBundleOrNil) { }
    
    
    @Mapping("mediaTypes")
    public native @Representing("MPMediaType") @MachineSizedUInt long getMediaTypes();
    @Mapping("delegate")
    public native MPMediaPickerControllerDelegate getDelegate();
    public native void setDelegate(MPMediaPickerControllerDelegate v);
    @Mapping("allowsPickingMultipleItems")
    public native boolean allowsPickingMultipleItems();
    public native void setAllowsPickingMultipleItems(boolean v);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Mapping("showsCloudItems")
    public native boolean showsCloudItems();
    /**
     * @since Available in iOS 6.0 and later.
     */
    public native void setShowsCloudItems(boolean v);
    @Mapping("prompt")
    public native String getPrompt();
    public native void setPrompt(String v);
    
    
    
    
    
}
