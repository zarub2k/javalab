package com.javalab.concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tham
 */
public class CachedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();

        CounterRunnable first = new CounterRunnable("First");
        CounterRunnable second = new CounterRunnable("Second");
        CounterRunnable third = new CounterRunnable("Third");

        threadPool.submit(first);
        threadPool.submit(second);
        threadPool.submit(third);

        threadPool.shutdown();
    }
}
