package Threads;

import java.util.function.IntConsumer;

//https://leetcode.com/problems/print-zero-even-odd/
class ZeroEvenOdd {  //Concurrency
    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    private boolean zeroPrinted = false;
    private boolean evenPrinted = false;
    private boolean oddPrinted = false;

    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i ++) {
            if (zeroPrinted) {  // wait while zero is already printed
                wait();
            }
            printNumber.accept(0);
            zeroPrinted = true;

            if (i % 2 == 0) {
                evenPrinted = false;
                oddPrinted = true;   // Allow odd to print next
            } else {
                evenPrinted = true;  // Allow even to print next
                oddPrinted = false;
            }

            notifyAll();
        }
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            while (evenPrinted) {
                wait();
            }
            printNumber.accept(i);
            evenPrinted = true;
            zeroPrinted = false;
            notifyAll();
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            while (oddPrinted) {
                wait();
            }
            printNumber.accept(i);
            oddPrinted = true;
            zeroPrinted = false;
            notifyAll();
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        IntConsumer printNumber = System.out::println;

        Thread zeroThread = new Thread(() -> {
            try {
                zeroEvenOdd.zero(printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread oddThread = new Thread(() -> {
            try {
                zeroEvenOdd.odd(printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread evenThread = new Thread(() -> {
            try {
                zeroEvenOdd.even(printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        zeroThread.start();
        oddThread.start();
        evenThread.start();
    }
}