package DSA.Stack_Queue;

public class StackWithLL {   //LIFO
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private Node head = null; // top
    private int size = 0; // track stack size

    boolean isEmpty() {
        return head == null;
    }

    void push(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.next = head; //LIFO - so new nodes will be added to beginning of stack ie; top
            head = newNode;  //make newNode the new head (new top of stack).
        }
        size++;
    }

    int pop() {
        if(isEmpty()) {
            return -1;
        }
        int top = head.data;
        head = head.next;  //Move head to the next node (i.e., remove the top).
        size--;
        return top;
    }

    int peek() {
        if(isEmpty()) {
            return -1;
        }
        return head.data;
    }

    int size() {
        return size;
    }

    void display() {
        Node current = head;
        System.out.print("Stack (top to bottom): ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        StackWithLL stack = new StackWithLL();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.display();

        System.out.println("peek: "+stack.peek());
        System.out.println("pop: "+stack.pop());

        System.out.println("isEmpty: "+stack.isEmpty());
        System.out.println("size: "+stack.size());
        stack.display();
    }
}
