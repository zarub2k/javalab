package com.javalab.functional;

import java.util.function.Function;

/**
 * @author tham
 */
public class MethodRefExample {
    public static void main(String[] args) {
        new SubClass().superAndSub("Tham");
    }
}

class SuperClass {
    public String doWork(String value) {
        return "Super " + value;
    }
}

class SubClass extends SuperClass {
    @Override
    public String doWork(String value) {
        return "Sub " + value;
    }

    public void superAndSub(String value) {
        Function<String, String> subFn = this::doWork;
        String subResult = subFn.apply(value);
        System.out.println(subResult);

        Function<String, String> superFn = SubClass.super::doWork;
        String superResult = superFn.apply(value);
        System.out.println(superResult);
    }
}
