package com.javalab.concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tham
 */
public class FixedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        CounterRunnable first = new CounterRunnable("First");
        CounterRunnable second = new CounterRunnable("Second");
        CounterRunnable third = new CounterRunnable("Third");

        fixedThreadPool.submit(first);
        fixedThreadPool.submit(second);
        fixedThreadPool.submit(third);

        fixedThreadPool.shutdown();
    }
}
