package DSA.Tree;

//Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
//https://leetcode.com/problems/path-sum/description/
public class PathSum {

    //DFS
    public static boolean hasPathSum(Node root, int targetSum) {
        if(root==null) return false;

        targetSum -= root.data;
        // Check if we are at a leaf node and the remaining targetSum is zero
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }

        return hasPathSum(root.left, targetSum) ||
                hasPathSum(root.right, targetSum);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(11);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);
        root.right.left = new Node(13);
        root.right.right = new Node(4);
        root.right.right.right = new Node(1);
        int targetSum = 22;

        System.out.println("Has Path for given targetSum: "+ hasPathSum(root, targetSum));
    }
}

