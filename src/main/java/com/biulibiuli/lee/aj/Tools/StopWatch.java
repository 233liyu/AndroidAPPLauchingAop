package com.biulibiuli.lee.aj.Tools;

import java.util.concurrent.TimeUnit;

/**
 * Created by lee on 2017/5/17.
 */

public class StopWatch {

    private long startTime;

    public long getStartTime() {
        return (elapsedTime != 0) ? TimeUnit.NANOSECONDS.toNanos(startTime) : 0;
    }

    public long getEndTime() {
        return (elapsedTime != 0) ? TimeUnit.NANOSECONDS.toNanos(endTime) : 0;
    }


    private long endTime;
    private long elapsedTime;

    public StopWatch() {
        //empty
    }

    private void reset() {
        startTime = 0;
        endTime = 0;
        elapsedTime = 0;
    }
    public void start() {
        reset();
        startTime = System.nanoTime();
    }

    public void stop() {
        if (startTime != 0) {
            endTime = System.nanoTime();
            elapsedTime = endTime - startTime;
        } else {
            reset();
        }
    }

    public long getTotalTimeMillis() {
        return (elapsedTime != 0) ? TimeUnit.NANOSECONDS.toNanos(endTime - startTime) : 0;
    }

}
