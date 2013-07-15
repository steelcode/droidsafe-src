package javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.address.URI;

public interface ErrorInfoHeader extends Header, Parameters {
    String NAME = "Error-Info";

    URI getErrorInfo();
    void setErrorInfo(URI errorInfo);

    String getErrorMessage();
    void setErrorMessage(String errorMessage) throws ParseException;
}
