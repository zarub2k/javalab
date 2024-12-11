package com.javalab.immutability;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author tham
 */
public class ImmutabilityExample {
    public static void main(String[] args) {
        ImmutabilityExample immutabilityExample = new ImmutabilityExample();
//        immutabilityExample.simpleImmutable();

        immutabilityExample.doModifyOriginal();
    }

    //unmodifiableList is view for the original list.
    //So any changes to the original will be reflected in the unmodifiable view
    private void doModifyOriginal() {
        List<Object> original = new ArrayList<>();
        original.add("one");
        original.add("two");

//        List<List<Object>> unmodifiable = List.of(original);
        List<Object> unmodifiable = Collections.unmodifiableList(original);
        System.out.println("Before size: " + unmodifiable.size());

        original.add("three");
        System.out.println("After size: " + unmodifiable.size());
    }

    private void simpleImmutable() {
        List<Object> modifiable = new ArrayList<>();
        modifiable.add("one");
        modifiable.add("two");

        List<Object> unmodifiable = List.of(modifiable);
        try {
            unmodifiable.add("three");
        } catch (Exception e) {
            System.out.println("Error happened");
        }
    }
}
