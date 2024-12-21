package com.javalab.concurrency.thread;

import com.javalab.util.StopWatch;

import java.math.BigInteger;
import java.util.stream.IntStream;

/**
 * @author Tham
 */
public class ParallelExecutionStrategy {
    public static void main(String[] args) {
        ParallelExecutionStrategy parallelExecutionStrategy = new ParallelExecutionStrategy();
//        parallelExecutionStrategy.doRegular();
        parallelExecutionStrategy.doThread();
    }

    private void doThread() {
        StopWatch stopWatch = StopWatch.start();

        var t1 = new Thread(() -> {
            doStuff(1000);
        });
        var t2 = new Thread(() -> {
            doStuff(10000);
        });
        var t3 = new Thread(() -> {
            doStuff(100000);
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Overall time taken: " + stopWatch.time() + "ms");
    }

    private void doRegular() {
        StopWatch stopWatch = StopWatch.start();
        doStuff(1000);
        doStuff(10000);
        doStuff(100000);
//        doStuff(1000000);
//        doStuff(10000000);
//        doStuff(10000);
        System.out.println("Overall time taken: " + stopWatch.time() + "ms");
    }

    private void doStuff(int count) {
        StopWatch stopWatch = StopWatch.start();
        long total = 0L;
        int[] intValues = IntStream.range(0, count)
                .toArray();
        for (int i = 1; i <= count; i++) {
            total += i;

            IntStream.range(0, count)
                    .filter(v -> v % 2 == 0)
                    .toArray();
        }


        System.out.println("Total for " + count + " numbers: " + total);
        System.out.println("Time taken for " + count + ": " + stopWatch.time() + "ms");
    }
}
