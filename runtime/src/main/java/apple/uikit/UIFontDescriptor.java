package apple.uikit;


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
import apple.coreanimation.*;
import apple.coredata.*;
import apple.coreimage.*;
import apple.coretext.*;
import apple.corelocation.*;



/**
 * @since Available in iOS 7.0 and later.
 */

@Library("UIKit") @Mapping("UIFontDescriptor")
public class UIFontDescriptor 
    extends NSObject 
    implements NSCopying, NSCoding {

    
    
    public UIFontDescriptor() {}
    @Mapping("initWithFontAttributes:")
    public UIFontDescriptor(UIFontDescriptorAttributes attributes) { }
    
    
    @Mapping("postscriptName")
    public native String getPostscriptName();
    @Mapping("pointSize")
    public native @MachineSizedFloat double getPointSize();
    @Mapping("matrix")
    public native CGAffineTransform getMatrix();
    @Mapping("symbolicTraits")
    public native @Representing("UIFontDescriptorSymbolicTraits") int getSymbolicTraits();
    
    
    
    @Mapping("objectForKey:")
    protected native Object getValue(NSString anAttribute);
    @Mapping("fontAttributes")
    public native UIFontDescriptorAttributes getFontAttributes();
    @Mapping("matchingFontDescriptorsWithMandatoryKeys:")
    protected native NSArray<UIFontDescriptor> getMatchingFontDescriptors(NSSet<NSString> mandatoryKeys);
    @Mapping("fontDescriptorByAddingAttributes:")
    public native UIFontDescriptor newWithAttributes(UIFontDescriptorAttributes attributes);
    @Mapping("fontDescriptorWithSymbolicTraits:")
    public native UIFontDescriptor newWithSymbolicTraits(@Representing("UIFontDescriptorSymbolicTraits") int symbolicTraits);
    @Mapping("fontDescriptorWithSize:")
    public native UIFontDescriptor newWithSize(@MachineSizedFloat double newPointSize);
    @Mapping("fontDescriptorWithMatrix:")
    public native UIFontDescriptor newWithMatrix(CGAffineTransform matrix);
    @Mapping("fontDescriptorWithFace:")
    public native UIFontDescriptor newWithFace(String newFace);
    @Mapping("fontDescriptorWithFamily:")
    public native UIFontDescriptor newWithFamily(String newFamily);
    @Mapping("fontDescriptorWithFontAttributes:")
    public static native UIFontDescriptor create(UIFontDescriptorAttributes attributes);
    @Mapping("fontDescriptorWithName:size:")
    public static native UIFontDescriptor create(String fontName, @MachineSizedFloat double size);
    @Mapping("fontDescriptorWithName:matrix:")
    public static native UIFontDescriptor create(String fontName, CGAffineTransform matrix);
    @Mapping("preferredFontDescriptorWithTextStyle:")
    protected static native UIFontDescriptor getPreferredFontDescriptor(NSString style);
    @Mapping("copyWithZone:")
    public native Object copyWithZone$(NSZone zone);
    @Mapping("encodeWithCoder:")
    public native void encode(NSCoder aCoder);
    
}
