package com.javalab.concurrency.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Tham
 */
public class ThreadViaExecutors {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Executing thread: " + taskId +
                        " in " + Thread.currentThread().getName());
            });
        }

        executor.shutdown();
    }
}
