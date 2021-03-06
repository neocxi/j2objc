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


@Mapping("AVCaptureWhiteBalanceChromaticityValues") @Library("AVFoundation/AVFoundation.h")
public class AVCaptureWhiteBalanceChromaticityValues 
    extends Struct 
     {

    
    private AVCaptureWhiteBalanceChromaticityValues() {}
    
    
    @DotMapping("x")
    public native float getX();
    @DotMapping("y")
    public native float getY();

    public static native AVCaptureWhiteBalanceChromaticityValues create(float x, float y) /*-[
        AVCaptureWhiteBalanceChromaticityValues __new = { .x = x, .y = y };
        return __new;
    ]-*/;
    public static native AVCaptureWhiteBalanceChromaticityValues copyWithx(AVCaptureWhiteBalanceChromaticityValues original, float x) /*-[
        AVCaptureWhiteBalanceChromaticityValues __new = { .x = x, .y = original.y };
        return __new;
    ]-*/;


    public static native AVCaptureWhiteBalanceChromaticityValues copyWithy(AVCaptureWhiteBalanceChromaticityValues original, float y) /*-[
        AVCaptureWhiteBalanceChromaticityValues __new = { .x = original.x, .y = y };
        return __new;
    ]-*/;


    public static final class Adapter {

        public float x;
        public float y;
        public Adapter(float x, float y) {
            this.x = x;
            this.y = y;
        }
        public Adapter(AVCaptureWhiteBalanceChromaticityValues original) {
            this.x = original.getX();
            this.y = original.getY();
        }
        public AVCaptureWhiteBalanceChromaticityValues convert() {
            return create(x, y);
        }
    }
}
