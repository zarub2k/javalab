package com.javalab.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tham
 */
public class CountDownLatchExample {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(5);
        AtomicInteger count = new AtomicInteger();

        for (int i = 0; i < 10; i++) {
            Counter counter = new Counter(latch, i, count);
            new Thread(counter).start();
        }

        try {
            latch.await();
            System.out.println("Total: " + count.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
