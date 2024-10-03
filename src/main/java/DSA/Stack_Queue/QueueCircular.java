package DSA.Stack_Queue;

//circular queue using array
public class QueueCircular {
    int[] arr;
    int size;
    int capacity;
    int front;
    int rear;

    QueueCircular(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {    // Get the size of the queue
        return size;
    }

    // Add an element to the rear of the queue
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Unable to enqueue.");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        size++;
    }

    // Remove and return the element from the front of the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Unable to dequeue.");
            return -1; // Returning -1 indicating an error condition. Modify as needed.
        }
        int item = arr[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    // Get the element at the front of the queue without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return arr[front];
    }

    public static void main(String[] args) {
        QueueCircular q = new QueueCircular(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        System.out.println("Removed : " + q.dequeue());
        q.enqueue(6);
        System.out.println("Removed : " + q.dequeue());
        q.enqueue(7);

        while (!q.isEmpty()) {
            System.out.println("Remove all : " + q.dequeue());
        }

        System.out.println("Is queue empty : " + q.isEmpty());
    }
}

