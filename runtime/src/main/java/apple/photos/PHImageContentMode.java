package apple.photos;


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
import apple.corelocation.*;
import apple.uikit.*;
import apple.avfoundation.*;



/**
 * @since Available in iOS 8.0 and later.
 */


@Mapping("PHImageContentMode")
public final class PHImageContentMode extends ObjCEnum {
    
    @GlobalConstant("PHImageContentModeAspectFit")
    public static final long AspectFit = 0L;
    @GlobalConstant("PHImageContentModeAspectFill")
    public static final long AspectFill = 1L;
    @GlobalConstant("PHImageContentModeDefault")
    public static final long Default = 0L;
    

}
