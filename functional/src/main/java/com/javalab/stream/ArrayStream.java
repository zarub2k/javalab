package com.javalab.stream;

import java.util.Arrays;

/**
 * @author Tham
 */
public class ArrayStream {
    public static void main(String[] args) {
        ArrayStream arrayStream = new ArrayStream();
        arrayStream.doSimple();
    }

    private void doSimple() {
        String[] fruits = new String[] {"banana", "apple", "kiwi", "orange", "mango"};
        String[] filteredFruits = Arrays.stream(fruits)
                .filter(fruit -> fruit.contains("a"))
                .sorted()
                .toArray(String[]::new);

        for (String filteredFruit : filteredFruits) {
            System.out.print(filteredFruit + "\t");
        }
    }
}
