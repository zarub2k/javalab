package com.javalab.concurrency;

public class NonAtomicThread implements Runnable {
    private static int count = 1;
    @Override
    public void run() {
        System.out.println(count++);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new NonAtomicThread().run();
        }
    }
}
