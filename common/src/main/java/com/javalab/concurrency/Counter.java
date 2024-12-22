package com.javalab.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter implements Runnable {
    private CountDownLatch latch;
    private int value;
    private AtomicInteger count;

    public Counter(CountDownLatch latch, int value, AtomicInteger count) {
        this.latch = latch;
        this.value = value;
        this.count = count;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        count.addAndGet(value);
        latch.countDown();
    }
}
