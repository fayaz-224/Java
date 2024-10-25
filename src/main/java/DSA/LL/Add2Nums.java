package DSA.LL;

//https://leetcode.com/problems/add-two-numbers/
public class Add2Nums {

    static Node addTwoNumbers(Node l1, Node l2) {
        Node dummyHead = new Node(0);
        Node current = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.data : 0;
            int y = (l2 != null) ? l2.data : 0;
            int sum = carry + x + y;

            current.next = new Node(sum % 10);
            current = current.next;
            carry = sum / 10;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            current.next = new Node(carry);
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);
            Node l2 = new Node(5);
            l2.next = new Node(6);
            l2.next.next = new Node(4);

        Node result = addTwoNumbers(l1, l2);

        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}


/*
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
 */