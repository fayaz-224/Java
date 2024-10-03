package DSA.BFS_DFS;

//Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
//https://leetcode.com/problems/path-sum/description/
public class PathSum {

    //DFS
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;

        targetSum -= root.val;
        // Check if we are at a leaf node and the remaining targetSum equals the leaf's value
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }

        return hasPathSum(root.left, targetSum)
                || hasPathSum(root.right, targetSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        int targetSum = 22;

        System.out.println("Has Path for given targetSum: "+ hasPathSum(root, targetSum));
    }
}

