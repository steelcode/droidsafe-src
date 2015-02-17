package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class Rasterizer {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void finalizer(int native_instance) {
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:09.774 -0500", hash_original_field = "1353DF0D3FEF59358BA81F3F4AC59875", hash_generated_field = "1353DF0D3FEF59358BA81F3F4AC59875")

    int native_instance;
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:10.688 -0400", hash_original_method = "11C4CA6DFE8F610B47AB2C394C18DE1F", hash_generated_method = "11C4CA6DFE8F610B47AB2C394C18DE1F")
    public Rasterizer ()
    {
        //Synthesized constructor
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:09.768 -0500", hash_original_method = "29B0241D689448242FFD9C9D7DE21563", hash_generated_method = "C0A78266AD759FFF43807B6414D6FF75")
    
protected void finalize() throws Throwable {
        finalizer(native_instance);
    }
    
}
