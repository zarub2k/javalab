package com.javalab.ds;

import java.util.PriorityQueue;

/**
 * @author Tham
 */
public class QueuePerformance {
    public static void main(String[] args) {
        QueuePerformance queuePerformance = new QueuePerformance();
        queuePerformance.doSimpleQueue(10);
    }

    private void doSimpleQueue(int size) {
        PriorityQueue<Object> queue = new PriorityQueue<>();
        for (int i = 0; i < size; i = i + 2) {
            queue.add(i);
        }

        System.out.println("before: " + queue);
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        queue.add(size);
        System.out.println("after: " + queue);
    }
}
