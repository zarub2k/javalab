package com.javalab.ds;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author tham
 */
public class HighPerformanceList {
    public static void main(String[] args) {
        HighPerformanceList highPerformanceList = new HighPerformanceList();

        highPerformanceList.doCheckLinkedListWithList(10000);
        highPerformanceList.doCheckLinkedList(10000);
    }

    //Linked list can be more performant when
    //You add / remove objects more frequently
    private void doCheckLinkedList(int size) {
        //With type LinkedList<Integer>
        LinkedList<Integer> numbers = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(i);
        }

        System.out.println("*** Check performance with LinkedList type ***");
        long start = System.currentTimeMillis();
        System.out.println("numbers contain 10: " + numbers.contains(10));
        System.out.println("numbers contain " + (size + 1) + ": " + numbers.contains(size + 1));

        Random random = new Random(size - 1);
        System.out.println("Get a number: " + numbers.get(random.nextInt(size - 1)));
        System.out.println("Get a number: " + numbers.get(random.nextInt(size - 1)));

        long end = System.currentTimeMillis();
        System.out.println("Time taken with LinkedList option: " + (end - start) + "ms");
    }

    private void doCheckLinkedListWithList(int size) {
        //With type List<Integer>
        List<Integer> numbers = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(i);
        }

        System.out.println("*** Check performance for List type ***");
        long start = System.currentTimeMillis();
        System.out.println("numbers contain 10: " + numbers.contains(10));
        System.out.println("numbers contain " + (size + 1) + ": " + numbers.contains(size + 1));

        Random random = new Random(size - 1);
        System.out.println("Get a number: " + numbers.get(random.nextInt(size - 1)));
        System.out.println("Get a number: " + numbers.get(random.nextInt(size - 1)));

        long end = System.currentTimeMillis();
        System.out.println("Time taken with List option: " + (end - start) + "ms");
    }
}
