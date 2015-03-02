package android.support.v4.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.view.VelocityTracker;

public class VelocityTrackerCompat {

    // -------------------------------------------------------------------

    /**
     * Call {@link VelocityTracker#getXVelocity(int)}.
     * If running on a pre-{@link android.os.Build.VERSION_CODES#HONEYCOMB} device,
     * returns {@link VelocityTracker#getXVelocity()}.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSOR})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.702 -0500", hash_original_method = "7A5C3DBDA666C80A45F25B88205A3F08", hash_generated_method = "4506F92BFC7617E7750007FBE49AEE97")
    
public static float getXVelocity(VelocityTracker tracker, int pointerId) {
        return IMPL.getXVelocity(tracker, pointerId);
    }

    /**
     * Call {@link VelocityTracker#getYVelocity(int)}.
     * If running on a pre-{@link android.os.Build.VERSION_CODES#HONEYCOMB} device,
     * returns {@link VelocityTracker#getYVelocity()}.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSOR})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.705 -0500", hash_original_method = "16969877F8BB17F3526ACA4DF1E3B41E", hash_generated_method = "58474ABFB747459208A83538DF28BE66")
    
public static float getYVelocity(VelocityTracker tracker, int pointerId) {
        return IMPL.getYVelocity(tracker, pointerId);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.700 -0500", hash_original_field = "4C7E81C3A0AF2BE8390A9D71DF9BF54E", hash_generated_field = "0A84FDB029BDF78AE211B91A0B9EF3AB")

    static  VelocityTrackerVersionImpl IMPL;
    
    static class BaseVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl {
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.333 -0400", hash_original_method = "E207FC5896FAF2D7F355008464495FF2", hash_generated_method = "E207FC5896FAF2D7F355008464495FF2")
        public BaseVelocityTrackerVersionImpl ()
        {
            //Synthesized constructor
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.SENSOR})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.685 -0500", hash_original_method = "C711DFF45899DB50837A3534EA18E563", hash_generated_method = "22A5A3796AAF90737CF2D04C7C06E850")
        
@Override
        public float getXVelocity(VelocityTracker tracker, int pointerId) {
            return tracker.getXVelocity();
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.SENSOR})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.688 -0500", hash_original_method = "C1E75A29A2B04E744E6358D9ECEF4179", hash_generated_method = "2EFA4A3DBBC3BA921BD108FB8C0B9710")
        
@Override
        public float getYVelocity(VelocityTracker tracker, int pointerId) {
            return tracker.getYVelocity();
        }
        
    }
    
    static class HoneycombVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl {
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.334 -0400", hash_original_method = "C45D4DE867C130E838448AE2BF37BBAC", hash_generated_method = "C45D4DE867C130E838448AE2BF37BBAC")
        public HoneycombVelocityTrackerVersionImpl ()
        {
            //Synthesized constructor
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.SENSOR})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.693 -0500", hash_original_method = "E2537AF0FA564D885F2AE573A5D655DB", hash_generated_method = "02B89D143A064F82BEC64C4E483C0110")
        
@Override
        public float getXVelocity(VelocityTracker tracker, int pointerId) {
            return VelocityTrackerCompatHoneycomb.getXVelocity(tracker, pointerId);
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.SENSOR})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.696 -0500", hash_original_method = "D5A70EB91EAA38C3613B20D88EAA6FB3", hash_generated_method = "97F2583C359B91B960B0619ECF98E96A")
        
@Override
        public float getYVelocity(VelocityTracker tracker, int pointerId) {
            return VelocityTrackerCompatHoneycomb.getYVelocity(tracker, pointerId);
        }
        
    }
    
    interface VelocityTrackerVersionImpl {
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public float getXVelocity(VelocityTracker tracker, int pointerId);
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public float getYVelocity(VelocityTracker tracker, int pointerId);
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.332 -0400", hash_original_method = "ACE59A9EBE302FC1E1A244DA6E2DCF51", hash_generated_method = "ACE59A9EBE302FC1E1A244DA6E2DCF51")
    public VelocityTrackerCompat ()
    {
        //Synthesized constructor
    }
    static {
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            IMPL = new HoneycombVelocityTrackerVersionImpl();
        } else {
            IMPL = new BaseVelocityTrackerVersionImpl();
        }
    }
    
}
