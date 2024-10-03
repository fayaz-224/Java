package DSA.LL;

import java.util.HashMap;

//Given a doubly linked list where each node contains two pointers:
//next pointer pointing to the next node in the list, and
//random pointer pointing to any arbitrary node in the list, or null.
//Write a function to clone the given doubly linked list. The new list should have the same structure and random node pointers as the original one, but with new node instances.
//https://leetcode.com/problems/copy-list-with-random-pointer/description/
public class CopyRandomLL {

    public static RandomNode copyRandomList(RandomNode head) {
        if (head == null) return null;

        HashMap<RandomNode, RandomNode> oldToNew = new HashMap<>();

        RandomNode curr = head;
        while (curr != null) {
            oldToNew.put(curr, new RandomNode(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            RandomNode newNode = oldToNew.get(curr);
            newNode.next = oldToNew.get(curr.next);
            newNode.random = oldToNew.get(curr.random);
            curr = curr.next;
        }

        return oldToNew.get(head);
    }

    static void printList(RandomNode head) {
        while (head != null) {
            System.out.print(head.val + "(");
            if (head.random != null)
                System.out.print(head.random.val + ") -> ");
            else
                System.out.print("null" + ") -> ");

            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args){
        // Creating a linked list with random pointer
        RandomNode head = new RandomNode(1);
        head.next = new RandomNode(2);
        head.next.next = new RandomNode(3);
        head.next.next.next = new RandomNode(4);
        head.next.next.next.next = new RandomNode(5);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head.next;

        System.out.println("Original linked list:");
        printList(head);

        RandomNode clonedList = copyRandomList(head);

        System.out.println("Cloned linked list:");
        printList(clonedList);
    }
}

class RandomNode {
    int val;
    RandomNode next;
    RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}