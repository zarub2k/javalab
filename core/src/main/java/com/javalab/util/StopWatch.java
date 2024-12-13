package com.javalab.util;

/**
 * @author Tham
 */
public class StopWatch {
    private long start;

    private StopWatch() {
        reset();
    }

    public static StopWatch start() {
        return new StopWatch();
    }

    public long time() {
        return System.currentTimeMillis() - start;
    }

    private void reset() {
        start = System.currentTimeMillis();
    }
}
