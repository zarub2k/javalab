package com.javalab.concurrency.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * @author Tham
 */
public class ThreadLimitChecker {
    public static void main(String[] args) {
        new ThreadLimitChecker().checkLimit();
    }

    private void checkLimit() {
        AtomicInteger threadCount = new AtomicInteger(0);
        try {
            while (true) {
                Thread thread = new Thread(() -> {
                    threadCount.incrementAndGet();
                    LockSupport.park();
                });
                thread.start();
            }
        } catch (OutOfMemoryError error) {
            System.out.println("Reached thread limit: " + threadCount);
        }
    }
}
