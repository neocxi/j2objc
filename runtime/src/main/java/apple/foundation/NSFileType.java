package apple.foundation;


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
import apple.uikit.*;
import apple.coreanimation.*;
import apple.coredata.*;
import apple.coremedia.*;
import apple.security.*;
import apple.dispatch.*;


/*<javadoc>*/
/*</javadoc>*/
@Library("Foundation/Foundation.h")
public class NSFileType 
    extends Object 
     {

    
    
    
    
    
    @GlobalConstant("NSFileTypeDirectory")
    protected static native NSString DirectoryValue();
    @GlobalConstant("NSFileTypeRegular")
    protected static native NSString RegularValue();
    @GlobalConstant("NSFileTypeSymbolicLink")
    protected static native NSString SymbolicLinkValue();
    @GlobalConstant("NSFileTypeSocket")
    protected static native NSString SocketValue();
    @GlobalConstant("NSFileTypeCharacterSpecial")
    protected static native NSString CharacterSpecialValue();
    @GlobalConstant("NSFileTypeBlockSpecial")
    protected static native NSString BlockSpecialValue();
    @GlobalConstant("NSFileTypeUnknown")
    protected static native NSString UnknownValue();
    
}