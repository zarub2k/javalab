package com.javalab.stream;

import java.util.Random;
import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Tham
 */
public class RandomNumbers {
    public static void main(String[] args) {
        RandomNumbers randomNumbers = new RandomNumbers();
        randomNumbers.doRandom(10);
        randomNumbers.doThreadLocalRandom(10);
        randomNumbers.doSplittableRandom(10);
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
