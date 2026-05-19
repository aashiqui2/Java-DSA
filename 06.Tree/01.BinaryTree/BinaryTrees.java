import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    static int idx = -1;

    Node buildTree(int nodes[]) {
        idx++;
        if (nodes[idx] == -1) {
            return null;
        }
        Node newnode = new Node(nodes[idx]);
        newnode.left = buildTree(nodes);
        newnode.right = buildTree(nodes);
        return newnode;
    }

    void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    void levelorder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    // time complexity: O(n)
    int count(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNodes = count(root.left);
        int rightNodes = count(root.right);
        return leftNodes + rightNodes + 1;
    }

    int sumNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNodes = sumNodes(root.left);
        int rightNodes = sumNodes(root.right);
        return leftNodes + rightNodes + root.data;
    }
    // time complexity: O(n)

    // !height of tree ->number of edges in the longest path from the root node to a
    // leaf node.
    // ! Level of a tree which is always equal to the height of the node
    // ! height of a tree is always equal to the height of the root node
    int height(Node root) {
        if (root == null) {
            return 0;//for no of nodes
            //return -1;// for no of edges
        }
        int leftheight = height(root.left);
        int rightheight = height(root.right);
        int myheight = Math.max(leftheight, rightheight) + 1;
        return myheight;
    }
    // time complexity: O(n)

    // ! Diameter of a tree -> Number of nodes in the longest path between any 2
    // nodes
    // ? case 1: diameter pass through root
    // ? case 2: diameter does not pass through root

    // Approach 1: O(n^2)
    int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int diam1 = diameter(root.left);// LEFT SUBTREE DIAMETER
        int diam2 = diameter(root.right);// RIGHT SUBTREE DIAMETER
        int diam3 = height(root.left) + height(root.right) + 1;
        return Math.max(diam3, Math.max(diam1, diam2));
    }
    // time complexity: O(n^2)

    // Approach 2: O(n)
    // ! store tree info
    TreeInfo diameter2(Node root) {

        if (root == null) {
            return new TreeInfo(0, 0);
        }
        TreeInfo left = diameter2(root.left);
        TreeInfo right = diameter2(root.right);

        int myheight = Math.max(left.ht, right.ht) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;

        int mydiam = Math.max(diam3, Math.max(diam1, diam2));

        TreeInfo myinfo = new TreeInfo(myheight, mydiam);
        return myinfo;
    }

    boolean searchBinaryTree(Node root, int target) {
        if (root == null) {
            return false; // Base case: reached the end of a branch
        }
        if (root.data == target) {
            return true; // Value found
        }
        // Recursively search in left and right subtrees
        return searchBinaryTree(root.left, target) || searchBinaryTree(root.right, target);
    }
}

class TreeInfo {
    int ht;
    int diam;

    TreeInfo(int ht, int diam) {
        this.ht = ht;
        this.diam = diam;
    }
}

public class BinaryTrees {
    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        // System.out.println(root.data);
        // tree.preorder(root);
        // tree.inorder(root);
        // tree.postorder(root);
        // tree.levelorder(root);
        // System.out.println(tree.count(root));
        // System.out.println(tree.sumNodes(root));
        // System.out.println(tree.height(root));
        // System.out.println(tree.diameter(root));
        // System.out.println(tree.diameter2(root).diam);
        // System.out.println(tree.searchBinaryTree(root, 3));
    }
}
