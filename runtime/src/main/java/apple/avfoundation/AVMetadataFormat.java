package apple.avfoundation;


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
import apple.dispatch.*;
import apple.coreanimation.*;
import apple.coreaudio.*;
import apple.coremedia.*;
import apple.corevideo.*;
import apple.mediatoolbox.*;


/*<javadoc>*/
/*</javadoc>*/
@Library("AVFoundation")
public class AVMetadataFormat 
    extends Object 
     {

    
    
    
    
    
    /**
     * @since Available in iOS 4.0 and later.
     */
    @GlobalConstant("AVMetadataFormatQuickTimeUserData")
    public static native NSString QuickTimeUserDataValue();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @GlobalConstant("AVMetadataFormatISOUserData")
    public static native NSString ISOUserDataValue();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @GlobalConstant("AVMetadataFormatQuickTimeMetadata")
    public static native NSString QuickTimeMetadataValue();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @GlobalConstant("AVMetadataFormatiTunesMetadata")
    public static native NSString iTunesMetadataValue();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @GlobalConstant("AVMetadataFormatID3Metadata")
    public static native NSString ID3MetadataValue();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @GlobalConstant("AVMetadataFormatHLSMetadata")
    public static native NSString HLSMetadataValue();
    
}
