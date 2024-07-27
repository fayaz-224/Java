package DSA;
//QueueImpl is a linear data structure, in which elements are added at the rear end and removed from the front end,
// following the First-In-First-Out (FIFO) principle.

public class QueueImpl {    //Impl queue using array
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    public QueueImpl(int capacity) {
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

    public int size() {
        return size;
    }

    public void add(int item) { //enqueue
        if (isFull()) {
            System.out.println("Queue is full. Unable to enqueue.");
            return;
        }
        arr[++rear] = item;
        size++;
        System.out.println("Enqueued " + item + " to the queue.");
    }

    public int remove() { //dequeue
        if (isEmpty()) {
            System.out.println("Queue is empty. Unable to dequeue.");
            return -1; // Returning -1 indicating an error condition. Modify as needed.
        }
        int item = arr[front];
        front++;
        size--;
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return arr[front];
    }

    void print() {
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
        q.print();
        System.out.println("size: " + q.size());
        System.out.println("Removed : " + q.remove());
        System.out.println(q.peek());
        System.out.println("Is queue empty : " + q.isEmpty());
        q.print();
    }
}
