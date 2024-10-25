package DSA.BFS_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/cousins-in-binary-tree/description/
public class CousinsInBT {  //BFS - can be done in DFS also

    public static boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                //checking next values in advance to avoid siblings
                if (current.left != null && current.right != null) {
                    if ((current.left.val == x && current.right.val == y) ||
                            (current.left.val == y && current.right.val == x)) {
                        return false; // x and y are siblings, not cousins
                    }
                }
                level.add(current.val);

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }

            if(level.contains(x) && level.contains(y))
                return true; // x and y are at the same level and not siblings
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println("Are nodes 4 and 5 cousins? " + isCousins(root, 4, 5));  // true
        System.out.println("Are nodes 2 and 3 cousins? " + isCousins(root, 2, 3));  // false (siblings)
    }
}
