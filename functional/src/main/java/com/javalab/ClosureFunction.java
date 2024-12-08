package com.javalab;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class ClosureFunction {
    public static void main(String[] args) {
        System.out.println(closure().apply(1));

        System.out.println(closure().apply(2));

        System.out.println(closure().apply(1));
    }

    public static Function<Integer, Integer> closure() {
        var atomic = new AtomicInteger(0);
        return atomic::addAndGet;
    }
}
