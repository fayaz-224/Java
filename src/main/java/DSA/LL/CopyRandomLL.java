package DSA.LL;

import java.util.HashMap;

//Given a singly linked list where each node contains two pointers:
//next pointer pointing to the next node in the list, and
//random pointer pointing to any arbitrary node in the list, or null.
//Write a function to clone the given linked list. The new list should have the same structure and random node pointers as the original one, but with new node instances.
//https://leetcode.com/problems/copy-list-with-random-pointer/description/
public class CopyRandomLL {

    static RandomNode copyRandomList(RandomNode head) {
        if (head == null) return null;

        HashMap<RandomNode, RandomNode> newLL = new HashMap<>();

        //Copy all nodes into a HashMap
        RandomNode curr = head;
        while (curr != null) {
            newLL.put(curr, new RandomNode(curr.val));
            curr = curr.next;
        }

        //Set next and random for the new nodes
        curr = head;
        while (curr != null) {
            RandomNode newNode = newLL.get(curr);
            newNode.next = newLL.get(curr.next);
            newNode.random = newLL.get(curr.random);
            curr = curr.next;
        }

        return newLL.get(head);  //Return the new head
    }

    static void printList(RandomNode head) {
        while (head != null) {
            System.out.print(head.val + "(");
            System.out.print(head.random != null ? head.random.val : "null");
            System.out.print(") -> ");

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

        head.random = head.next.next; //1 -> 3
        head.next.random = head;  //2 -> 1
        head.next.next.next.random = head.next.next; //4 -> 3

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
        this.next = this.random = null;
    }
}

/*
//without using extra space SC: O(1)
static RandomNode copyRandomList(RandomNode head) {
        if (head == null) return null;

        // Step 1: Insert cloned nodes
        RandomNode curr = head;
        while (curr != null) {
            RandomNode clone = new RandomNode(curr.val);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }

        // Step 2: Set random pointers for cloned nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the two lists
        curr = head;
        RandomNode cloneHead = head.next;
        while (curr != null) {
            RandomNode clone = curr.next;
            curr.next = clone.next;
            if (clone.next != null) {
                clone.next = clone.next.next;
            }
            curr = curr.next;
        }

        return cloneHead;
    }
 */