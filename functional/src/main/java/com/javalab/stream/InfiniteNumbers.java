package com.javalab.stream;

import java.util.Random;
import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Tham
 */
public class InfiniteNumbers {
    public static void main(String[] args) {
        InfiniteNumbers infiniteNumbers = new InfiniteNumbers();
        infiniteNumbers.doRandom(10);
        infiniteNumbers.doThreadLocalRandom(10);
        infiniteNumbers.doSplittableRandom(10);
    }

    private void doRandom(int count) {
        Random random = new Random();
        int[] evenNumbers = random.ints(count)
                .filter(num -> (num % 2 == 0))
                .toArray();
        System.out.println(evenNumbers.length);
    }

    private void doThreadLocalRandom(int count) {
        int[] evenNumbers = ThreadLocalRandom.current()
                .ints(count)
                .filter(num -> (num % 2 == 0))
                .toArray();
        System.out.println(evenNumbers);
    }

    private void doSplittableRandom(int count) {
        int[] evenNumbers = new SplittableRandom()
                .ints(count)
                .filter(num -> (num % 2 == 0))
                .toArray();
        System.out.println(evenNumbers);

    }
}
