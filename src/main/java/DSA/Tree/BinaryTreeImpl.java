package DSA.Tree;

import java.util.LinkedList;
import java.util.Queue;

//In BinaryTree nodes are not ordered, for BST nodes are ordered in a way that
// nodes that are left to root are smaller, nodes in right are higher than root.

public class BinaryTreeImpl {// Build Tree from given Preorder Sequence / traversal

    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left = null;   // no need to add these lines to assign null
            this.right = null;
        }
    }

    static int idx = -1;
    public static Node populateTree(int[] nodes) { //forms the tree from given pre-order sequence
        idx++;
        if (nodes[idx] == -1) { //if empty
            return null;
        }
        Node root = new Node(nodes[idx]);
        root.left = populateTree(nodes);
        root.right = populateTree(nodes);
        return root;
    }

    //Preorder =  N -> L -> R
    //Useful for creating a copy of the tree, as it visits the root node first and then recursively visits the left and right subtrees
    public static void preorder(Node root) {
        if (root == null) {
            System.out.print(-1 + " ");
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    //Inorder = L -> N -> R
    public static void inorder(Node root) {
        if (root == null) {
            System.out.print(-1 + " ");
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    //Postorder = L -> R -> N
    // use if we want to deleting or freeing nodes in tree
    public static void postorder(Node root) {
        if (root == null) {
            System.out.print(-1 + " ");
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    //LevelOrder -> gives order of elements based on their levels
    public static void levelOrder(Node root) { //Approach 1
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null); //add to have a level structure in console
        while (!q.isEmpty()) {
            Node curr = q.poll(); // Printing the top element and removing it
            if (curr == null) {
                System.out.println();
                if (q.isEmpty())
                    break;
                else
                    q.add(null);
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

    static Node findNode(Node root, int x) {
        if (root == null)
            return null;
        if (root.data == x)
            return root;

        Node n = findNode(root.left, x);
        if (n != null) {
            return n;
        }
        return findNode(root.right, x);
    }

    //gives level of given key
    static int level(Node root, Node x, int lev) {
        if(root == null) {
            return 0;
        }
        if(root == x) {
            return lev;
        }

        int l = level(root.left, x, lev+1);
        if (l != 0) {
            return l;
        }
        return level(root.right, x, lev+1);
    }

    //isSymmetrical -> both sides of a tree should be equal
    public static boolean isSymmetric(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root.left); //don't need root as it is common for both sides
        queue.add(root.right);

        while(!queue.isEmpty()) {
            Node left = queue.poll();
            Node right = queue.poll();

            if(left == null && right == null) {
                continue;
            }
            if(left == null || right == null) {
                return false;
            }

            if (left.data != right.data) {
                return false;
            }

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    //nodes that are in same level for same parent
    static boolean isSibling(Node root, int x, int y) {
        if (root == null) {
            return false;
        }
        Node xx = findNode(root, x);
        Node yy = findNode(root, y);

        return ((root.left == xx && root.right == yy) || (root.left == yy && root.right == xx)
                        || isSibling(root.left, x, y) || isSibling(root.right, x, y));
    }

    //nodes that are in same level but diff parent
    public static boolean isCousins(Node root, int x, int y) {
        Node xx = findNode(root, x);
        Node yy = findNode(root, y);

        return ((level(root, xx, 0) == level(root, yy, 0))
                && (!isSibling(root, x, y)));
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

    private static void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }

        prettyDisplay(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.data);
        } else {
            System.out.println(node.data);
        }
        prettyDisplay(node.left, level + 1);
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = populateTree(nodes);
        System.out.println("Root: " + root.data);

        prettyDisplay(root, 0);

        System.out.print("preOrder: ");
        preorder(root);
        System.out.print("InOrder: ");
        inorder(root);
        System.out.print("postOrder: ");
        postorder(root);

        System.out.println();
        System.out.println("levelOrder:");
        levelOrder(root);

        System.out.println("Count of Nodes: " + countOfNodes(root));
        System.out.println("Height: " + height(root));
        System.out.println("Sum of Nodes: " + sumOfNodes(root));
        System.out.println("Diameter of Tree: " + diameter(root));

        System.out.println("is Subtree: " + isSubtree(root, root));

        Node node1 = findNode(root, 6);
        System.out.println("findNode: " + node1.data);

        System.out.println("Level of node " + node1.data +" is :"+ level(root, node1, 0));

        System.out.println("isSymmetric:"+isSymmetric(root));

        System.out.println("isCousins : "+isCousins(root, 1, 4));
        System.out.println(isCousins(root, 6, 4));

        System.out.println("isSibblings: "+isSibling(root, 1, 4));
    }
}

