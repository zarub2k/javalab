package com.javalab.concurrency.executors;

import static java.lang.Thread.currentThread;

public class CounterRunnable implements Runnable {
    private String title;
    public CounterRunnable(String title) {
        this.title = title;
    }
    int size = 5;
    @Override
    public void run() {
        for (int i = 0; i < size; i++) {
            System.out.println(currentThread().getName() + ">>>" + title + " " + i);
        }
    }
}
