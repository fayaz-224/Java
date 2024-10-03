package DSA.Stack_Queue;

public class QueueWithLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    static Node head = null;
    static Node tail = null;

    public static boolean isEmpty() {
        return head == null && tail == null;
    }

    public static void add(int data) { //enQueue
        Node newNode = new Node(data);
        if (isEmpty()) {
            tail = head = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public static int remove() { //deQueue
        if (isEmpty()) {
            System.out.println("empty queue");
            return -1;
        }
        int front = head.data;
        //single node
        if (head == tail) {
            tail = null;
        }
        head = head.next;
        return front;
    }

    public static int peek() {
        if (isEmpty()) {
            System.out.println("empty queue");
            return -1;
        }
        return head.data;
    }

    public void printList() {
        Node currNode = head;

        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueWithLL q = new QueueWithLL();  //no need for size
        add(1);
        add(2);
        add(3);
        add(4);
        add(5);
        q.printList();

        remove();
        peek();
        q.printList();
    }
}