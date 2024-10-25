package Threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// BlockingQueue is thread-safe.
// I.e, multiple threads can add and remove messages from this queue without any concurrency issues.
// This will solve ProducerConsumerProblem
class Producer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {  //produce
        try {
            while (true) {
                Integer item = (int) (Math.random() * 100);
                queue.put(item); // Blocks if the queue is full
                System.out.println("Produced: " + item);
                System.out.println("Queue: " + queue);
                Thread.sleep(500); // Simulating delay in producing
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {  //consume
        try {
            while (true) {
                Integer item = queue.take(); // Blocks if the queue is empty
                System.out.println("Consumed: " + item);
                Thread.sleep(1000); // Simulating delay in consuming
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ProducerConsumerProblem {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        Thread producerThread = new Thread(new Producer(queue), "Producer Thread");
        Thread consumerThread = new Thread(new Consumer(queue), "Consumer Thread");

        producerThread.start();
        consumerThread.start();

    }


}