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





@Library("AVFoundation") @Mapping("AVAudio3DMixing")
public interface AVAudio3DMixing 
    extends NSObjectProtocol {

    
    
    @Mapping("renderingAlgorithm")
    @Representing("AVAudio3DMixingRenderingAlgorithm") @MachineSizedSInt long getRenderingAlgorithm();
    void setRenderingAlgorithm(@Representing("AVAudio3DMixingRenderingAlgorithm") @MachineSizedSInt long v);
    @Mapping("rate")
    float getRate();
    void setRate(float v);
    @Mapping("reverbBlend")
    float getReverbBlend();
    void setReverbBlend(float v);
    @Mapping("obstruction")
    float getObstruction();
    void setObstruction(float v);
    @Mapping("occlusion")
    float getOcclusion();
    void setOcclusion(float v);
    @Mapping("position")
    AVAudio3DPoint getPosition();
    void setPosition(AVAudio3DPoint v);
    
    
    
    
    /*<adapter>*/
    /*</adapter>*/
}
