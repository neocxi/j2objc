package apple.eventkit;


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
import apple.addressbook.*;
import apple.corelocation.*;


@Library("EventKit/EventKit.h") @Mapping("EKObject")
public class EKObject 
    extends NSObject 
     {

    
    
    @Mapping("init")
    public EKObject() { }

    


    
    
    @Mapping("hasChanges")
    public native boolean hasChanges();
    @Mapping("isNew")
    public native boolean isNew();
    @Mapping("reset")
    public native void reset();
    @Mapping("rollback")
    public native void rollback();
    @Mapping("refresh")
    public native boolean refresh();

}
