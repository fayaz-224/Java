package DSA.Stack_Queue;

public class QueueWithLL {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private Node head = null;  //front
    private Node tail = null;  //rear
    private int size = 0;

    boolean isEmpty() {
        return head == null && tail == null;
    }

    void add(int data) { //enQueue
        Node newNode = new Node(data);
        if (isEmpty()) {
            tail = head = newNode;
        } else {
            tail.next = newNode;  //FIFO, so new Nodes will be added to right ie; rear
            tail = newNode;
        }
        size++;
    }

    int remove() { //deQueue
        if (isEmpty()) {
            System.out.println("empty queue");
            return -1;
        }
        int front = head.data;
        head = head.next;
        if (head == null) { //single node - queue becomes empty
            tail = null;
        }

        size--;
        return front;
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("empty queue");
            return -1;
        }
        return head.data;
    }

    public int size() {
        return size;
    }

    void printList() {
        Node currNode = head;

        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueWithLL q = new QueueWithLL();
        System.out.println(q.isEmpty());
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.printList();

        q.remove();
        q.peek();
        q.printList();
        System.out.println("size: "+q.size());
    }
}