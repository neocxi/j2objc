package apple.gamekit;


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


/**
 * @since Available in iOS 5.0 and later.
 */
@Library("GameKit/GameKit.h") @Mapping("GKTurnBasedParticipant")
public class GKTurnBasedParticipant 
    extends NSObject 
     {

    
    
    @Mapping("init")
    public GKTurnBasedParticipant() { }

    
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Mapping("player")
    public native GKPlayer getPlayer();
    @Mapping("lastTurnDate")
    public native NSDate getLastTurnDate();
    @Mapping("status")
    public native @Representing("GKTurnBasedParticipantStatus") long getStatus();
    @Mapping("matchOutcome")
    public native @Representing("GKTurnBasedMatchOutcome") long getMatchOutcome();
    @Mapping("setMatchOutcome:")
    public native void setMatchOutcome(@Representing("GKTurnBasedMatchOutcome") long v);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Mapping("timeoutDate")
    public native NSDate getTimeoutDate();
    /**
     * @since Available in iOS 5.0 and later.
     * @deprecated Deprecated in iOS 8.0.
     */
    @Deprecated
    @Mapping("playerID")
    public native String getPlayerID();

    
    


}
