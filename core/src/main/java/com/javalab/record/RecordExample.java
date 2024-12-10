package com.javalab.record;

import java.lang.reflect.Constructor;
import java.util.Arrays;

/**
 * @author tham
 */
public class RecordExample {
    public static void main(String[] args) {
        Person person = new Person("Tham", "Chennai", 40);
        System.out.println(person);
        System.out.println(person.city());

        try {
            Class<?> aClass = Class.forName(Person.class.getName());
            Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
            Arrays.stream(declaredConstructors).forEach(System.out::println);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
