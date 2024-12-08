package com.javalab;

import java.util.function.Function;

public class HigherOrderFunction {
    public static void main(String[] args) {
        String value = "Tham";

        Function<String, String> fun = prefix("Hello");
        System.out.println(fun.apply(value));

        String doublePrefix = doublePrefix("Tham", fun);
        System.out.println(doublePrefix);
    }

    public static String doublePrefix(String value, Function<String, String> fun) {
        return fun.apply(fun.apply(value));
    }

    public static Function<String, String> prefix(String pref) {
        return s -> pref + " : " + s;
    }
}
