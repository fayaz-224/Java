package DSA;

public class StackWithLL {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private Node head = null;

    public void push(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }
        newNode.next = head; //imp - as it's a stack FIFO (new nodes will be added to beginning of stack)
        head = newNode;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int pop() {
        if(isEmpty()) {
            return -1;
        }
        int top = head.data;
        head = head.next;
        return top;
    }

    public int peek() {
        if(isEmpty()) {
            return -1;
        }
        return head.data;
    }

    public static void main(String args[]) {
        StackWithLL stack = new StackWithLL();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("peek element in stack: "+stack.peek());
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println("isEmpty: "+stack.isEmpty());
    }
}
