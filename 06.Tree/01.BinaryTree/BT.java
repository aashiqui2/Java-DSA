public class BT {
    Node root;
    class Node{
        int data;
        Node left,right;

        Node(int d){
            data=d;
            left=null;
            right=null;
        }
    }
    BT(int val)
    {
       root=new Node(val); 
    }

    void insertLeft(Node root,int val)
    {
       Node newnode=new  Node(val);
       root.left=newnode;
    }
    void insertRight(Node root,int val)
    {
       Node newnode=new  Node(val);
       root.right=newnode;
    }

    void preorder(Node root)
    {
        if(root==null)
        {
            return;
        }
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    //inorder,post order

    public static void main(String[] args) {
        BT tree=new BT(10);
        tree.insertLeft(tree.root, 5);
        tree.insertRight(tree.root, 15);
        tree.insertLeft(tree.root.left, 3);
        tree.insertRight(tree.root.left, 8);
        tree.insertLeft(tree.root.right, 12);
        tree.preorder(tree.root);

    }
}
