package apple.corefoundation;


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
import apple.dispatch.*;
import apple.foundation.*;


@Mapping("CFRange") @Library("CoreFoundation/CoreFoundation.h")
public class CFRange 
    extends Struct 
     {

    
    private CFRange() {}
    
    
    @DotMapping("location")
    public native @MachineSizedSInt long getLocation();
    @DotMapping("length")
    public native @MachineSizedSInt long getLength();

    public static native CFRange create(@MachineSizedSInt long location, @MachineSizedSInt long length) /*-[
        CFRange __new = { .location = location, .length = length };
        return __new;
    ]-*/;
    public static native CFRange copyWithlocation(CFRange original, @MachineSizedSInt long location) /*-[
        CFRange __new = { .location = location, .length = original.length };
        return __new;
    ]-*/;


    public static native CFRange copyWithlength(CFRange original, @MachineSizedSInt long length) /*-[
        CFRange __new = { .location = original.location, .length = length };
        return __new;
    ]-*/;


    public static final class Adapter {

        public @MachineSizedSInt long location;
        public @MachineSizedSInt long length;
        public Adapter(@MachineSizedSInt long location, @MachineSizedSInt long length) {
            this.location = location;
            this.length = length;
        }
        public Adapter(CFRange original) {
            this.location = original.getLocation();
            this.length = original.getLength();
        }
        public CFRange convert() {
            return create(location, length);
        }
    }
}
