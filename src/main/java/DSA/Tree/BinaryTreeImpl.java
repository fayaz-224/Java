package DSA.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//In BinaryTree nodes are not ordered (left and right child can have any value), and each node has at most two children.
// for BST nodes are ordered in a way that nodes that are left to root are smaller, nodes in right are higher than root. (sorted order)

class BinaryTreeImpl {

    static int idx = -1;
     static Node buildTreeFromPreorder(int[] nodes) { //forms the tree from given pre-order sequence
        idx++;
        if (nodes[idx] == -1) { //On -1, it returns null, simulating leaf node termination.
            return null;
        }
        Node root = new Node(nodes[idx]);
        root.left = buildTreeFromPreorder(nodes);
        root.right = buildTreeFromPreorder(nodes);
        return root;
    }

    Node root;  //we can a have global root for all methods
    void buildTreeFromInOrder(int value) {  //InOrder way to build tree. if we pass array as param to insert then we have to find mid-element and use it as root and recursively fill left and right
        Node newNode = new Node(value);

        // If tree is empty, make it the root
        if (root == null) {
            root = newNode;
            return;
        }

        // Level order traversal to find the first empty spot
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp.left == null) {
                temp.left = newNode;
                break;
            } else {
                queue.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = newNode;
                break;
            } else {
                queue.add(temp.right);
            }
        }
    }

    //Preorder =  Root -> Left -> Right
    //Useful for creating a copy of the tree, as it visits the root node first and then recursively visits the left and right subtrees
     static void preorder(Node root) {
        if (root == null) {
            //System.out.print(-1 + " ");
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    //Inorder = Left -> Root -> Right
    //For Binary Search Trees (BSTs), inorder gives sorted order
     static void inorder(Node root) {
        if (root == null) {
            //System.out.print(-1 + " ");
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    //Postorder = Left -> Right -> Root
    // use if we want to delete or freeing nodes in tree
     static void postorder(Node root) {
        if (root == null) {
            //System.out.print(-1 + " ");
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    //LevelOrder traversal -> gives order of elements based on their levels
    static List<List<Integer>> levelOrder(Node root) {
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

    //Height of Tree
     static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;  //+1 includes root
    }

    //Count of Nodes of Tree
     static int countOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);
        return leftNodes + rightNodes + 1;
    }

    //Sum of Nodes of Tree
     static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        return leftSum + rightSum + root.data;
    }

    //Diameter of Tree -> no. of nodes in the longest path btw any 2 nodes
     static int diameter(Node root) { // O(N^2)
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

    //Symmetrical -> both sides of a tree should be equal
     static boolean isSymmetric(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root.left); //we don't need root, as it is common for both sides
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

            //add in the order of symmetry
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    //sibling -> nodes that are in same level for same parent
    static boolean isSibling(Node root, int x, int y) {
        if (root == null) {
            return false;
        }

        // Check if current node has both left and right children
        if (root.left != null && root.right != null) {
            int leftData = root.left.data;
            int rightData = root.right.data;

            if ((leftData == x && rightData == y) || (leftData == y && rightData == x)) {
                return true;
            }
        }

        // Recursively check left and right subtrees
        return isSibling(root.left, x, y) || isSibling(root.right, x, y);
    }

    //cousins -> nodes that are in same level but diff parent
     static boolean isCousins(Node root, int x, int y) {
        Node xx = findNode(root, x);
        Node yy = findNode(root, y);

        if (xx == null || yy == null) return false;

        return ((level(root, xx, 0) == level(root, yy, 0)) &&
                (!isSibling(root, x, y)));
    }

    static boolean isIdentical(Node root, Node subRoot) {
        if (subRoot == null && root == null)
            return true;
        if (root == null || subRoot == null)
            return false;

        if (root.data == subRoot.data)
            return isIdentical(root.left, subRoot.left) &&
                    isIdentical(root.right, subRoot.right);

        return false;
    }

    //Subtree of another tree
     static boolean isSubtree(Node root, Node subRoot) {
        if (subRoot == null)
            return true;
        if (root == null)
            return false;

        if (isIdentical(root, subRoot))
            return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private static void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }

        prettyDisplay(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {  //indentation
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.data);
        } else {
            System.out.println(node.data);  //root node
        }

        prettyDisplay(node.left, level + 1);
    }

     public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};  // Build Tree from given Preorder Sequence, -1 marker for null nodes
        Node root = buildTreeFromPreorder(nodes);
        prettyDisplay(root, 0);

        System.out.print("preOrder: ");
        preorder(root);
        System.out.print("InOrder: ");
        inorder(root);
        System.out.print("postOrder: ");
        postorder(root);

        System.out.println();
        System.out.println("levelOrder:");
         System.out.println(levelOrder(root));

        System.out.println("Count of Nodes: " + countOfNodes(root));
        System.out.println("Height: " + height(root));
        System.out.println("Sum of Nodes: " + sumOfNodes(root));
        System.out.println("Diameter of Tree: " + diameter(root));

        System.out.println("is Subtree: " + isSubtree(root, root));

        Node node1 = findNode(root, 6);
        System.out.println("findNode: " + node1.data);

        System.out.println("Level of node " + node1.data +" is: "+ level(root, node1, 0));

        System.out.println("isSymmetric: "+isSymmetric(root));

        System.out.println("isCousins: "+isCousins(root, 1, 4));
        System.out.println(isCousins(root, 6, 4));

        System.out.println("isSiblings: "+isSibling(root, 1, 4));
    }
}

