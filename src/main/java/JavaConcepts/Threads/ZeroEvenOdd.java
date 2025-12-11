package JavaConcepts.Threads;

import java.util.function.IntConsumer;

//https://leetcode.com/problems/print-zero-even-odd/
//Input: n = 5
//Output: "0102030405"
//Input: n = 2
//Output: "0102"
class ZeroEvenOdd {  //Concurrency
    private final int n = 5;

    private int turn = 0; // 0 = zero, 1 = odd, 2 = even

    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i ++) {
            while (turn != 0) {
                wait();  // Block the thread until it is its turn, after notifyAll() all threads will recheck while (turn != expected) to see if it’s their turn now.
            }

            printNumber.accept(0);

            // Switch to next turn
            if (i % 2 == 0) {
                turn = 2; // even
            } else {
                turn = 1; // odd
            }

            notifyAll(); // wake up odd/even threads
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            while (turn != 1) {
                wait();
            }

            printNumber.accept(i);
            turn = 0; // back to zero

            notifyAll();  // wake up zero/even threads
        }
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            while (turn != 2) {
                wait();
            }

            printNumber.accept(i);
            turn = 0; // back to zero

            notifyAll(); // wake up zero/odd threads
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd obj = new ZeroEvenOdd();
        IntConsumer printNumber = System.out::print;  //assigning a method reference to a functional interface that takes an int as input and performs an action — specifically, printing it.

        Thread t0 = new Thread(() -> {
            try {
                obj.zero(printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread t1 = new Thread(() -> {
            try {
                obj.odd(printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                obj.even(printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        t0.start();
        t1.start();
        t2.start();
    }
}