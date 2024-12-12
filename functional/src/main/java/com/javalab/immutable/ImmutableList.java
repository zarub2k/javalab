package com.javalab.immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author tham
 */
public class ImmutableList {
    public static void main(String[] args) {
        ImmutableList immutableList = new ImmutableList();

        immutableList.doUnmodifiableList();
        immutableList.doFactory();
        immutableList.doCopiesOf();
    }

    private void doCopiesOf() {
        System.out.println("*** doCopiesOf() ***");
        List<Integer> numbers = new ArrayList<>(8);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        List<Integer> unmodifiable = List.copyOf(numbers);
        System.out.println("Initial size: " + unmodifiable.size());

        numbers.add(4);
        System.out.println("After size: " + unmodifiable.size());

        //Size doesn't change even if you add elements in the original list
        //Direct modification is not allowed in the copied list
    }

    private void doFactory() {
        System.out.println("*** doFactory() ***");
        List<Integer> numbers = List.of(1, 2, 3);
        System.out.println(numbers.size());

        //Modification is not allowed
    }

    private void doUnmodifiableList() {
        System.out.println("*** doUnmodifiableList() ***");

        List<Integer> numbers = new ArrayList<>(8);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        List<Integer> unmodifiable = Collections.unmodifiableList(numbers);
        System.out.println(unmodifiable.size());

        //Original list change is also reflected in the unmodifiable list
        numbers.add(4);
        System.out.println(unmodifiable.size());

        //direct modification of unmodifiable is not allowed
    }
}
