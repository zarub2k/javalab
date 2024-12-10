package com.javalab.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tham
 */
public class AtomicSequence {
    private static final AtomicInteger sequence = new AtomicInteger(1);

    public int getNumber() {
        return sequence.getAndIncrement();
    }

    public static void main(String[] args) {
        AtomicSequence atomicSequence = new AtomicSequence();
        System.out.println(atomicSequence.getNumber());
        System.out.println(atomicSequence.getNumber());
    }
}
