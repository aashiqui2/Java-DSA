class Node {
    int data;
    Node left, right;
    int height;

    Node(int data) {
        this.data = data;
        this.height = 0;
    }
}

public class AVL {

    public static Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        } else if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        } else {
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        // LL Case
        if (balance > 1 && data < node.left.data) {
            return rightRotate(node);
        }

        // LR Case
        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RR Case
        if (balance < -1 && data > node.right.data) {
            return leftRotate(node);
        }

        // RL Case
        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    public static int height(Node node) {
        return node == null ? -1 : node.height;
    }

    public static int getBalance(Node node) {
        return node == null ? 0 : (height(node.left) - height(node.right));
    }

    public static Node rightRotate(Node z) {
        Node y = z.left; // y becomes the new root of this subtree
        Node t3 = y.right; // Store the right child of y

        // Perform the rotation
        y.right = z;
        z.left = t3;

        // Update the heights after the rotation
        z.height = 1 + Math.max(height(z.left), height(z.right)); // Update z's height
        y.height = 1 + Math.max(height(y.left), height(y.right)); // Update y's height

        // Return the new root (y)
        return y;
    }

    public static Node leftRotate(Node z) {
        Node y = z.right;
        Node t3 = y.left;

        // Perform the rotation
        y.left = z;
        z.right = t3;

        // Update the heights after the rotation
        z.height = 1 + Math.max(height(z.left), height(z.right)); // Update z's height
        y.height = 1 + Math.max(height(y.left), height(y.right)); // Update y's height

        // Return the new root (y)
        return y;
    }

    public static void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.println(node.data + "(H: " + node.height + ")");
        inorder(node.right);
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
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        // Check balance factor
        int balance = getBalance(root);

        // If unbalanced, perform rotations

        // LL imbalance
        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }

        // LR imbalance
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // RR imbalance
        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }

        // RL imbalance
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
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
        int[] a = { 3, 2, 1 };
        Node root = null;
        for (int num : a) {
            root = insert(root, num);
        }
        inorder(root);
        root=deleteNode(root, 2);
        inorder(root);
    }
}
