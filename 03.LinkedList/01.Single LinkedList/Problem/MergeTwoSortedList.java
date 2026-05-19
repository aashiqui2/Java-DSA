public class MergeTwoSortedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    public void insertAtBeginning(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public static void display(Node head) {
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

    public static Node merge(Node l1, Node l2) {
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;
        if (l1.data > l2.data) {
            Node temp = l1;
            l1 = l2;
            l2 = temp;
        }
        l1.next = merge(l1.next, l2);
        return l1;
    }

    public static void main(String[] args) {
        MergeTwoSortedList m1 = new MergeTwoSortedList();
        m1.insertAtBeginning(4);
        m1.insertAtBeginning(2);
        m1.insertAtBeginning(1);
        System.out.println("List1  nodes are :");
        display(m1.head);
        MergeTwoSortedList m2 = new MergeTwoSortedList();
        m2.insertAtBeginning(4);
        m2.insertAtBeginning(3);
        m2.insertAtBeginning(1);
        System.out.println("List2  nodes are :");
        display(m2.head);
        Node head = merge(m1.head, m2.head);
        display(head);

    }
}
//! Question Link(21)-> https://leetcode.com/problems/merge-two-sorted-lists/description/
