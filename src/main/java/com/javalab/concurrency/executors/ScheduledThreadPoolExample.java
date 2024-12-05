package com.javalab.concurrency.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author tham
 */
public class ScheduledThreadPoolExample {
    public static void main(String[] args) {
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(2);

        CounterRunnable first = new CounterRunnable("#1");
        threadPool.scheduleAtFixedRate(first, 10, 10, TimeUnit.SECONDS);

//        threadPool.shutdown();
    }
}
