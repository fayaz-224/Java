package DSA.LL;
//Apna college
//A linear data structure used to store the elements in contiguous locations is called a Linked List in Java.
// It has addresses and pointers that are used to link the elements, and each element in the linked list consists of two parts, namely the data part and the address part.
// The data part is the value of the element, and the address part consists of the pointers and addresses that are used to link the elements.
// Each element in the list is called a node.

public class LinkedListImpl {   //singly linked-list
    Node head;
    private int size = 0;

    public class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    public void addFirst(String data) {
        Node newNode = new Node(data); //size will increment here only
        newNode.next = head;
        head = newNode;
    }

    public void addLast(String data) {  //main
        Node newNode = new Node(data);
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

    public void addInMiddle(int index, String data) {
        if (index > size || index < 0) {
            System.out.println("Invalid Index Value");
            return;
        }

        Node newNode = new Node(data);
        if (head == null || index == 0) {
            newNode.next = head;    //addFirst(data);
            head = newNode;
            return;
        }

        Node currNode = head;
        for (int i = 1; i < index; i++) {  //will go that middle pos
            currNode = currNode.next;
        }
        newNode.next = currNode.next;
        currNode.next = newNode;
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
            size = 0;
            return;
        }

        Node secondLast = head;
        while (secondLast.next.next != null) {
            secondLast = secondLast.next;
        }
        secondLast.next = null;
        size--;
    }

    public Node DeleteNthNodeFromEnd(Node head, int N) {
        if (head == null) {
            return null;
        }
        int cnt = 0;
        Node temp = head;

        // Count the number of nodes in the linked list
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        // If N equals the total number of nodes, delete the head
        if (cnt == N) {
            Node newhead = head.next;
            head = null;
            return newhead;
        }

        // Calculate the position of the node to delete (res)
        int res = cnt - N;
        temp = head;

        // Traverse to the node just before the one to delete
        while (temp != null) {
            res--;
            if (res == 0) {
                break;
            }
            temp = temp.next;
        }

        // Delete the Nth node from the end
        Node delNode = temp.next;
        temp.next = temp.next.next;
        delNode = null;
        return head;
    }

    //https://www.youtube.com/watch?v=t7YaoQOFXzk&list=PLfqMhTWNBTe3LtFWcvwpqTkUSlB32kJop&index=28
    public void reverseList() {  //without extraMemory
        if (head == null || head.next == null) {
            return;
        }

        Node prevNode = head;
        Node currNode = head.next;
        while (currNode != null) {
            Node nextNodes = currNode.next;
            currNode.next = prevNode;

            prevNode = currNode;
            currNode = nextNodes;
        }
        head.next = null;
        head = prevNode;
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
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListImpl list = new LinkedListImpl();
        list.addLast("is");
        list.addLast("a");
        list.addLast("list");
        list.printList();

        list.addFirst("this");
        list.printList();
        System.out.println("Size of LL: " + list.getSize());
        System.out.println("Mid val of LL: " + list.getMiddle(list.head));

        list.removeFirst();
        list.printList();
        list.removeLast();
        list.printList();
        System.out.println("Size of LL: " + list.getSize());

        list.addInMiddle(2, "only");
        list.printList();

        list.reverseList();
        System.out.println("Reversing LL: ");
        list.printList();

        list.DeleteNthNodeFromEnd(list.head, 2);
        System.out.println("After deleting nth node from right: ");
        list.printList();
    }
}