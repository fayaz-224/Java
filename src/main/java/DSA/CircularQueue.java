package DSA;

//circular queue using array
public class CircularQueue {
    static int[] arr;
    static int size;
    static int front = -1;
    static int rear = -1;

    CircularQueue(int size) {
        CircularQueue.size = size;
        arr = new int[size];
    }

    public static boolean isEmpty() {
        return rear == -1 && front == -1;
    }

    public static boolean isFull() {
        return (rear + 1) % size == front;
    }

    public static void add(int data) {
        if (isFull()) {
            System.out.println("Overflow");
            return;
        }
        //if it's the 1st element
        if (front == -1) {
            front = 0;
        }

        rear = (rear + 1) % size; //as its circular queue, we need to fill empty places in array beginning
        arr[rear] = data;
    }

    public static int remove() {
        if (isEmpty()) {
            System.out.println("empty queue");
            return -1;
        }
        int res = arr[front];

        //if only 1 element is present
        if (front == rear)
            front = rear = -1;
        else
            front = (front + 1) % size;

        return res;
    }

    public static int peek() {
        if (isEmpty()) {
            System.out.println("empty queue");
            return -1;
        }
        return arr[front];
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);
        add(1);
        add(2);
        add(3);
        add(4);
        add(5);
        System.out.println("Removed : " + remove());
        add(6);
        System.out.println("Removed : " + remove());
        add(7);

        while (!isEmpty()) {
            System.out.println("Remove all : " + remove());
        }

        System.out.println("Is queue empty : " + isEmpty());
    }
}

