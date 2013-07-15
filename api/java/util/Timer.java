package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class Timer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.873 -0400", hash_original_field = "86CCEC3D9FF0E9C0514506E982CDC08B", hash_generated_field = "BD810B8E7F0EAA2CFBEB665BD5956193")

    private TimerImpl impl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.873 -0400", hash_original_field = "127161DB3B8D504B5618E82D4391BDDC", hash_generated_field = "BE0845D4DD46C2E4FF9E16078B08E358")

    @SuppressWarnings("unused") private FinalizerHelper finalizer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.873 -0400", hash_original_method = "CCBAE4C218CB3D4968980BC5ABE4FF3C", hash_generated_method = "C025DA2B7ABFC8A7D371D0251EC2ED72")
    public  Timer(String name, boolean isDaemon) {
    if(name == null)        
        {
            NullPointerException var58A4321B45460786CF04156338588D51_1553053024 = new NullPointerException("name is null");
            var58A4321B45460786CF04156338588D51_1553053024.addTaint(taint);
            throw var58A4321B45460786CF04156338588D51_1553053024;
        } //End block
        this.impl = new TimerImpl(name, isDaemon);
        this.finalizer = new FinalizerHelper(impl);
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new NullPointerException("name is null");
        //}
        //this.impl = new TimerImpl(name, isDaemon);
        //this.finalizer = new FinalizerHelper(impl);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.874 -0400", hash_original_method = "02AE08AD1BF27E917ED31D51A1B3D791", hash_generated_method = "BD760B12BCB3C9EFDD381D4F861D4E99")
    public  Timer(String name) {
        this(name, false);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.874 -0400", hash_original_method = "70CAEF4BF7F4A75D51C26667927F81EF", hash_generated_method = "7F5F59856E80CB782DD93EA124AC235F")
    public  Timer(boolean isDaemon) {
        this("Timer-" + Timer.nextId(), isDaemon);
        addTaint(isDaemon);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.874 -0400", hash_original_method = "0270210C5FDC4EA43E305D84D4C8B476", hash_generated_method = "F6B72E5049AAA19123589FFA16EED6C0")
    public  Timer() {
        this(false);
        // ---------- Original Method ----------
    }

    
        private synchronized static long nextId() {
        return timerId++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.875 -0400", hash_original_method = "4F9571F346BBFC93F458CCCC1BA285E2", hash_generated_method = "8B1BBB6959E6C72980148F70ACDA4DC6")
    public void cancel() {
        impl.cancel();
        // ---------- Original Method ----------
        //impl.cancel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.875 -0400", hash_original_method = "0B011E4041136408340083F55A5156B3", hash_generated_method = "33A3ED259F2304B035FA73F14E18AE0F")
    public int purge() {
        synchronized
(impl)        {
            int varEE43312D61A414CEF5C0AE967827BDB0_456749528 = (impl.purge());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_878519495 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_878519495;
        } //End block
        // ---------- Original Method ----------
        //synchronized (impl) {
            //return impl.purge();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.876 -0400", hash_original_method = "11725ACE17CC712A9ECE78E61369355E", hash_generated_method = "9DDC706642DB6BC58E6DE22FB4F9DCE7")
    public void schedule(TimerTask task, Date when) {
        addTaint(when.getTaint());
        addTaint(task.getTaint());
    if(when.getTime() < 0)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_18817571 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_18817571.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_18817571;
        } //End block
        long delay = when.getTime() - System.currentTimeMillis();
        scheduleImpl(task, delay < 0 ? 0 : delay, -1, false);
        // ---------- Original Method ----------
        //if (when.getTime() < 0) {
            //throw new IllegalArgumentException();
        //}
        //long delay = when.getTime() - System.currentTimeMillis();
        //scheduleImpl(task, delay < 0 ? 0 : delay, -1, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.876 -0400", hash_original_method = "C70A5270C6C8A079FCAADE9A65184BCF", hash_generated_method = "134591CC205B0DF9E37D325D8E278F03")
    public void schedule(TimerTask task, long delay) {
        addTaint(delay);
        addTaint(task.getTaint());
    if(delay < 0)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1197734192 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1197734192.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1197734192;
        } //End block
        scheduleImpl(task, delay, -1, false);
        // ---------- Original Method ----------
        //if (delay < 0) {
            //throw new IllegalArgumentException();
        //}
        //scheduleImpl(task, delay, -1, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.877 -0400", hash_original_method = "2638FF3E02C15EB097A85AD3BAF82535", hash_generated_method = "C8B2E7962F7C0BF27CB5DAE75A17CE84")
    public void schedule(TimerTask task, long delay, long period) {
        addTaint(period);
        addTaint(delay);
        addTaint(task.getTaint());
    if(delay < 0 || period <= 0)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1841376871 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1841376871.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1841376871;
        } //End block
        scheduleImpl(task, delay, period, false);
        // ---------- Original Method ----------
        //if (delay < 0 || period <= 0) {
            //throw new IllegalArgumentException();
        //}
        //scheduleImpl(task, delay, period, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.877 -0400", hash_original_method = "D1ECD2ED5B40CEEFE097F1521E46D9CD", hash_generated_method = "DCB16D552BA012D0ADF4EEB0801534E6")
    public void schedule(TimerTask task, Date when, long period) {
        addTaint(period);
        addTaint(when.getTaint());
        addTaint(task.getTaint());
    if(period <= 0 || when.getTime() < 0)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1480939151 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1480939151.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1480939151;
        } //End block
        long delay = when.getTime() - System.currentTimeMillis();
        scheduleImpl(task, delay < 0 ? 0 : delay, period, false);
        // ---------- Original Method ----------
        //if (period <= 0 || when.getTime() < 0) {
            //throw new IllegalArgumentException();
        //}
        //long delay = when.getTime() - System.currentTimeMillis();
        //scheduleImpl(task, delay < 0 ? 0 : delay, period, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.878 -0400", hash_original_method = "5346126CCA7833D0BFEF2BABD1293D7B", hash_generated_method = "3FA5A7649512FA6F34E94553740F7A4A")
    public void scheduleAtFixedRate(TimerTask task, long delay, long period) {
        addTaint(period);
        addTaint(delay);
        addTaint(task.getTaint());
    if(delay < 0 || period <= 0)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_755204081 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_755204081.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_755204081;
        } //End block
        scheduleImpl(task, delay, period, true);
        // ---------- Original Method ----------
        //if (delay < 0 || period <= 0) {
            //throw new IllegalArgumentException();
        //}
        //scheduleImpl(task, delay, period, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.878 -0400", hash_original_method = "6589A168C51AEA92DBDCD8B282926324", hash_generated_method = "4B5236C9D264FCD7F3C9A55D79833A9A")
    public void scheduleAtFixedRate(TimerTask task, Date when, long period) {
        addTaint(period);
        addTaint(when.getTaint());
        addTaint(task.getTaint());
    if(period <= 0 || when.getTime() < 0)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1541809491 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1541809491.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1541809491;
        } //End block
        long delay = when.getTime() - System.currentTimeMillis();
        scheduleImpl(task, delay, period, true);
        // ---------- Original Method ----------
        //if (period <= 0 || when.getTime() < 0) {
            //throw new IllegalArgumentException();
        //}
        //long delay = when.getTime() - System.currentTimeMillis();
        //scheduleImpl(task, delay, period, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.906 -0400", hash_original_method = "163F6B0C6203677A1F058E56FE2F9B83", hash_generated_method = "A6EC3DED7F6630566C89C0BC19FB2F12")
    private void scheduleImpl(TimerTask task, long delay, long period, boolean fixed) {
        addTaint(fixed);
        addTaint(period);
        addTaint(delay);
        addTaint(task.getTaint());
        synchronized
(impl)        {
    if(impl.cancelled)            
            {
                IllegalStateException var0BB09F01BAC90FFD5B3C2245DFE9B7A2_568261625 = new IllegalStateException("Timer was canceled");
                var0BB09F01BAC90FFD5B3C2245DFE9B7A2_568261625.addTaint(taint);
                throw var0BB09F01BAC90FFD5B3C2245DFE9B7A2_568261625;
            } //End block
            long when = delay + System.currentTimeMillis();
    if(when < 0)            
            {
                IllegalArgumentException varE7D003009295B401D276B7C5E483E5D0_2030818298 = new IllegalArgumentException("Illegal delay to start the TimerTask: " + when);
                varE7D003009295B401D276B7C5E483E5D0_2030818298.addTaint(taint);
                throw varE7D003009295B401D276B7C5E483E5D0_2030818298;
            } //End block
            synchronized
(task.lock)            {
    if(task.isScheduled())                
                {
                    IllegalStateException var91F8DCC7AB4AB3A3CD99B45FBEE2B654_366758729 = new IllegalStateException("TimerTask is scheduled already");
                    var91F8DCC7AB4AB3A3CD99B45FBEE2B654_366758729.addTaint(taint);
                    throw var91F8DCC7AB4AB3A3CD99B45FBEE2B654_366758729;
                } //End block
    if(task.cancelled)                
                {
                    IllegalStateException var9AC3458AB4F80B4ED04DA3C8CD16A92B_1500776994 = new IllegalStateException("TimerTask is canceled");
                    var9AC3458AB4F80B4ED04DA3C8CD16A92B_1500776994.addTaint(taint);
                    throw var9AC3458AB4F80B4ED04DA3C8CD16A92B_1500776994;
                } //End block
                task.when = when;
                task.period = period;
                task.fixedRate = fixed;
            } //End block
            impl.insertTask(task);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static final class TimerImpl extends Thread {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.907 -0400", hash_original_field = "38881E0A24039DC2621E1D6F86CB71F7", hash_generated_field = "DD77D1125D3DB6D338BBBF7F15E50974")

        private boolean cancelled;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.907 -0400", hash_original_field = "A5D7CEB2C59B8CEE46C2953FEC9ABC19", hash_generated_field = "3E2B0E3E2E572DECE0B20D77E19B79CF")

        private boolean finished;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.907 -0400", hash_original_field = "A922F9122839A05A2C3C193CED01A95B", hash_generated_field = "42B47F8DE84F38316DBD90F59FBB0655")

        private TimerHeap tasks = new TimerHeap();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.907 -0400", hash_original_method = "F4DF6B4551FDBC23EEE87B7E4E870504", hash_generated_method = "0158A66F82FBCEBBFA786948FF978793")
          TimerImpl(String name, boolean isDaemon) {
            addTaint(isDaemon);
            addTaint(name.getTaint());
            this.setName(name);
            this.setDaemon(isDaemon);
            this.start();
            // ---------- Original Method ----------
            //this.setName(name);
            //this.setDaemon(isDaemon);
            //this.start();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.909 -0400", hash_original_method = "F5D6E902D7971393BC779DF27078ED52", hash_generated_method = "1F9595157BA947B0FF17697CB5928844")
        @Override
        public void run() {
            while
(true)            
            {
                TimerTask task;
                synchronized
(this)                {
    if(cancelled)                    
                    {
                        return;
                    } //End block
    if(tasks.isEmpty())                    
                    {
    if(finished)                        
                        {
                            return;
                        } //End block
                        try 
                        {
                            this.wait();
                        } //End block
                        catch (InterruptedException ignored)
                        {
                        } //End block
                        continue;
                    } //End block
                    long currentTime = System.currentTimeMillis();
                    task = tasks.minimum();
                    long timeToSleep;
                    synchronized
(task.lock)                    {
    if(task.cancelled)                        
                        {
                            tasks.delete(0);
                            continue;
                        } //End block
                        timeToSleep = task.when - currentTime;
                    } //End block
    if(timeToSleep > 0)                    
                    {
                        try 
                        {
                            this.wait(timeToSleep);
                        } //End block
                        catch (InterruptedException ignored)
                        {
                        } //End block
                        continue;
                    } //End block
                    synchronized
(task.lock)                    {
                        int pos = 0;
    if(tasks.minimum().when != task.when)                        
                        {
                            pos = tasks.getTask(task);
                        } //End block
    if(task.cancelled)                        
                        {
                            tasks.delete(tasks.getTask(task));
                            continue;
                        } //End block
                        task.setScheduledTime(task.when);
                        tasks.delete(pos);
    if(task.period >= 0)                        
                        {
    if(task.fixedRate)                            
                            {
                                task.when = task.when + task.period;
                            } //End block
                            else
                            {
                                task.when = System.currentTimeMillis()
                                        + task.period;
                            } //End block
                            insertTask(task);
                        } //End block
                        else
                        {
                            task.when = 0;
                        } //End block
                    } //End block
                } //End block
                boolean taskCompletedNormally = false;
                try 
                {
                    task.run();
                    taskCompletedNormally = true;
                } //End block
                finally 
                {
    if(!taskCompletedNormally)                    
                    {
                        synchronized
(this)                        {
                            cancelled = true;
                        } //End block
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.911 -0400", hash_original_method = "1179C8665DD7C88A3DCD4C96D03B447E", hash_generated_method = "9E89276722C17DD5D648647E5CE84B00")
        private void insertTask(TimerTask newTask) {
            addTaint(newTask.getTaint());
            tasks.insert(newTask);
            this.notify();
            // ---------- Original Method ----------
            //tasks.insert(newTask);
            //this.notify();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.912 -0400", hash_original_method = "98F63C51B8CE3B66A34B3D1691EEC660", hash_generated_method = "D46269E7176EB5C7BED6DA170FC81CDE")
        public synchronized void cancel() {
            cancelled = true;
            tasks.reset();
            this.notify();
            // ---------- Original Method ----------
            //cancelled = true;
            //tasks.reset();
            //this.notify();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.913 -0400", hash_original_method = "14258CF4E602CCBF988A676BE8DF635B", hash_generated_method = "CEBCD06D62FEEC4976A8016A0D700495")
        public int purge() {
    if(tasks.isEmpty())            
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_455313254 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1701031637 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1701031637;
            } //End block
            tasks.deletedCancelledNumber = 0;
            tasks.deleteIfCancelled();
            int var125CDB22E2F814BD5BD9EA70BD93DD46_881694629 = (tasks.deletedCancelledNumber);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_820523895 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_820523895;
            // ---------- Original Method ----------
            //if (tasks.isEmpty()) {
                //return 0;
            //}
            //tasks.deletedCancelledNumber = 0;
            //tasks.deleteIfCancelled();
            //return tasks.deletedCancelledNumber;
        }

        
        private static final class TimerHeap {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.929 -0400", hash_original_field = "C30D0995BFA5B67E8BEB6F82218A7256", hash_generated_field = "5DCC43DD97C899F4FF86DBEA0DEC4532")

            private int DEFAULT_HEAP_SIZE = 256;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.929 -0400", hash_original_field = "DA0C237DC5B6D69E947A2A23D09D2A53", hash_generated_field = "E31F25F3395C26BA2E25CE6943B12BB4")

            private TimerTask[] timers = new TimerTask[DEFAULT_HEAP_SIZE];
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.929 -0400", hash_original_field = "4C519DE3531208469B40CCB51004CD2D", hash_generated_field = "C5D9FEC4EFB462C8A221F2C08D178643")

            private int size = 0;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.929 -0400", hash_original_field = "6B1DCD5522C8E4183D5D71E6F73B7276", hash_generated_field = "1B4C6ED5AD73B84D34A3A5D4C320C40E")

            private int deletedCancelledNumber = 0;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.929 -0400", hash_original_method = "8C2F50BDBBFD0A7BB81F89CAC3407288", hash_generated_method = "8C2F50BDBBFD0A7BB81F89CAC3407288")
            public TimerHeap ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.930 -0400", hash_original_method = "54D4D4169DAC5C26DC557B9A789FA70D", hash_generated_method = "5D8D1CB778C52D686F75B91C73A2B2C5")
            public TimerTask minimum() {
TimerTask var1C81D383AA0711D49D8E84469D54E1EE_467278133 =                 timers[0];
                var1C81D383AA0711D49D8E84469D54E1EE_467278133.addTaint(taint);
                return var1C81D383AA0711D49D8E84469D54E1EE_467278133;
                // ---------- Original Method ----------
                //return timers[0];
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.930 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "7EC93C0F7C9A11DBA6923AFE3EC5C89D")
            public boolean isEmpty() {
                boolean var9FB8BC7F775DDD98EEAB5582D340229E_1433541942 = (size == 0);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1597059967 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1597059967;
                // ---------- Original Method ----------
                //return size == 0;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.930 -0400", hash_original_method = "FCBB49BFF2D0F5589541AAD0BAE25774", hash_generated_method = "DFF2D8576F8FB86E563D8555DABEEBB8")
            public void insert(TimerTask task) {
    if(timers.length == size)                
                {
                    TimerTask[] appendedTimers = new TimerTask[size * 2];
                    System.arraycopy(timers, 0, appendedTimers, 0, size);
                    timers = appendedTimers;
                } //End block
                timers[size++] = task;
                upHeap();
                // ---------- Original Method ----------
                //if (timers.length == size) {
                    //TimerTask[] appendedTimers = new TimerTask[size * 2];
                    //System.arraycopy(timers, 0, appendedTimers, 0, size);
                    //timers = appendedTimers;
                //}
                //timers[size++] = task;
                //upHeap();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.930 -0400", hash_original_method = "0B132463A6995D392821B524FFDE805E", hash_generated_method = "1A3A61B29FD73D9DDAFF1DFE160D1067")
            public void delete(int pos) {
    if(pos >= 0 && pos < size)                
                {
                    timers[pos] = timers[--size];
                    timers[size] = null;
                    downHeap(pos);
                } //End block
                // ---------- Original Method ----------
                //if (pos >= 0 && pos < size) {
                    //timers[pos] = timers[--size];
                    //timers[size] = null;
                    //downHeap(pos);
                //}
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.930 -0400", hash_original_method = "4756DE20DDADB3FD04AA7E2F3A372FAC", hash_generated_method = "0FE597C2A467316BF52574CBF47EABA7")
            private void upHeap() {
                int current = size - 1;
                int parent = (current - 1) / 2;
                while
(timers[current].when < timers[parent].when)                
                {
                    TimerTask tmp = timers[current];
                    timers[current] = timers[parent];
                    timers[parent] = tmp;
                    current = parent;
                    parent = (current - 1) / 2;
                } //End block
                // ---------- Original Method ----------
                //int current = size - 1;
                //int parent = (current - 1) / 2;
                //while (timers[current].when < timers[parent].when) {
                    //TimerTask tmp = timers[current];
                    //timers[current] = timers[parent];
                    //timers[parent] = tmp;
                    //current = parent;
                    //parent = (current - 1) / 2;
                //}
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.930 -0400", hash_original_method = "A63AC6E1F65E01631F08DE00B4EE87D2", hash_generated_method = "DF26352513DBCDAAED705DA5F58C7574")
            private void downHeap(int pos) {
                addTaint(pos);
                int current = pos;
                int child = 2 * current + 1;
                while
(child < size && size > 0)                
                {
    if(child + 1 < size
                            && timers[child + 1].when < timers[child].when)                    
                    {
                        child++;
                    } //End block
    if(timers[current].when < timers[child].when)                    
                    {
                        break;
                    } //End block
                    TimerTask tmp = timers[current];
                    timers[current] = timers[child];
                    timers[child] = tmp;
                    current = child;
                    child = 2 * current + 1;
                } //End block
                // ---------- Original Method ----------
                //int current = pos;
                //int child = 2 * current + 1;
                //while (child < size && size > 0) {
                    //if (child + 1 < size
                            //&& timers[child + 1].when < timers[child].when) {
                        //child++;
                    //}
                    //if (timers[current].when < timers[child].when) {
                        //break;
                    //}
                    //TimerTask tmp = timers[current];
                    //timers[current] = timers[child];
                    //timers[child] = tmp;
                    //current = child;
                    //child = 2 * current + 1;
                //}
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.931 -0400", hash_original_method = "2535A97D037DD57E0DAFCE2BC7E2038E", hash_generated_method = "FEDFA13AA9192D076D68218879D9832F")
            public void reset() {
                timers = new TimerTask[DEFAULT_HEAP_SIZE];
                size = 0;
                // ---------- Original Method ----------
                //timers = new TimerTask[DEFAULT_HEAP_SIZE];
                //size = 0;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.931 -0400", hash_original_method = "D8C208FA954780F7AF0BEF19488333D3", hash_generated_method = "655D2B1724BE5C017764F419A1F28993")
            public void adjustMinimum() {
                downHeap(0);
                // ---------- Original Method ----------
                //downHeap(0);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.931 -0400", hash_original_method = "AE1ACEED0F069268C38EE209755704B2", hash_generated_method = "2D77D154B7B641CB726981921D5B72C7")
            public void deleteIfCancelled() {
for(int i = 0;i < size;i++)
                {
    if(timers[i].cancelled)                    
                    {
                        deletedCancelledNumber++;
                        delete(i);
                        i--;
                    } //End block
                } //End block
                // ---------- Original Method ----------
                //for (int i = 0; i < size; i++) {
                    //if (timers[i].cancelled) {
                        //deletedCancelledNumber++;
                        //delete(i);
                        //i--;
                    //}
                //}
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.931 -0400", hash_original_method = "B28407BF2F77FCC6A87AD91AEA3746F4", hash_generated_method = "5612B3638BEB4832C93ADBB475C80DB4")
            private int getTask(TimerTask task) {
                addTaint(task.getTaint());
for(int i = 0;i < timers.length;i++)
                {
    if(timers[i] == task)                    
                    {
                        int var865C0C0B4AB0E063E5CAA3387C1A8741_255223037 = (i);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2049496618 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2049496618;
                    } //End block
                } //End block
                int var6BB61E3B7BCE0931DA574D19D1D82C88_884090990 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1605783056 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1605783056;
                // ---------- Original Method ----------
                //for (int i = 0; i < timers.length; i++) {
                    //if (timers[i] == task) {
                        //return i;
                    //}
                //}
                //return -1;
            }

            
        }


        
    }


    
    private static final class FinalizerHelper {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.931 -0400", hash_original_field = "86CCEC3D9FF0E9C0514506E982CDC08B", hash_generated_field = "BD810B8E7F0EAA2CFBEB665BD5956193")

        private TimerImpl impl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.931 -0400", hash_original_method = "433E2FD3ED4C8DEDF63A6DA216B65604", hash_generated_method = "4CBFABE13119C5255BCBDD03AEBE9965")
          FinalizerHelper(TimerImpl impl) {
            this.impl = impl;
            // ---------- Original Method ----------
            //this.impl = impl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.931 -0400", hash_original_method = "DFA080161CE25EF58ACF3FC158495E65", hash_generated_method = "1DC87F90FCB2BC9375168FE79903EE7D")
        @Override
        protected void finalize() throws Throwable {
            try 
            {
                synchronized
(impl)                {
                    impl.finished = true;
                    impl.notify();
                } //End block
            } //End block
            finally 
            {
                super.finalize();
            } //End block
            // ---------- Original Method ----------
            //try {
                //synchronized (impl) {
                    //impl.finished = true;
                    //impl.notify();
                //}
            //} finally {
                //super.finalize();
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.931 -0400", hash_original_field = "D788D0843582347FA30F14628757091E", hash_generated_field = "AE70AF39EAB820096114FC8C9C2796F7")

    private static long timerId;
}

