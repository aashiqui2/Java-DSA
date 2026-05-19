class Node {
    int data;
    Node left;
    Node right;
    Node parent;
    boolean isRed; // true for red, false for black

    Node(int val) {
        this.data = val;
        this.isRed = true; // New nodes are always red by default
    }
}

public class RedBlackTree {
    private Node root;

    // Left rotate method
    private void leftRotate(Node x) {
        Node y = x.right; // y is x's right child
        x.right = y.left;

        if (y.left != null) {
            y.left.parent = x;
        }

        y.parent = x.parent;

        if (x.parent == null) {
            root = y; // y becomes the new root
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }

        y.left = x;
        x.parent = y;
    }

    // Right rotate method
    private void rightRotate(Node x) {
        Node y = x.left; // y is x's left child
        x.left = y.right;

        if (y.right != null) {
            y.right.parent = x;
        }

        y.parent = x.parent;

        if (x.parent == null) {
            root = y; // y becomes the new root
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }

        y.right = x;
        x.parent = y;
    }

    // Insert method with fix-up
    public void insert(int val) {
          Node newNode = new Node(val);
        root = bstInsert(root, newNode); // Standard BST insertion

        // Fix violations
        fixViolation(newNode);
    }

    private Node bstInsert(Node root, Node newNode) {
        if (root == null) {
            return newNode;
        }

        if (newNode.data < root.data) {
            root.left = bstInsert(root.left, newNode);
            root.left.parent = root;
        } else if (newNode.data > root.data) {
            root.right = bstInsert(root.right, newNode);
            root.right.parent = root;
        }

        return root;
    }

    // Fix violations after insertion
    private void fixViolation(Node newNode) {
        Node parent = null;
        Node grandparent = null;

        while (newNode != root && newNode.isRed && newNode.parent.isRed) {
            parent = newNode.parent;
            grandparent = parent.parent;

            // Case A: Parent is left child of grandparent
            if (parent == grandparent.left) {
                Node uncle = grandparent.right;

                // Case 1: Uncle is red (Recoloring)
                if (uncle != null && uncle.isRed) {
                    parent.isRed = false;
                    uncle.isRed = false;
                    grandparent.isRed = true;
                    newNode = grandparent;
                } else {
                    // Case 2: Uncle is black and newNode is right child (Left Rotate)
                    if (newNode == parent.right) {
                        leftRotate(parent);
                        newNode = parent;
                        parent = newNode.parent;
                    } 

                    // Case 3: Uncle is black and newNode is left child (Right Rotate)
                    rightRotate(grandparent);
                    boolean temp = parent.isRed;
                    parent.isRed = grandparent.isRed;
                    grandparent.isRed = temp;
                    newNode = parent;
                }
            }

            // Case B: Parent is right child of grandparent (Mirror of Case A)
            else {
                Node uncle = grandparent.left;

                // Case 1: Uncle is red (Recoloring)
                if (uncle != null && uncle.isRed) {
                    parent.isRed = false;
                    uncle.isRed = false;
                    grandparent.isRed = true;
                    newNode = grandparent;
                } else {
                    // Case 2: Uncle is black and newNode is left child (Right Rotate)
                    if (newNode == parent.left) {
                        rightRotate(parent);
                        newNode = parent;
                        parent = newNode.parent;
                    }

                    // Case 3: Uncle is black and newNode is right child (Left Rotate)
                    leftRotate(grandparent);
                    boolean temp = parent.isRed;
                    parent.isRed = grandparent.isRed;
                    grandparent.isRed = temp;
                    newNode = parent;
                }
            }
        }

        root.isRed = false; // Ensure the root is always black
    }

    // Inorder traversal
    public void inorder() {
        inorderHelper(root);
        System.out.println();
    }

    private void inorderHelper(Node root) {
        if (root == null) {
            return;
        }

        inorderHelper(root.left);
        System.out.print(root.data + (root.isRed ? "R " : "B "));
        inorderHelper(root.right);
    }

    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();
        // int[] values = {10, 20, 30, 15, 25, 5, 1};
        int[] values = {10, 18,7,15,16,30,25,40,60,2,1,70};

        for (int val : values) {
            rbt.insert(val);
        }

        // Print the tree (inorder traversal)
        rbt.inorder();
    }
}
