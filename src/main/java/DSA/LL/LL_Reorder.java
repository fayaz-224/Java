package DSA.LL;

//input: L0,L1,L2....Ln-1,Ln
//output: L0, Ln, L1, Ln-1, L2....
public class LL_Reorder {

    void reorder(Node head) {
        if (head == null || head.next == null) return;

        // Step 1. find middle and Split the list into two halves
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) { //Covers both even and odd sizes. 2 pointer way to find middle element
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2. Reverse the second half
        Node second = reverse(slow.next);
        slow.next = null;  // Cut first half to avoid cycles

        // Step 3. Merge the two halves
        //first: points to the head of the original first half
        //second: points to the head of the reversed second half
        Node first = head;
        while (second != null) {
            Node temp1 = first.next;
            Node temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }

    private Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    void printList(Node head) {
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        //initializing LL
        Node head = new Node(1, new Node(2, new Node(3, new Node(4))));

        LL_Reorder ll = new LL_Reorder();
        ll.reorder(head);

        System.out.println("Reordered LinkedList:");
        ll.printList(head);
    }
}
