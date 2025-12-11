package JavaConcepts.Threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// BlockingQueue is thread-safe.
// I.e, multiple threads can add and remove messages from this queue without any concurrency issues.
// All synchronization (waiting/blocking) is handled internally by the BlockingQueue. No manual handling of synchronized, wait() and notifyAll()
// This will solve ProducerConsumerProblem
public class ProducerConsumerProblem {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        // Producer
        Runnable producerObj = () -> {
            for (int i = 0; i < 20; i++) {
                try {
                    queue.put(i);    // waits when full
                    System.out.println(Thread.currentThread().getName() +
                            " produced " + i);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // Consumer
        Runnable consumerObj = () -> {
            try {
                while (true) {
                    Integer value = queue.take();   // waits when empty
                    System.out.println(Thread.currentThread().getName() +
                            " consumed " + value);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Thread producerThread = new Thread(producerObj, "Producer Thread");
        Thread consumerThread = new Thread(consumerObj, "Consumer Thread");

        producerThread.start();
        consumerThread.start();
    }
}