package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Iterator;

public interface Iterable<T> {

    
    Iterator<T> iterator();
}
