package com.javalab.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * @author tham
 */
public class ParallelStreamExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Parallel stream example");
        ParallelStreamExample streamExample = new ParallelStreamExample();

        int count = 10;
        streamExample.doNormalStream(count);
        streamExample.doParallelStream(count);
        streamExample.doParallelWithForkAndJoin(count);
    }

    private void doNormalStream(int count) {
        long start = System.currentTimeMillis();
        List<Integer> evenNumbers = getNumbers(count)
                .stream()
                .filter(n -> (n % 2 == 0))
                .toList();
        long end = System.currentTimeMillis();
        System.out.println("Time taken with normal: " + (end - start) + " ms");
    }

    private void doParallelStream(int count) {
        long start = System.currentTimeMillis();
        List<Integer> evenNumbers = getNumbers(count)
                .parallelStream()
                .filter(n -> (n % 2 == 0))
                .toList();
        long end = System.currentTimeMillis();
        System.out.println("Time taken with parallel: " + (end - start) + " ms");
    }

    private void doParallelWithForkAndJoin(int count) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool(16);
        List<Integer> evenNumbers = forkJoinPool.submit(() ->
            getNumbers(count)
                    .parallelStream()
                    .filter(n -> (n % 2 == 0))
                    .collect(toList())).get();
        long end = System.currentTimeMillis();
        forkJoinPool.shutdown();
        System.out.println("Time taken with parallel: " + (end - start) + " ms");
    }

    private List<Integer> getNumbers(int count) {
        ArrayList<Integer> numbers = new ArrayList<>(count);
        for (int i = 1; i <= count; i++) {
            numbers.add(i);
        }

        return numbers;
    }
}
