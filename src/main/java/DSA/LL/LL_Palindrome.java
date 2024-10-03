package DSA.LL;

import java.util.Stack;

public class LL_Palindrome {

    static boolean isPalindrome(Node head) {
        Node temp = head;
        boolean isPalin = false;

        Stack<Integer> stack = new Stack<>();  //insert in stack
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }

        while (head != null) {
            int i = stack.pop();

            if (head.data == i)
                isPalin = true;
            else
                break;  //not a palindrome

            head = head.next;
        }
        return isPalin;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(5);
        head.next.next = new Node(2);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(1);

        if (isPalindrome(head)) {
            System.out.println("LL is a palindrome.");
        } else {
            System.out.println("LL is not a palindrome.");
        }
    }
}
