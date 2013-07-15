package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.provider.Browser;
import android.util.Log;
import java.io.File;
import java.util.HashMap;
import java.util.Vector;

public final class WebIconDatabase {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.482 -0400", hash_original_field = "FD607A408617F0526DD1616AA88B403D", hash_generated_field = "AD056510E524158496964C320931C857")

    private final EventHandler mEventHandler = new EventHandler();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.482 -0400", hash_original_method = "D97F7EFB28FBFEC67D724170FB0509C5", hash_generated_method = "282A0D53C15427A619DE121EA3CBF850")
    private  WebIconDatabase() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.483 -0400", hash_original_method = "3087EA5DA62EA4F11A4DE20CD6A73D07", hash_generated_method = "93422ABAF42AD04712EF83DE90B1A172")
    public void open(String path) {
        addTaint(path.getTaint());
    if(path != null)        
        {
            File db = new File(path);
    if(!db.exists())            
            {
                db.mkdirs();
            } //End block
            mEventHandler.postMessage(
                    Message.obtain(null, EventHandler.OPEN, db.getAbsolutePath()));
        } //End block
        // ---------- Original Method ----------
        //if (path != null) {
            //File db = new File(path);
            //if (!db.exists()) {
                //db.mkdirs();
            //}
            //mEventHandler.postMessage(
                    //Message.obtain(null, EventHandler.OPEN, db.getAbsolutePath()));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.483 -0400", hash_original_method = "331AABE14B3E5742E4C5E7CDDA5A9C2E", hash_generated_method = "A4D270AD90EEAE71E57F3A5DC98F2FC3")
    public void close() {
        mEventHandler.postMessage(
                Message.obtain(null, EventHandler.CLOSE));
        // ---------- Original Method ----------
        //mEventHandler.postMessage(
                //Message.obtain(null, EventHandler.CLOSE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.483 -0400", hash_original_method = "A85BFB776007018F103CC92C345AF37F", hash_generated_method = "7BDEB7DCE0A1FAA95EC131AE3AF5AB03")
    public void removeAllIcons() {
        mEventHandler.postMessage(
                Message.obtain(null, EventHandler.REMOVE_ALL));
        // ---------- Original Method ----------
        //mEventHandler.postMessage(
                //Message.obtain(null, EventHandler.REMOVE_ALL));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.484 -0400", hash_original_method = "794C674767A8A815CC73A4F95B03095B", hash_generated_method = "78DA8029FD53C8F48B859365FAA1A5C7")
    public void requestIconForPageUrl(String url, IconListener listener) {
        addTaint(listener.getTaint());
        addTaint(url.getTaint());
    if(listener == null || url == null)        
        {
            return;
        } //End block
        Message msg = Message.obtain(null, EventHandler.REQUEST_ICON, listener);
        msg.getData().putString("url", url);
        mEventHandler.postMessage(msg);
        // ---------- Original Method ----------
        //if (listener == null || url == null) {
            //return;
        //}
        //Message msg = Message.obtain(null, EventHandler.REQUEST_ICON, listener);
        //msg.getData().putString("url", url);
        //mEventHandler.postMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.484 -0400", hash_original_method = "7ACE864BB2DE1EE9743E78ECD884C38E", hash_generated_method = "CBB0BFE3A2F9756321EC6ABE2B1FAC2B")
    public void bulkRequestIconForPageUrl(ContentResolver cr, String where,
            IconListener listener) {
        addTaint(listener.getTaint());
        addTaint(where.getTaint());
        addTaint(cr.getTaint());
    if(listener == null)        
        {
            return;
        } //End block
    if(mEventHandler.hasHandler())        
        {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("contentResolver", cr);
            map.put("where", where);
            map.put("listener", listener);
            Message msg = Message.obtain(null, EventHandler.BULK_REQUEST_ICON, map);
            mEventHandler.postMessage(msg);
        } //End block
        // ---------- Original Method ----------
        //if (listener == null) {
            //return;
        //}
        //if (mEventHandler.hasHandler()) {
            //HashMap<String, Object> map = new HashMap<String, Object>();
            //map.put("contentResolver", cr);
            //map.put("where", where);
            //map.put("listener", listener);
            //Message msg =
                    //Message.obtain(null, EventHandler.BULK_REQUEST_ICON, map);
            //mEventHandler.postMessage(msg);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.485 -0400", hash_original_method = "4FB0334B2FC007108F7A611624721C63", hash_generated_method = "2D22E3EA904FF5022FDA2FAA19DF252E")
    public void retainIconForPageUrl(String url) {
        addTaint(url.getTaint());
    if(url != null)        
        {
            mEventHandler.postMessage(
                    Message.obtain(null, EventHandler.RETAIN_ICON, url));
        } //End block
        // ---------- Original Method ----------
        //if (url != null) {
            //mEventHandler.postMessage(
                    //Message.obtain(null, EventHandler.RETAIN_ICON, url));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.485 -0400", hash_original_method = "742C1A356F3DFC35D629978FF2508090", hash_generated_method = "4993787828FAFAEA1712C944D387FC27")
    public void releaseIconForPageUrl(String url) {
        addTaint(url.getTaint());
    if(url != null)        
        {
            mEventHandler.postMessage(
                    Message.obtain(null, EventHandler.RELEASE_ICON, url));
        } //End block
        // ---------- Original Method ----------
        //if (url != null) {
            //mEventHandler.postMessage(
                    //Message.obtain(null, EventHandler.RELEASE_ICON, url));
        //}
    }

    
        public static WebIconDatabase getInstance() {
        if (sIconDatabase == null) {
            sIconDatabase = new WebIconDatabase();
        }
        return sIconDatabase;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.486 -0400", hash_original_method = "B1AD2CC25FCD72FA4E655F2F00EE9B34", hash_generated_method = "C9CAC81B44791934BB05AC045BCDD274")
     void createHandler() {
        mEventHandler.createHandler();
        // ---------- Original Method ----------
        //mEventHandler.createHandler();
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeOpen(String path) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeClose() {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeRemoveAllIcons() {
    }

    
    @DSModeled(DSC.SAFE)
    private static Bitmap nativeIconForPageUrl(String url) {
    	Bitmap bm = BitmapFactory.decodeByteArray(new byte[1], 0, 0);
    	return bm; 
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeRetainIconForPageUrl(String url) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeReleaseIconForPageUrl(String url) {
    }

    
    private static class EventHandler extends Handler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.487 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.487 -0400", hash_original_field = "ED45FF5D313A78F9E6C93B2590E118DE", hash_generated_field = "9B89FFC17BC75E97744A4692FA4B431D")

        private Vector<Message> mMessages = new Vector<Message>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.487 -0400", hash_original_method = "FFA7F4A8F990D2647EE1D5FBAEBEF779", hash_generated_method = "FFA7F4A8F990D2647EE1D5FBAEBEF779")
        public EventHandler ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.488 -0400", hash_original_method = "933A9372A0E78DFEA9569EC4FAF2FF2F", hash_generated_method = "8928D4872C4C373EAE3C039F6A7B7EA5")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
switch(msg.what){
            case ICON_RESULT:
            ((IconResult) msg.obj).dispatch();
            break;
}
            // ---------- Original Method ----------
            //switch (msg.what) {
                //case ICON_RESULT:
                    //((IconResult) msg.obj).dispatch();
                    //break;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.489 -0400", hash_original_method = "93C53855D8E83D18C38BE52A1D7D3DDC", hash_generated_method = "5DC0526D0441AEE802C3BBD89D0CA9FE")
        private synchronized void createHandler() {
    if(mHandler == null)            
            {
                mHandler = new Handler() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.489 -0400", hash_original_method = "3C22CFB4454B8CCB86512982F7DADD26", hash_generated_method = "381430AA3AE9CAABFE46E1D8AB7E7589")
            @Override
            public void handleMessage(Message msg) {
                addTaint(msg.getTaint());
switch(msg.what){
                case OPEN:
                nativeOpen((String) msg.obj);
                break;
                case CLOSE:
                nativeClose();
                break;
                case REMOVE_ALL:
                nativeRemoveAllIcons();
                break;
                case REQUEST_ICON:
                IconListener l = (IconListener) msg.obj;
                String url = msg.getData().getString("url");
                requestIconAndSendResult(url, l);
                break;
                case BULK_REQUEST_ICON:
                bulkRequestIcons(msg);
                break;
                case RETAIN_ICON:
                nativeRetainIconForPageUrl((String) msg.obj);
                break;
                case RELEASE_ICON:
                nativeReleaseIconForPageUrl((String) msg.obj);
                break;
}
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }
};
for(int size = mMessages.size();size > 0;size--)
                {
                    mHandler.sendMessage(mMessages.remove(0));
                } //End block
                mMessages = null;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.489 -0400", hash_original_method = "9D0DE68A4BFD007DC242C5FC5FA57FA9", hash_generated_method = "CBA6CFC8B1951D9F982D99886F2E66A6")
        private synchronized boolean hasHandler() {
            boolean varA0688A549C082DCF7CAF0C6FBCF98DF0_1628843660 = (mHandler != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1677736695 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1677736695;
            // ---------- Original Method ----------
            //return mHandler != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.489 -0400", hash_original_method = "4B2498A7504C7636E794F105FA929903", hash_generated_method = "0202DD5EAF607240E4BC3B821012E9A1")
        private synchronized void postMessage(Message msg) {
            addTaint(msg.getTaint());
    if(mMessages != null)            
            {
                mMessages.add(msg);
            } //End block
            else
            {
                mHandler.sendMessage(msg);
            } //End block
            // ---------- Original Method ----------
            //if (mMessages != null) {
                //mMessages.add(msg);
            //} else {
                //mHandler.sendMessage(msg);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.490 -0400", hash_original_method = "14DAA8F1389B41CD064DE9C446247235", hash_generated_method = "23ECBFB9B098173DBFD03A1D1E948F8C")
        private void bulkRequestIcons(Message msg) {
            addTaint(msg.getTaint());
            HashMap map = (HashMap) msg.obj;
            IconListener listener = (IconListener) map.get("listener");
            ContentResolver cr = (ContentResolver) map.get("contentResolver");
            String where = (String) map.get("where");
            Cursor c = null;
            try 
            {
                c = cr.query(
                        Browser.BOOKMARKS_URI,
                        new String[] { Browser.BookmarkColumns.URL },
                        where, null, null);
    if(c.moveToFirst())                
                {
                    do {
                        {
                            String url = c.getString(0);
                            requestIconAndSendResult(url, listener);
                        } //End block
} while (c.moveToNext());
                } //End block
            } //End block
            catch (IllegalStateException e)
            {
            } //End block
            finally 
            {
    if(c != null)                
                c.close();
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.490 -0400", hash_original_method = "FD70C30826AD390D3E7262DECFBF2A75", hash_generated_method = "A455A86F8F192B381120BAEE4E8FF6DD")
        private void requestIconAndSendResult(String url, IconListener listener) {
            addTaint(listener.getTaint());
            addTaint(url.getTaint());
            Bitmap icon = nativeIconForPageUrl(url);
    if(icon != null)            
            {
                sendMessage(obtainMessage(ICON_RESULT,
                            new IconResult(url, icon, listener)));
            } //End block
            // ---------- Original Method ----------
            //Bitmap icon = nativeIconForPageUrl(url);
            //if (icon != null) {
                //sendMessage(obtainMessage(ICON_RESULT,
                            //new IconResult(url, icon, listener)));
            //}
        }

        
        private class IconResult {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.491 -0400", hash_original_field = "8299C83E9CFFA2EF5909444648349221", hash_generated_field = "9C2E85EC79E8F8349BF2E81BA4AC7991")

            private String mUrl;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.491 -0400", hash_original_field = "1A265556E59DF15CAEC4E55FB61E68C7", hash_generated_field = "817E9CCF7085AADAC424D9C5A9C974DC")

            private Bitmap mIcon;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.491 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "5923DC2A4A9F5F2A44874626DE94545F")

            private IconListener mListener;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.491 -0400", hash_original_method = "88D8D1712732D1C320641A492AB35980", hash_generated_method = "02AF325532F14A0DBED7958BA93541CF")
              IconResult(String url, Bitmap icon, IconListener l) {
                mUrl = url;
                mIcon = icon;
                mListener = l;
                // ---------- Original Method ----------
                //mUrl = url;
                //mIcon = icon;
                //mListener = l;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.492 -0400", hash_original_method = "0BD69C5EE78EDD047C8FC1E711DA2EA8", hash_generated_method = "37E27E327CE1FC5B9184E444CD4F387F")
             void dispatch() {
                mListener.onReceivedIcon(mUrl, mIcon);
                // ---------- Original Method ----------
                //mListener.onReceivedIcon(mUrl, mIcon);
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.492 -0400", hash_original_field = "43717087C14CDCDCFDB18BD5D73ABF14", hash_generated_field = "1E570EBE80E5338300BCCB2022DC26E3")

        static final int OPEN = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.492 -0400", hash_original_field = "18310FC3CD7070BE891619B822283AE9", hash_generated_field = "A51E20F4691086AF2C72AAF5EE5A9914")

        static final int CLOSE = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.492 -0400", hash_original_field = "21B244C6846C6ADF33D927F052761C6E", hash_generated_field = "716F1C3E603A06F1507CFAA9733E8B89")

        static final int REMOVE_ALL = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.492 -0400", hash_original_field = "537C6DB203C5D8D84ADD60B22C45CC1A", hash_generated_field = "2CBD1EDD3DFEDFC0E9FD8D72A1133969")

        static final int REQUEST_ICON = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.492 -0400", hash_original_field = "B7004FBC13FA77F75E28084C88B3C052", hash_generated_field = "B30A72E74E189578C2C06D7364CD4163")

        static final int RETAIN_ICON = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.492 -0400", hash_original_field = "A965153BA664276AC54748DB21E81458", hash_generated_field = "9CC14ECB732977917B0E84738C888F5C")

        static final int RELEASE_ICON = 5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.492 -0400", hash_original_field = "97DDCAE8EE3CF6051295DDB51D779E89", hash_generated_field = "2F9B877ECA5216C8090B560C55BCCA1A")

        static final int BULK_REQUEST_ICON = 6;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.492 -0400", hash_original_field = "56556CDDF4E8A1A0524A2C00FD227265", hash_generated_field = "B0A0879D569A0231D6AC374E4FE85D66")

        private static final int ICON_RESULT = 10;
    }


    
    public interface IconListener {
        
        public void onReceivedIcon(String url, Bitmap icon);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.492 -0400", hash_original_field = "8357A9E0412FA3D1716757D2F1D5F1BA", hash_generated_field = "1F07299C39AF9E2A5CCA0FEC4BF5CF2A")

    private static final String LOGTAG = "WebIconDatabase";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.492 -0400", hash_original_field = "02465D8C3B346AC5C8E8CC44424AAA09", hash_generated_field = "30A3B2F719758B961B07CE52D4048FB9")

    private static WebIconDatabase sIconDatabase;
}

