package DSA;
//QueueImpl is a linear data structure that follows a particular order in which the operations
// are performed for storing data. The order is First In First Out (FIFO)

public class QueueImpl {    //Impl queue using array
    int[] arr;
    int size;
    int rear;

    QueueImpl(int size) {
        this.size = size;
        arr = new int[size];
        rear = -1;
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public boolean isFull() {
        return rear == size - 1;
    }

    public void add(int data) {  //enqueue
        if (isFull()) {
            System.out.println("Overflow");
        }
        arr[++rear] = data;
    }

    public int remove() {    //dequeue
        if (isEmpty()) {
            System.out.println("empty queue");
            return -1;
        }
        int front = arr[0];
        for (int i = 0; i < rear; i++) { //we shifted remaining elements to front as its an array
            arr[i] = arr[i + 1];
        }
        rear--; //we need to shift rear aswell
        return front;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("empty queue");
            return -1;
        }
        return arr[0];
    }

    private int queueSize() {
        return rear + 1;
    }

    void print() {
        System.out.print("Elements present in stack : ");
        for (int i = 0; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        QueueImpl q = new QueueImpl(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.print();
        System.out.println("size: " + q.queueSize());
        System.out.println("Removed : " + q.remove());
        System.out.println(q.peek());
        System.out.println("Is queue empty : " + q.isEmpty());
    }
}
