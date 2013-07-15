package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class SpannedString extends SpannableStringInternal implements CharSequence, GetChars, Spanned {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.742 -0400", hash_original_method = "9F76D9B76481417FB492CEBE18B667F5", hash_generated_method = "33D79447D7CEC7769A48AF3D60B5F026")
    public  SpannedString(CharSequence source) {
        super(source, 0, source.length());
        addTaint(source.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.742 -0400", hash_original_method = "E05868F8FE8E68E6279EDAD3C69CD063", hash_generated_method = "CA2C1B740D91BC45FA9416DCEDCDA186")
    private  SpannedString(CharSequence source, int start, int end) {
        super(source, start, end);
        addTaint(end);
        addTaint(start);
        addTaint(source.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:44.743 -0400", hash_original_method = "5C8F718730EE97469BD91F870902B78A", hash_generated_method = "EDEE0729B5FB81C7AF414FF81D2D59EA")
    public CharSequence subSequence(int start, int end) {
        addTaint(end);
        addTaint(start);
CharSequence var8E256BFE79DDBC5B54C96C6CCB48784A_757912044 =         new SpannedString(this, start, end);
        var8E256BFE79DDBC5B54C96C6CCB48784A_757912044.addTaint(taint);
        return var8E256BFE79DDBC5B54C96C6CCB48784A_757912044;
        // ---------- Original Method ----------
        //return new SpannedString(this, start, end);
    }

    
        public static SpannedString valueOf(CharSequence source) {
        if (source instanceof SpannedString) {
            return (SpannedString) source;
        } else {
            return new SpannedString(source);
        }
    }

    
}

