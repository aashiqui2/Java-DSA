public class ReverseLinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    public void insertAtEnd(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Inserted " + val + " at the end");
    }

    public void display(Node head) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public Node Reverse() {
        Node temp = head;
        Node prev = null;
        Node next = null;
        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        head = prev;
        return head;
    }

    public static void main(String[] args) {
        ReverseLinkedList rl = new ReverseLinkedList();
        rl.insertAtEnd(1);
        rl.insertAtEnd(2);
        rl.insertAtEnd(3);
        rl.insertAtEnd(4);
        rl.insertAtEnd(5);
        System.out.println("Original List Before Reverse :");
        rl.display(rl.head);
        Node head = rl.Reverse();
        System.out.println("Original List After Reverse :");
        rl.display(head);

    }
}
//! Question Link(206)->https://leetcode.com/problems/reverse-linked-list/description/
