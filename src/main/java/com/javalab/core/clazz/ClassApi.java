package com.javalab.core.clazz;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author tham
 */
public class ClassApi {
    public void hello() {
        System.out.println("Welcome hello()");
    }

    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName(ClassApi.class.getName());
            Method[] methods = clazz.getMethods();
            Arrays.stream(methods).forEach(System.out::println);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
