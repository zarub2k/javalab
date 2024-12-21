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
//        return System.currentTimeMillis() - start;
        return (System.nanoTime() - start) / 1_000_000;
    }

    private void reset() {
//        start = System.currentTimeMillis();
        start = System.nanoTime();
    }
}
