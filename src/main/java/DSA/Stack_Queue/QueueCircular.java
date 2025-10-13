package DSA.Stack_Queue;

//circular queue using array
public class QueueCircular {
    int MAX;
    int[] arr;
    int front;
    int rear;
    int size;

    QueueCircular(int capacity) {
        this.MAX = capacity;
        this.arr = new int[MAX];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size == MAX;
    }

    int size() {    // Get the size of the queue
        return size;
    }

    // Add an element to the rear of the queue
    void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Unable to enqueue.");
            return;
        }
        rear = (rear + 1) % MAX;
        arr[rear] = item;
        size++;
    }

    // Remove and return the element from the front of the queue
    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Unable to dequeue.");
            return -1;
        }
        int item = arr[front];
        front = (front + 1) % MAX;
        size--;
        return item;
    }

    // Get the element at the front of the queue without removing it
    int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return arr[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueCircular q = new QueueCircular(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.display();

        System.out.println("Removed : " + q.dequeue());
        System.out.println("peek: "+q.peek());

        while (!q.isEmpty()) {
            System.out.println("Remove all : " + q.dequeue());
        }

        System.out.println("Is queue empty : " + q.isEmpty());
        q.display();
    }
}

