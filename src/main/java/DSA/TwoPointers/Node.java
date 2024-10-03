package DSA.TwoPointers;

public class Node {
    int data;
    Node next;

    // Constructor to create a node with a specific value
    Node(int val) {
        this.data = val;
        this.next = null; // It's generally a good practice to explicitly set `next` to null.
    }

    // Constructor to create a node with a value and next node reference
    Node(int val, Node next) {
        this.data = val;
        this.next = next;
    }
}
