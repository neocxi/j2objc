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


@Mapping("CVPlanarComponentInfo") @Library("CoreVideo/CoreVideo.h")
public class CVPlanarComponentInfo 
    extends Struct 
     {

    
    private CVPlanarComponentInfo() {}
    
    
    @DotMapping("offset")
    public native int getOffset();
    @DotMapping("rowBytes")
    public native int getRowBytes();

    public static native CVPlanarComponentInfo create(int offset, int rowBytes) /*-[
        CVPlanarComponentInfo __new = { .offset = offset, .rowBytes = rowBytes };
        return __new;
    ]-*/;
    public static native CVPlanarComponentInfo copyWithoffset(CVPlanarComponentInfo original, int offset) /*-[
        CVPlanarComponentInfo __new = { .offset = offset, .rowBytes = original.rowBytes };
        return __new;
    ]-*/;


    public static native CVPlanarComponentInfo copyWithrowBytes(CVPlanarComponentInfo original, int rowBytes) /*-[
        CVPlanarComponentInfo __new = { .offset = original.offset, .rowBytes = rowBytes };
        return __new;
    ]-*/;


    public static final class Adapter {

        public int offset;
        public int rowBytes;
        public Adapter(int offset, int rowBytes) {
            this.offset = offset;
            this.rowBytes = rowBytes;
        }
        public Adapter(CVPlanarComponentInfo original) {
            this.offset = original.getOffset();
            this.rowBytes = original.getRowBytes();
        }
        public CVPlanarComponentInfo convert() {
            return create(offset, rowBytes);
        }
    }
}
