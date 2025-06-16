package com.javalab.grounded;

/**
 *
 * @author Tham
 */
public class SimpleThreadExample {

    public static void main(String[] args) {
        Runnable job = () -> {
            System.out.println("New job is created");  
        };
        
        Thread thread = new Thread(job);
        System.out.println("Thread state:" + thread.getState());
        
        thread.start();
        System.out.println("Thread Now state:" + thread.getState());
        
        try {
            Thread.sleep(1000); 
            System.out.println("Thread inter state:" + thread.getState());
        }catch (Exception ex) {
           ex.printStackTrace();
        }
        System.out.println("Thread final state:" + thread.getState());
    }
}
