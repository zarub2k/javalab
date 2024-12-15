package com.javalab.stream;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Tham
 */
public class IterativeStream {
    public static void main(String[] args) {
        IterativeStream iterativeStream = new IterativeStream();
        iterativeStream.doIterativeStream(100);
    }

    private void toMapToIntStream(int count) {
        IntStream intStream = Stream.generate(new AtomicInteger()::incrementAndGet)
                .limit(count)
                .mapToInt(Integer::intValue);
    }

    private void doIterativeStream(int count) {
        int[] numbers = IntStream
                .iterate(1, itr -> itr + 1)
                .limit(count)
                .toArray();
        System.out.println(numbers.length);
        System.out.println(numbers[49]);
    }
}
