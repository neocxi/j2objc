package apple.corevideo;


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
import apple.coremedia.*;


/*<javadoc>*/
/*</javadoc>*/
@Library("CoreVideo/CoreVideo.h")
public class CVBuffer 
    extends CFType 
     {

    
    
    
    
    
    /**
     * @since Available in iOS 4.0 and later.
     */
    @GlobalFunction("CVBufferSetAttachment")
    public static native void setAttachment(CVBuffer buffer, CFString key, CFType value, CVAttachmentMode attachmentMode);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @GlobalFunction("CVBufferGetAttachment")
    protected static native CFType getAttachment(CVBuffer buffer, CFString key, Todo attachmentMode);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @GlobalFunction("CVBufferRemoveAttachment")
    public static native void removeAttachment(CVBuffer buffer, CFString key);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @GlobalFunction("CVBufferRemoveAllAttachments")
    public static native void removeAllAttachments(CVBuffer buffer);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @GlobalFunction("CVBufferGetAttachments")
    public static native NSDictionary<NSString, ?> getAttachments(CVBuffer buffer, CVAttachmentMode attachmentMode);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @GlobalFunction("CVBufferSetAttachments")
    public static native void setAttachments(CVBuffer buffer, CFDictionary theAttachments, CVAttachmentMode attachmentMode);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @GlobalFunction("CVBufferPropagateAttachments")
    public static native void propagateAttachments(CVBuffer sourceBuffer, CVBuffer destinationBuffer);
    
}