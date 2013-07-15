package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.pm.IPackageManager;

public class AppGlobals {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.070 -0400", hash_original_method = "225CC013D111255E32A02621AE08F9A5", hash_generated_method = "225CC013D111255E32A02621AE08F9A5")
    public AppGlobals ()
    {
        //Synthesized constructor
    }


        public static Application getInitialApplication() {
        return ActivityThread.currentApplication();
    }

    
        public static String getInitialPackage() {
        return ActivityThread.currentPackageName();
    }

    
        public static IPackageManager getPackageManager() {
        return ActivityThread.getPackageManager();
    }

    
        public static int getIntCoreSetting(String key, int defaultValue) {
        ActivityThread currentActivityThread = ActivityThread.currentActivityThread();
        if (currentActivityThread != null) {
            return currentActivityThread.getIntCoreSetting(key, defaultValue);
        } else {
            return defaultValue;
        }
    }

    
}

