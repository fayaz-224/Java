package DSA.LL;

//Add 2 LL where each linked list represents a non-negative integer, digits stored in reverse order.
//Input: l1 = [2,4,3] represents 342
//       l2 = [5,6,4] represents 465
//Output: [7,0,8] represents 807 (342+465)
//https://leetcode.com/problems/add-two-numbers/
public class Add2Nums {

    static Node addTwoNumbers(Node l1, Node l2) {
        Node dummyHead = new Node(0);
        Node current = dummyHead;  //both dummyHead and current pointers are pointing to same node (dummyHead -> stays at head, current -> builds LL)
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

        if (carry > 0) {  //this if is not needed if we have carry != 0 check in the while loop as extra or condition
            current.next = new Node(carry);
        }

        return dummyHead.next;  //return only actual data ignoring dummy [0] node
    }

    // Helper method to create a linked list from array
//    public static Node createList(int[] arr) {
//        Node dummy = new Node(0);
//        Node curr = dummy;
//        for (int num : arr) {
//            curr.next = new Node(num);
//            curr = curr.next;
//        }
//        return dummy.next;
//    }

    public static void main(String[] args) {
        //Node l1 = createList(new int[]{2, 4, 3});     //to create LL in separate method
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);

        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);

        Node result = addTwoNumbers(l1, l2);

        //print result LL
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}
