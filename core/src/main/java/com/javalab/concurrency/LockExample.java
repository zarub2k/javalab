package com.javalab.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    public void doLock() {
        final Lock lock = new ReentrantLock();
        int count = 0;
        try {
            lock.lock();
            count += 1;
            System.out.println(count);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockExample lockExample = new LockExample();
        lockExample.doLock();

        lockExample.doLock();
    }
}
