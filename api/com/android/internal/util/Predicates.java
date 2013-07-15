package com.android.internal.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;

public class Predicates {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.778 -0400", hash_original_method = "8D570740569D5E9289A65558AD01F51B", hash_generated_method = "0B438E75227DE5A66090FC4CE4AA0AA1")
    private  Predicates() {
        // ---------- Original Method ----------
    }

    
        public static <T> Predicate<T> and(Predicate<? super T>... components) {
        return and(Arrays.asList(components));
    }

    
        public static <T> Predicate<T> and(Iterable<? extends Predicate<? super T>> components) {
        return new AndPredicate(components);
    }

    
        public static <T> Predicate<T> or(Predicate<? super T>... components) {
        return or(Arrays.asList(components));
    }

    
        public static <T> Predicate<T> or(Iterable<? extends Predicate<? super T>> components) {
        return new OrPredicate(components);
    }

    
        public static <T> Predicate<T> not(Predicate<? super T> predicate) {
        return new NotPredicate<T>(predicate);
    }

    
    private static class AndPredicate<T> implements Predicate<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.780 -0400", hash_original_field = "4725DCF446A342F1473A8228E42DFA48", hash_generated_field = "0796151CBA0A8A363E453698674B2FF1")

        private Iterable<? extends Predicate<? super T>> components;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.780 -0400", hash_original_method = "9C4B289345C7238C0EC3F315CFBA2A0C", hash_generated_method = "C989656BFDFAC34F8AD7FE7C2030A521")
        private  AndPredicate(Iterable<? extends Predicate<? super T>> components) {
            this.components = components;
            // ---------- Original Method ----------
            //this.components = components;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.781 -0400", hash_original_method = "6D31A308B444A1244C8D9BB7EDA35AF5", hash_generated_method = "E5789D46D2C8CD6A5AA404BE8E4AF2F3")
        public boolean apply(T t) {
            addTaint(t.getTaint());
for(Predicate<? super T> predicate : components)
            {
    if(!predicate.apply(t))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_373418410 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1695282039 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1695282039;
                } //End block
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_117106749 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1172158974 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1172158974;
            // ---------- Original Method ----------
            //for (Predicate<? super T> predicate : components) {
                //if (!predicate.apply(t)) {
                    //return false;
                //}
            //}
            //return true;
        }

        
    }


    
    private static class OrPredicate<T> implements Predicate<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.781 -0400", hash_original_field = "4725DCF446A342F1473A8228E42DFA48", hash_generated_field = "0796151CBA0A8A363E453698674B2FF1")

        private Iterable<? extends Predicate<? super T>> components;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.781 -0400", hash_original_method = "B6491EF17EA70E2615FEA24AC54E8597", hash_generated_method = "B016731DA2488694309B55D477B41B63")
        private  OrPredicate(Iterable<? extends Predicate<? super T>> components) {
            this.components = components;
            // ---------- Original Method ----------
            //this.components = components;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.782 -0400", hash_original_method = "C50E50ECDBC0F3F3FDB7CDFDDA2299C7", hash_generated_method = "6E07BC0BD69DB6DE6CDEBAB6D03C7005")
        public boolean apply(T t) {
            addTaint(t.getTaint());
for(Predicate<? super T> predicate : components)
            {
    if(predicate.apply(t))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_727835917 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_11103733 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_11103733;
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_614725281 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_369735464 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_369735464;
            // ---------- Original Method ----------
            //for (Predicate<? super T> predicate : components) {
                //if (predicate.apply(t)) {
                    //return true;
                //}
            //}
            //return false;
        }

        
    }


    
    private static class NotPredicate<T> implements Predicate<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.782 -0400", hash_original_field = "F670EF68565F21A50D96FB2B8746A338", hash_generated_field = "1F2E335622F7CC2AFE3755D1E7E5B593")

        private Predicate<? super T> predicate;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.782 -0400", hash_original_method = "1580F792FEAB20E5896374554CF174B0", hash_generated_method = "9BB8628BFCD98C7C0FB70FE1C67B09FF")
        private  NotPredicate(Predicate<? super T> predicate) {
            this.predicate = predicate;
            // ---------- Original Method ----------
            //this.predicate = predicate;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.783 -0400", hash_original_method = "03E08BFAE053695EB823C16C309BB346", hash_generated_method = "F88B09590670EEF1EFFA88615A30AB88")
        public boolean apply(T t) {
            addTaint(t.getTaint());
            boolean varA8849644A2BAC2259B8283F2A5CAEC7B_246803505 = (!predicate.apply(t));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1386993086 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1386993086;
            // ---------- Original Method ----------
            //return !predicate.apply(t);
        }

        
    }


    
}

