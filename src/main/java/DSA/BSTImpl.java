package DSA;

import java.util.ArrayList;

public class BSTImpl {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }

    //Inorder - for BST inorder will always gives sorted order of nodes
    public static void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    private static boolean searchNode(Node root, int key) {
        if (root == null)
            return false;

        if (root.data > key) //left subtree
            return searchNode(root.left, key);
        else if (root.data < key) //right subtree
            return searchNode(root.right, key);
        else
            return true;
    }

    private static Node deleteNode(Node root, int val) {
        if (root == null)
            return null;
        if (root.data > val)
            root.left = deleteNode(root.left, val);
        else if (root.data < val)
            root.right = deleteNode(root.right, val);
        else {
            //No child - delete node & return null to parent
            if (root.left == null && root.right == null)
                return null;
            //one child - delete node & replace with child node
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            //two childs - replace with inorder successor(left most from right subtree) & delete node
            Node IS = InOrderSuccesor(root.right);
            root.data = IS.data;
            deleteNode(root.right, IS.data);
        }
        return root;
    }

    private static Node InOrderSuccesor(Node root) {
        while (root.left != null)
            root = root.left;

        return root;
    }

    static void printInRange(Node root, int X, int Y) {
        if (root == null) return;

        if (root.data >= X && root.data <= Y) { //nodes present in  both sides
            printInRange(root.left, X, Y);
            System.out.print(root.data + " ");
            printInRange(root.right, X, Y);
        } else if (root.data >= Y) // nodes are only in left side
            printInRange(root.left, X, Y);
        else // nodes are only in right side
            printInRange(root.right, X, Y);
    }

    private static void root2LeafPath(Node root, ArrayList<Integer> path) {
        if (root == null) return;

        path.add(root.data);

        if (root.left == null && root.right == null) //leaf
            printPath(path);
        else { //non-leaf
            root2LeafPath(root.left, path);
            root2LeafPath(root.right, path);
        }
        path.remove(path.size() - 1); //need to remove it as we already calculated path of this node
    }

    private static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++)
            System.out.print(path.get(i) + "->");
    }

    public static void main(String[] args) {
        int[] nodes = {5, 9, 1, 3, 4, 2, 7};
        Node root = null;

        for (int i = 0; i < nodes.length; i++) {
            root = insert(root, nodes[i]);
        }

        inorder(root);
        System.out.println();

        System.out.println("Node present: " + searchNode(root, 4));
        System.out.println("Node present: " + searchNode(root, 10));

        deleteNode(root, 2);
        inorder(root);
        System.out.println();

        printInRange(root, 4, 7);
        System.out.println();
        root2LeafPath(root, new ArrayList<>());

    }
}
