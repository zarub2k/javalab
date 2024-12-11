package com.javalab.functional;

/**
 * @author tham
 */
public class SimpleLambda {
    public static void main(String[] args) {
        new SimpleLambda().doLambda();
    }

    private void doLambda() {
        Runnable r = () -> System.out.println("Simple runnable"); //Lambda expression
        Thread thread = new Thread(r);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
