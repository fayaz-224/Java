package DSA.LL;

public class LL_DetectLoop {
    static boolean detectLoop(Node head) {
        if (head == null) return false;

        // Fast and slow pointers initially points to the head - Floyd’s Tortoise and Hare approach
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If fast and slow pointer points to the same node, then the cycle is detected
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(4);

        head.next.next.next = head.next;

        if (detectLoop(head))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
