package DSA.Tree;

import java.util.*;

public class BSTImpl {

    static Node insert(Node root, int val) { //inorder way - O(H)
        if (root == null) {
            root = new Node(val);
            return root;
        }
        
        if (val < root.data)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }

    //Inorder - for BST inorder will always give sorted order of nodes
    static void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    static List<List<Integer>> levelOrder(Node root) { //Approach 2
        List<List<Integer>> result = new ArrayList<>(); //to store end result of all levels

        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root); //use offer or add

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(); //to store level result
            for (int i=0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode.data);

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

    // we return the elements that are at the end of each level, which gives right-side elements only
    static List<Integer> rightSideView(Node root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i=0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                if (i == levelSize - 1) { //end element check in a level
                    result.add(currentNode.data);
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return result;
    }

    static boolean searchNode(Node root, int key) { //O(H)
        if (root == null)
            return false;

        if (root.data > key) //left subtree
            return searchNode(root.left, key);
        else if (root.data < key) //right subtree
            return searchNode(root.right, key);
        else
            return true;  //root
    }

    static Node deleteNode(Node root, int val) {
        if (root == null)
            return null;
        if (root.data > val)
            root.left = deleteNode(root.left, val);
        else if (root.data < val)
            root.right = deleteNode(root.right, val);
        else { //means root.data == val
            //No child - delete node & return null to parent
            if (root.left == null && root.right == null)
                return null;

            //one child - delete node & replace with child node
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            //two children - replace with inorder successor(left most in right subtree) & delete node
            Node IS = InOrderSuccesor(root.right);
            root.data = IS.data;
            root.right = deleteNode(root.right, IS.data);
        }
        return root;
    }

    //left most in right subtree
    static Node InOrderSuccesor(Node root) {
        while (root.left != null)
            root = root.left; //go to left most child

        return root;
    }

    static Node invertBST(Node root){
        if(root == null) return null;

        Node left = invertBST(root.left);
        Node right = invertBST(root.right);

        root.left = right;
        root.right = left;
        return root;
    }

    static int height(Node root) {
        if (root == null) {
            return -1; // or return 0 if you prefer height in terms of nodes
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    static boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 &&
                isBalanced(node.left) &&
                isBalanced(node.right);
    }

    static void printInRange(Node root, int X, int Y) {
        if (root == null) return;

        if (root.data >= X && root.data <= Y) { //nodes present in  both sides, use inorder
            printInRange(root.left, X, Y);
            System.out.print(root.data + " ");
            printInRange(root.right, X, Y);
        } else if (root.data >= Y) // nodes are only in left side
            printInRange(root.left, X, Y);
        else // nodes are only in right side
            printInRange(root.right, X, Y);
    }

    //add all possible paths from root to nodes
    static void root2LeafPath(Node root, ArrayList<Integer> path) {
        if (root == null) return;

        path.add(root.data);
        if (root.left == null && root.right == null) //leaf
            System.out.println(path);
        else { //non-leaf
            root2LeafPath(root.left, path);
            root2LeafPath(root.right, path);
        }
        path.remove(path.size() - 1); //need to remove it as we already calculated path of this node
    }

    static boolean isValidBST(Node node, Integer low, Integer high) { //initially pass nulls for low, high
        if (node == null) {
            return true;
        }
        if (low != null && node.data <= low) {
            return false;
        }
        if(high != null && node.data >= high) {
            return false;
        }

        boolean leftTree = isValidBST(node.left, low, node.data);
        boolean rightTree = isValidBST(node.right, node.data, high);

        return leftTree && rightTree;
    }

    static int count = 0;
    static int kthSmallest(Node root, int k) { //use inorder traversal
        if (root == null) {
            return -1;
        }

        int left = kthSmallest(root.left, k);
        if (left != -1) {
            return left;
        }

        count++;
        if(count == k) {
            return root.data;
        }
        return kthSmallest(root.right, k);
    }

    public static void main(String[] args) {
        int[] nodes = {5, 2, 7, 1, 4, 6, 9, 8, 3, 10};
        Node root = null;

        for (int i = 0; i < nodes.length; i++) { //iterate over each element to form tree
            root = insert(root, nodes[i]);
        }

        inorder(root);
        System.out.println();

        System.out.println("Node present: " + searchNode(root, 4));
        System.out.println("Node present: " + searchNode(root, 0));

        deleteNode(root, 2);
        inorder(root);
        System.out.println();

        invertBST(root);
        inorder(root);
        System.out.println();

        printInRange(root, 4, 7);
        System.out.println();

        System.out.println("Root to Node paths:");
        root2LeafPath(root, new ArrayList<>());

        System.out.println("isBalanced: " + isBalanced(root));

        System.out.println(levelOrder(root));

        System.out.println(rightSideView(root));

        System.out.println("Given BST is Valid :"+isValidBST(root, null, null));  //false - as we inverted BST

        System.out.println("kth Smallest node:"+ kthSmallest(root, 4)); //tree is inverted, so ans might wary
    }
}
