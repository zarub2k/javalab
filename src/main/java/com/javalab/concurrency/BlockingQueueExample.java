package com.javalab.concurrency;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author tham
 */
public class BlockingQueueExample {

    public void doLinkedBlockingQueue() {
        LinkedBlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(12);
        for (int i = 0; i < 10; i++) {
            try {
                blockingQueue.put("#" + i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            blockingQueue.put("Static");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(blockingQueue);
    }

    public static void main(String[] args) {
        BlockingQueueExample queueExample = new BlockingQueueExample();
        queueExample.doLinkedBlockingQueue();
    }
}
