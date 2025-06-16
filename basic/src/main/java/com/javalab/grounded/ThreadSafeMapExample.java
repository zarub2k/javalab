package com.javalab.grounded;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Tham
 */
public class ThreadSafeMapExample {
    int SIZE = 1000;
    int THREAD_COUNT = 2;
    
    public static void main(String[] args) {
        ThreadSafeMapExample threadSafeMapExample = new ThreadSafeMapExample();
        threadSafeMapExample.doNoThreadSafe();
        threadSafeMapExample.doThreadSafe();
    }
    
    private void doNoThreadSafe() {
        Map<String, String> map = new HashMap();
        Thread thread1 = new Thread(runnable("r1", map));
        Thread thread2 = new Thread(runnable("r2", map));
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        System.out.println(map);
        System.out.println("Non Safe Map Count: " + map.size());
        System.out.println("Data loss: " + loss(THREAD_COUNT, SIZE, map.size()));
        System.out.println("\n");
    }
    
    private void doThreadSafe() {
        ConcurrentHashMap<String, String> safeMap = new ConcurrentHashMap();
        Thread thread1 = new Thread(runnable("r1", safeMap));
        Thread thread2 = new Thread(runnable("r2", safeMap));
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        System.out.println(safeMap);
        System.out.println("Safe Map Count: " + safeMap.size());
        System.out.println("Data loss: " + loss(THREAD_COUNT, SIZE, safeMap.size()));
    }
    
    private Runnable runnable(String name, Map<String, String> map) {
       return () -> {
           for (int i = 0; i < SIZE; i++) {
               map.put(name + i, "0");
           }
       };
    }
    
    private int loss(int threadCount, int expected, int actual) {
        return threadCount * expected - actual;
    }
    
//    private void doExecute(int threadCount, Map<String, String> map) {
//        Thread[] threads = new Thread[threadCount];
//        for (int i = 0; i < threadCount; i++) {
//            threads[i] = new Thread(runnable("r" + i, map));
//        }
//        
//        for (Thread thread: threads) {
//            thread.start();
//        }
//        
//        try {
//            for (Thread thread: threads) {
//                thread.join();
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
}
