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
@Adapter
public abstract class AVVideoCompositingAdapter 
    extends Object 
    implements AVVideoCompositing {

    
    
    


    
    
    @NotImplemented("renderContextChanged:")
    public void renderContextChanged(AVVideoCompositionRenderContext newRenderContext) { throw new UnsupportedOperationException(); }
    @NotImplemented("startVideoCompositionRequest:")
    public void startVideoCompositionRequest(AVAsynchronousVideoCompositionRequest asyncVideoCompositionRequest) { throw new UnsupportedOperationException(); }
    @NotImplemented("cancelAllPendingVideoCompositionRequests")
    public void cancelAllPendingVideoCompositionRequests() { throw new UnsupportedOperationException(); }

}
