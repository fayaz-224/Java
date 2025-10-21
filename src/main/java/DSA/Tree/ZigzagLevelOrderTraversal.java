package DSA.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
//return the zigzag level order traversal of its nodes' values ie; from left to right, then right to left for the next level and alternate between.
public class ZigzagLevelOrderTraversal {

    public static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Deque<Node> q = new LinkedList<>();
        q.addFirst(root);
        boolean reverse = false;

        while (!q.isEmpty()) {
            List<Integer> current = new ArrayList<>();
            int level = q.size();

            for (int i = 0; i < level; i++) {
                if (!reverse) {
                    Node curr = q.pollFirst();
                    current.add(curr.data);
                    if (curr.left != null) q.addLast(curr.left);
                    if (curr.right != null) q.addLast(curr.right);
                } else {
                    Node curr = q.pollLast();
                    current.add(curr.data);
                    if (curr.right != null) q.addFirst(curr.right);
                    if (curr.left != null) q.addFirst(curr.left);
                }
            }

            res.add(current);
            reverse = !reverse;
        }

        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        root.right.right.left = new Node(10);
        root.right.right.right = new Node(12);

        System.out.println(zigzagLevelOrder(root));
    }
}
