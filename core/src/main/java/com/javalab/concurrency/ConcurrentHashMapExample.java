package com.javalab.concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author tham
 */
public class ConcurrentHashMapExample {
    int size = 10;

    public void normal() {
        Map<String, String> map = new HashMap<>();
        Runnable r1 = () -> {
            for (int i = 0; i < size; i++) {
                map.put("t1" + i, "0");
            }

            System.out.println("Thread #1 is done");
        };

        Runnable r2 = () -> {
            for (int i = 0; i < size; i++) {
                map.put("t2" + i, "0");
            }

            System.out.println("Thread #2 is done");
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Map: " + map);
    }

    public void concurrent() {
        Map<String, String> map = new ConcurrentHashMap<>();
        Runnable r1 = () -> {
            for (int i = 0; i < size; i++) {
                map.put("t1" + i, "0");
            }

            System.out.println("Thread #1 is done");
        };

        Runnable r2 = () -> {
            for (int i = 0; i < size; i++) {
                map.put("t2" + i, "0");
            }

            System.out.println("Thread #2 is done");
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Map: " + map);
    }

    public static void main(String[] args) {
        System.out.println("Concurrent hashmap example");

        ConcurrentHashMapExample mapExample = new ConcurrentHashMapExample();
        mapExample.normal();
//        mapExample.concurrent();
    }
}
