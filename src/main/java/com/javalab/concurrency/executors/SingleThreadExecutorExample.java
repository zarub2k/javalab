package com.javalab.concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tham
 */
public class SingleThreadExecutorExample {
    public static void main(String[] args) {
        CounterRunnable first = new CounterRunnable("First");
        CounterRunnable second = new CounterRunnable("Second");

        ExecutorService pool1 = Executors.newSingleThreadExecutor();
        ExecutorService pool2 = Executors.newSingleThreadExecutor();

        pool1.submit(first);
        pool2.submit(second);

        pool1.shutdown();
        pool2.shutdown();
    }
}
