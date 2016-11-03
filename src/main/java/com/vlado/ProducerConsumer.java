package com.vlado;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by vdimitrov on 10/1/16.
 */
public class ProducerConsumer {


    public static void main(String[] args) {
        new ProducerConsumer().start();
    }

    public void start() {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);

        new Thread(new Consumer(queue)).start();
//        new Thread(new Consumer(queue)).start();
        new Thread(new Producer(queue)).start();
    }


    public class Consumer implements Runnable {

        private final BlockingQueue queue;

        public Consumer(BlockingQueue queue) {
            this.queue = queue;
        }

        public void run() {
            Random random = new Random();
            while (true) {
                try {
                    Thread.sleep(random.nextInt(500));
                    queue.take();
                    System.out.println("Consuming.. Queue size: " + queue.size());
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public class Producer implements Runnable {

        private final BlockingQueue queue;

        public Producer(BlockingQueue queue) {
            this.queue = queue;
        }

        public void run() {
            Random random = new Random();
            while (true) {
                try {
                    Thread.sleep(random.nextInt(200));
//                    queue.offer("work");
                    queue.put("work");
                    System.out.println("Producing.. Queue size: " + queue.size());
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
