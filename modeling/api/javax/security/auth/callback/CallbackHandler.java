package javax.security.auth.callback;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

public interface CallbackHandler {
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException;

}