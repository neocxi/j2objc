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


@Library("UIKit/UIKit.h")
@Mapping("UIPageViewControllerTransitionStyle")
public final class UIPageViewControllerTransitionStyle extends ObjCEnum {
    
    @GlobalConstant("UIPageViewControllerTransitionStylePageCurl")
    public static final long PageCurl = 0L;
    @GlobalConstant("UIPageViewControllerTransitionStyleScroll")
    public static final long Scroll = 1L;


}
