package DSA.LL;

import java.util.Stack;

public class LL_Palindrome {

    static boolean isPalindrome(Node head) {  //SC: O(n)
        if (head == null || head.next == null) return true;

        Stack<Integer> stack = new Stack<>();

        Node temp = head;
        while (temp != null) { //push all elements to stack
            stack.push(temp.data);
            temp = temp.next;
        }

        //Compare each node with stack top
        while (head != null) {
            if (head.data != stack.pop())
                return false;

            head = head.next;
        }
        return true;
    }

    static boolean isPalindrome2(Node head) {  //SC: O(1)
        if (head == null || head.next == null) return true;

        // Step 1: Find middle
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        Node secondHalfStart = reverse(slow);

        // Step 3: Compare both halves
        Node firstHalf = head;
        Node secondHalf = secondHalfStart;
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // (Optional) Restore original list
        reverse(secondHalfStart);

        return true;
    }

    static Node reverse(Node head) {
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


    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(5);
        head.next.next = new Node(2);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(1);

        if (isPalindrome2(head)) {
            System.out.println("LL is a palindrome.");
        } else {
            System.out.println("LL is not a palindrome.");
        }
    }
}
