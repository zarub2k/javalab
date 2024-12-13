package com.javalab.gc;

/**
 * @author tham
 */
public class GarbageCollection {
    public static void main(String[] args) {
        HelloClass first = new HelloClass("First");
        HelloClass second = new HelloClass("Second");

        first.ref = second;
        second.ref = first;

        System.out.println("After swap: " + first.ref.getName());

        first = null;
        second = null;
    }
}
