package android.accounts;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface AccountManagerCallback<V> {
    void run(AccountManagerFuture<V> future);
}
