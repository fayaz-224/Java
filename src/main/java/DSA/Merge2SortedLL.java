package DSA;

public class Merge2SortedLL {

    public static Node mergeTwoLists(Node l1, Node l2) {
        Node dummy = new Node(0);  //a dummy first node to hang the results on.
        Node current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) {  //no need for while-loop, as we are appending remained LL at end
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Node l1 = new Node(1);  //sorted LL-1
        l1.next = new Node(3);
        l1.next.next = new Node(5);
        l1.next.next.next = new Node(10);

        Node l2 = new Node(2);  //sorted LL-2
        l2.next = new Node(4);
        l2.next.next = new Node(6);

        Node mergedList = mergeTwoLists(l1, l2);

        System.out.println("Merged List:");
        while (mergedList != null) {
            System.out.print(mergedList.val + "->");
            mergedList = mergedList.next;
        }
    }
}

