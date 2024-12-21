package com.javalab.concurrency.thread;

/**
 * @author Tham
 */
public class NormalThread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        Thread runnableThread = new Thread(new MyRunnable());
        runnableThread.start();
    }
}

class MyThread extends Thread {
    public void run() {
        System.out.println("MyThread called");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("MyRunnable called");
    }
}
