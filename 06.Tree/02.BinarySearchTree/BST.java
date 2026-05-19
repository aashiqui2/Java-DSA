class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        this.data = val;
    }
}

public class BST {
    static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    static boolean search(Node root, int key) // O(H)
    {
        if (root == null) {
            return false;
        }

        if (root.data > key) {
            return search(root.left, key);
        }

        else if (root.data == key) {
            return true;
        } else {
            return search(root.right, key);
        }
    }

    // ! delete a node
    // case 1: no child(leaf node)
    // delete node &return null to parent

    // case 2: one child
    // delete node & replace with child node

    // case 3: two child
    // replace value with inorder successor and
    // delete the node for inorder successor
    // inorder successor will always have 0 or 1 child
    // bst--> left most in right subtree

    static Node deleteNode(Node root, int val) {
        if (root.data > val) {
            root.left = deleteNode(root.left, val);
        } else if (root.data < val) {
            root.right = deleteNode(root.right, val);
        } else {
            // root.data==val

            // case 1:
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2:
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case 3:
            // find inorder successor
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = deleteNode(root.right, IS.data);
        }
        return root;

    }

    static Node inorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        inorder(root);
        System.out.println();
        root = deleteNode(root, 4);
        inorder(root);

        // System.out.println(search(root, 8));

    }
}