package apple.coregraphics;


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


@Mapping("CGRect") @Library("CoreGraphics/CoreGraphics.h")
public class CGRect 
    extends Struct 
     {

    
    private CGRect() {}
    
    
    @DotMapping("origin")
    public native CGPoint getOrigin();
    @DotMapping("size")
    public native CGSize getSize();

    public static native CGRect create(CGPoint origin, CGSize size) /*-[
        CGRect __new = { .origin = origin, .size = size };
        return __new;
    ]-*/;
    public static native CGRect copyWithorigin(CGRect original, CGPoint origin) /*-[
        CGRect __new = { .origin = origin, .size = original.size };
        return __new;
    ]-*/;


    public static native CGRect copyWithsize(CGRect original, CGSize size) /*-[
        CGRect __new = { .origin = original.origin, .size = size };
        return __new;
    ]-*/;


    public static final class Adapter {

        public CGPoint origin;
        public CGSize size;
        public Adapter(CGPoint origin, CGSize size) {
            this.origin = origin;
            this.size = size;
        }
        public Adapter(CGRect original) {
            this.origin = original.getOrigin();
            this.size = original.getSize();
        }
        public CGRect convert() {
            return create(origin, size);
        }
    }
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalConstant("CGRectZero")
    public static native CGRect Zero();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalConstant("CGRectNull")
    public static native CGRect Null();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalConstant("CGRectInfinite")
    public static native CGRect Infinite();

    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalFunction("CGRectGetMinX")
    public static native @MachineSizedFloat double getMinX(CGRect rect);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalFunction("CGRectGetMidX")
    public static native @MachineSizedFloat double getMidX(CGRect rect);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalFunction("CGRectGetMaxX")
    public static native @MachineSizedFloat double getMaxX(CGRect rect);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalFunction("CGRectGetMinY")
    public static native @MachineSizedFloat double getMinY(CGRect rect);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalFunction("CGRectGetMidY")
    public static native @MachineSizedFloat double getMidY(CGRect rect);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalFunction("CGRectGetMaxY")
    public static native @MachineSizedFloat double getMaxY(CGRect rect);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalFunction("CGRectGetWidth")
    public static native @MachineSizedFloat double getWidth(CGRect rect);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalFunction("CGRectGetHeight")
    public static native @MachineSizedFloat double getHeight(CGRect rect);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalFunction("CGRectEqualToRect")
    public static native boolean equalToRect(CGRect rect1, CGRect rect2);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalFunction("CGRectStandardize")
    public static native CGRect standardize(CGRect rect);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalFunction("CGRectIsEmpty")
    public static native boolean isEmpty(CGRect rect);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalFunction("CGRectIsNull")
    public static native boolean isNull(CGRect rect);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalFunction("CGRectIsInfinite")
    public static native boolean isInfinite(CGRect rect);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalFunction("CGRectInset")
    public static native CGRect inset(CGRect rect, @MachineSizedFloat double dx, @MachineSizedFloat double dy);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalFunction("CGRectIntegral")
    public static native CGRect integral(CGRect rect);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalFunction("CGRectUnion")
    public static native CGRect union(CGRect r1, CGRect r2);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalFunction("CGRectIntersection")
    public static native CGRect intersection(CGRect r1, CGRect r2);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalFunction("CGRectOffset")
    public static native CGRect offset(CGRect rect, @MachineSizedFloat double dx, @MachineSizedFloat double dy);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalFunction("CGRectDivide")
    public static native void divide(CGRect rect, CGRect slice, CGRect remainder, @MachineSizedFloat double amount, @Representing("CGRectEdge") long edge);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalFunction("CGRectContainsPoint")
    public static native boolean contains(CGRect rect, CGPoint point);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalFunction("CGRectContainsRect")
    public static native boolean contains(CGRect rect1, CGRect rect2);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalFunction("CGRectIntersectsRect")
    public static native boolean intersects(CGRect rect1, CGRect rect2);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalFunction("CGRectCreateDictionaryRepresentation")
    public static native NSDictionary<NSString, NSNumber> toDictionary(CGRect p0);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalFunction("CGRectMakeWithDictionaryRepresentation")
    public static native boolean fromDictionary(CFDictionary dict, CGRect rect);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalFunction("CGRectApplyAffineTransform")
    public static native CGRect apply(CGRect rect, CGAffineTransform t);

}
