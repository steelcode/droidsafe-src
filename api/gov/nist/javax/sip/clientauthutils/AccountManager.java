package gov.nist.javax.sip.clientauthutils;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.ClientTransaction;

public interface AccountManager {

    

    UserCredentials getCredentials(ClientTransaction challengedTransaction, String realm);

}
