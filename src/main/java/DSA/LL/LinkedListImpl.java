package DSA.LL;

//Apna college
//A linear data structure used to store the elements in contiguous locations is called a Linked List in Java.
// It has addresses and pointers that are used to link the elements, and each element in the linked list consists of two parts, namely the data part and the address part.
// The data part is the value of the element, and the address part consists of the pointers and addresses that are used to link the elements.
// Each element in the list is called a node.

public class LinkedListImpl {   //singly linked-list
    private class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    private int size = 0;  //count of nodes

    public void addFirst(String data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(String data) {  //main insert
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = newNode;
            return;
        }

        Node lastNode = head;
        while (lastNode.next != null) { //go to last node ie, before null
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }

    public void addAtGivenIndex(int index, String data) {
        if (index > size || index < 0) {
            System.out.println("Invalid Index Value");
            return;
        }

        Node newNode = new Node(data);
        size++;
        if (index == 0) {
            newNode.next = head;    //addFirst(data);
            head = newNode;
            return;
        }

        Node currNode = head;
        for (int i = 0; i < index-1; i++) {  //will go that index pos
            currNode = currNode.next;
        }
        newNode.next = currNode.next;
        currNode.next = newNode;
    }

    String getFirst() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        return head.data;
    }

    String getLast() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        return temp.data;
    }

    public String getMiddle(Node head) {  //2 pointer Technique
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("Empty List, nothing to delete");
            return;
        }

        head = head.next;
        size--;
    }

    public void removeLast() {
        if (head == null) return;
        if (head.next == null) {  //if we have only one Node
            head = null;
            size--;
            return;
        }

        Node secondLast = head;
        while (secondLast.next.next != null) {
            secondLast = secondLast.next;
        }
        secondLast.next = null;
        size--;
    }

    Node deleteNthNodeFromEnd(Node head, int N) {
        if (head == null || N <= 0) {
            return null;
        }

        // Count the number of nodes in the linked list
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // If N is greater than length, do nothing
        if (N > count) return null;

        // If N equals the total number of nodes, delete the head
        if (count == N) {
            Node newhead = head.next;
            head = null;
            return newhead;
        }

        // Traverse to the node just before the one to delete
        temp = head;
        for (int i = 1; i < count - N; i++) {  //count - N gives the index to delete
            temp = temp.next;
        }

        // Delete the Nth node from the end
        Node delNode = temp.next;
        temp.next = temp.next.next;
        delNode = null;  //for GC

        return head;
    }

    boolean search(String data) {
        Node current = head;
        while (current != null) {
            if (current.data == data)
                return true;
            current = current.next;
        }
        return false;
    }

    //https://www.youtube.com/watch?v=t7YaoQOFXzk&list=PLfqMhTWNBTe3LtFWcvwpqTkUSlB32kJop&index=28
    public void reverseList() {  //without extraMemory
        if (head == null || head.next == null) {
            return;
        }

        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;  // Store next nodes
            curr.next = prev;  // Reverse link
            prev = curr;   // Move prev forward
            curr = next;   // Move current forward
        }
        head = prev;  // Update head to new front
    }

    public int getSize() {
        return size;
    }

    public void printList() {
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedListImpl list = new LinkedListImpl();
        list.addLast("is");
        list.addLast("a");
        list.addLast("list");
        list.addFirst("this");
        list.printList();

        System.out.println("Size of LL: " + list.getSize());
        System.out.println("first val: "+list.getFirst());
        System.out.println("Mid val: " + list.getMiddle(list.head));

        list.removeFirst();
        list.removeLast();
        list.printList();

        list.addAtGivenIndex(1, "only");
        list.printList();

        list.reverseList();
        System.out.println("Reversing LL: ");
        list.printList();

        list.deleteNthNodeFromEnd(list.head, 2);
        System.out.println("After deleting nth node from right: ");
        list.printList();
    }
}