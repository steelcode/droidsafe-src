package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcelable;

public interface RegisteredServicesCacheListener<V> {
    
    void onServiceChanged(V type, boolean removed);
}
