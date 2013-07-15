package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.database.sqlite.SQLiteDatabase;

public interface DatabaseErrorHandler {

    
    void onCorruption(SQLiteDatabase dbObj);
}
