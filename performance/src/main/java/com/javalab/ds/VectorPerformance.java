package com.javalab.ds;

import com.javalab.util.StopWatch;

import java.util.Vector;

/**
 * @author Tham
 */
public class VectorPerformance {
    public static void main(String[] args) {
        VectorPerformance vectorPerformance = new VectorPerformance();

        int count = 100000000;
        vectorPerformance.doSimpleVector(count);
        vectorPerformance.doSimpleArray(count);
    }

    private void doSimpleArray(int size) {
        StopWatch stopWatch = StopWatch.start();
        Integer[] numbers = new Integer[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = i;
        }
        long timeTaken = stopWatch.time();
        System.out.println("Time taken in doSimpleArray(): " + timeTaken + "ms");
    }

    private void doSimpleVector(int size) {
        StopWatch stopWatch = StopWatch.start();
        Vector<Integer> numbers = new Vector<>();
        for (int i = 0; i < size; i++) {
            numbers.add(i);
        }

        long timeTaken = stopWatch.time();
        System.out.println("Time taken in doSimpleVector(): " + timeTaken + "ms");
    }
}
