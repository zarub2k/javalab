package com.javalab.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicThread implements Runnable {
    private static final AtomicInteger seq = new AtomicInteger(1);

    @Override
    public void run() {
        System.out.println(seq.getAndIncrement());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new AtomicThread().run();
        }
    }
}
