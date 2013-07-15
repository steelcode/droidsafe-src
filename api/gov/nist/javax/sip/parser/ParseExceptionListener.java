package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.message.*;
import java.text.ParseException;

public interface ParseExceptionListener {
    
    public void handleException(
        ParseException ex,
        SIPMessage sipMessage,
        Class headerClass,
        String headerText,
        String messageText)
        throws ParseException;
}
