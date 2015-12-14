package util;

import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by asusss on 11.12.2015.
 */
public class TurnTimer {

    private Timer timer;
    private int count;
    private Set<TimerListener> listeners;

    public TurnTimer ()
    {
        listeners = new HashSet<>();
    }

    public void addListener(TimerListener listener) {
        listeners.add(listener);
    }

    public void schedule() {
        schedule(12);
    }

    public void schedule(int countStart) {
        count = countStart;
        TimerTask timerT = new TimerTask() {
            @Override
            public void run() {
                count--;
                for(TimerListener listener: listeners) {
                    listener.onTick(count);
                    if(count==0) {
                        listener.onTimeOut();
                        timer.cancel();

                    }
                }
            }
        };

        timer = new Timer();
        timer.scheduleAtFixedRate(timerT, 1000, 1000);


    }

    public void cancel() {
        if(timer != null) {
            timer.cancel();
        }
    }

}
