package DSA;
//QueueImpl is a linear data structure that follows a particular order in which the operations
// are performed for storing data. The order is First In First Out (FIFO)

public class QueueImpl {    //queue using array
    static int[] arr;
    static int size;
    static int rear;

    QueueImpl(int size) {
        QueueImpl.size = size;
        arr = new int[size];
        rear = -1;
    }

    public static boolean isEmpty() {
        return rear == -1;
    }

    public static boolean isFull() {
        return rear == size - 1;
    }

    public static void add(int data) {  //enqueue
        if (isFull()) {
            System.out.println("Overflow");
        }
        arr[++rear] = data;
    }

    public static int remove() {    //dequeue
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

    public static int peek() {
        if (isEmpty()) {
            System.out.println("empty queue");
            return -1;
        }
        return arr[0];
    }

    public static void main(String[] args) {
        QueueImpl q = new QueueImpl(5);
        add(1);
        add(2);
        add(3);
        System.out.println("Removed : " + remove());
        System.out.println(peek());
        System.out.println("Is queue empty : " + isEmpty());
    }
}
