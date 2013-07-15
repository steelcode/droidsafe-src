package libcore.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

final class RetryableOutputStream extends AbstractHttpOutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.850 -0400", hash_original_field = "AA9F73EEA60A006820D0F8768BC8A3FC", hash_generated_field = "D8A77E2E2DC8CA16CE4A344FA1118F72")

    private int limit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.850 -0400", hash_original_field = "9A0364B9E99BB480DD25E1F0284C8555", hash_generated_field = "311998AF11DA0C9AD3FE931CF69A5C33")

    private ByteArrayOutputStream content;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.851 -0400", hash_original_method = "A832DB079A79DDBD6BA954E86DE3CFE0", hash_generated_method = "1352F636065EC36AE68B9261382DE447")
    public  RetryableOutputStream(int limit) {
        this.limit = limit;
        this.content = new ByteArrayOutputStream(limit);
        // ---------- Original Method ----------
        //this.limit = limit;
        //this.content = new ByteArrayOutputStream(limit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.861 -0400", hash_original_method = "ACF7E60D1B2648BBC92003365E201CCA", hash_generated_method = "A24CA35E6EF5C5C312D9E235C2290F0F")
    public  RetryableOutputStream() {
        this.limit = -1;
        this.content = new ByteArrayOutputStream();
        // ---------- Original Method ----------
        //this.limit = -1;
        //this.content = new ByteArrayOutputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.862 -0400", hash_original_method = "01295B07B18E8DACBE5B67B8ED73AB45", hash_generated_method = "1F3028E116DB45EA290333B546024FA7")
    @Override
    public synchronized void close() throws IOException {
    if(closed)        
        {
            return;
        } //End block
        closed = true;
    if(content.size() < limit)        
        {
            IOException var1DD03DF22ED4590BAB4F1A82055BB925_1165407268 = new IOException("content-length promised "
                    + limit + " bytes, but received " + content.size());
            var1DD03DF22ED4590BAB4F1A82055BB925_1165407268.addTaint(taint);
            throw var1DD03DF22ED4590BAB4F1A82055BB925_1165407268;
        } //End block
        // ---------- Original Method ----------
        //if (closed) {
            //return;
        //}
        //closed = true;
        //if (content.size() < limit) {
            //throw new IOException("content-length promised "
                    //+ limit + " bytes, but received " + content.size());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.862 -0400", hash_original_method = "E1F3BEFD89D2B57927FA9AF72B0F2441", hash_generated_method = "777BD2A80F1EFB63CD3E8478B5078AFE")
    @Override
    public synchronized void write(byte[] buffer, int offset, int count) throws IOException {
        addTaint(count);
        addTaint(offset);
        addTaint(buffer[0]);
        checkNotClosed();
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
    if(limit != -1 && content.size() > limit - count)        
        {
            IOException varC980F46BCED66653895B5BC599061556_362656126 = new IOException("exceeded content-length limit of " + limit + " bytes");
            varC980F46BCED66653895B5BC599061556_362656126.addTaint(taint);
            throw varC980F46BCED66653895B5BC599061556_362656126;
        } //End block
        content.write(buffer, offset, count);
        // ---------- Original Method ----------
        //checkNotClosed();
        //Arrays.checkOffsetAndCount(buffer.length, offset, count);
        //if (limit != -1 && content.size() > limit - count) {
            //throw new IOException("exceeded content-length limit of " + limit + " bytes");
        //}
        //content.write(buffer, offset, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.862 -0400", hash_original_method = "D6DA405C75C9B4A91F36F560BEF2D916", hash_generated_method = "AE566E23C5BED1CDA928538A3398DFF7")
    public synchronized int contentLength() throws IOException {
        close();
        int var072C841044B1A97A268EBCE85E0EDA06_570758158 = (content.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_158678455 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_158678455;
        // ---------- Original Method ----------
        //close();
        //return content.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.862 -0400", hash_original_method = "13EC0747B327446249F03815D15BF368", hash_generated_method = "A3693C2F57555438C4510076BEEA99F4")
    public void writeToSocket(OutputStream socketOut) throws IOException {
        addTaint(socketOut.getTaint());
        content.writeTo(socketOut);
        // ---------- Original Method ----------
        //content.writeTo(socketOut);
    }

    
}

