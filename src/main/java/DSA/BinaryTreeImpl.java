package DSA;

import java.util.LinkedList;
import java.util.Queue;

//for BinaryTree nodes are not ordered, for BST nodes are ordered as
// nodes that are left of root are smaller, nodes in right are higher than root.

public class BinaryTreeImpl {// Build Tree from given Preorder Sequence / traversal

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree {
        int idx = -1;

        public Node buildTree(int[] nodes) { //forms the tree from given sequence
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    //Preorder
    public static void preorder(Node root) {
        if (root == null) {
            System.out.print(-1 + " ");
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    //Inorder
    public static void inorder(Node root) {
        if (root == null) {
            System.out.print(-1 + " ");
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    //Postorder
    public static void postorder(Node root) {
        if (root == null) {
            System.out.print(-1 + " ");
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    //LevelOrder
    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                System.out.println();
                //queue empty
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(curr.data + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }

    //Height of Tree
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    //Count of Nodes of Tree
    public static int countOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);
        return leftNodes + rightNodes + 1;
    }

    //Sum of Nodes of Tree
    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        return leftSum + rightSum + root.data;
    }

    //Diameter of Tree -> no. of nodes in the longest path btw any 2 nodes
    public static int diameter(Node root) { // O(N^2)
        if (root == null) {
            return 0;
        }
        int diam1 = height(root.left) + height(root.right) + 1;
        int diam2 = diameter(root.left);
        int diam3 = diameter(root.right);

        return Math.max(diam1, Math.max(diam2, diam3));
    }

    //Subtree of another tree
    public static boolean isSubtree(Node root, Node subRoot) {
        if (subRoot == null)
            return true;
        if (root == null)
            return false;

        if (isIdentical(root, subRoot))
            return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean isIdentical(Node root, Node subRoot) {
        if (subRoot == null && root == null)
            return true;
        if (root == null || subRoot == null)
            return false;

        if (root.data == subRoot.data)
            return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);

        return false;
    }


    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("Root: " + root.data);

        preorder(root);
        //inorder(root);

        System.out.println("Count of Nodes: " + countOfNodes(root));
        System.out.println("Height: " + height(root));
        System.out.println("Sum of Nodes: " + sumOfNodes(root));
        System.out.println("Diameter of Tree: " + diameter(root));

//        int[] newNode = {1, 2, -1, -1, 4};
//        BinaryTree tree2 = new BinaryTree();
//        Node root2 = tree2.buildTree(newNode);
        System.out.println("is Subtree: " + isSubtree(root, root));
    }
}

