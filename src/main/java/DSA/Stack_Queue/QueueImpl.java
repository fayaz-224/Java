package DSA.Stack_Queue;

//QueueImpl is a linear data structure, in which elements are added at the rear end and removed from the front end,
// following the First-In-First-Out (FIFO) principle.
//enqueue, dequeue, peek -> These are generic terms used in data structures.
//add, remove, element etc -> java specific methods.

public class QueueImpl {    //Impl queue using array
    private final int MAX;
    private int[] arr;
    private int front;
    private int rear;
    private int size;

    QueueImpl(int capacity) {
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

    int size() {
        return size;
    }

    void add(int item) { //enqueue
        if (isFull()) {
            System.out.println("Queue is full. Unable to enqueue.");
            return;
        }
        arr[++rear] = item;
        size++;
    }

    int remove() { //dequeue
        if (isEmpty()) {
            System.out.println("Queue is empty. Unable to dequeue.");
            return -1; // Returning -1 indicating an error condition. Modify as needed.
        }
        int item = arr[front];
        front++;
        size--;
        return item;
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return arr[front];
    }

    void display() {
        if (isEmpty()) {  //nothing to print
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Elements present in stack : ");
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueImpl q = new QueueImpl(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.display();

        System.out.println("size: " + q.size());
        System.out.println("Removed : " + q.remove());
        System.out.println(q.peek());
        System.out.println("Is queue empty : " + q.isEmpty());
        q.display();
    }
}
