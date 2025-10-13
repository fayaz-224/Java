package DSA.Tree;

import java.util.LinkedList;
import java.util.List;

//Print all possible paths from root-to-leaf, whose sum is equals to targetSum
public class PathSum2 {

    private static List<List<Integer>> gatherAllPathSum(Node root, int targetSum) {
        List<List<Integer>> res = new LinkedList<>();
        if(root==null) return res;

        dfs(root, targetSum, res, new LinkedList<>());
        return res;
    }

    private static void dfs(Node root, int targetSum, List<List<Integer>> res, LinkedList<Integer> path) {
        targetSum -= root.data;
        path.add(root.data);

        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new LinkedList<>(path));
        } else {
            if(root.left != null)
                dfs(root.left, targetSum, res, path);
            if(root.right != null)
                dfs(root.right, targetSum, res, path);
        }

        path.remove(path.size()-1);  //backtrack if ans not found
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(11);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);
        root.right.left = new Node(9);
        root.right.right = new Node(4);
        root.right.right.right = new Node(1);
        int targetSum = 22;

        System.out.println("All Paths for given targetSum: "+ gatherAllPathSum(root, targetSum));
    }
}
