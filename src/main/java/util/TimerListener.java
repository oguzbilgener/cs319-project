package util;

import java.util.Timer;

/**
 * Created by asusss on 11.12.2015.
 */
public interface TimerListener {


    public void onTimeOut();

    public void onTick (int elapsedTime);
}
