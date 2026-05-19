public class RemoveDuplicates {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head = null;

    public  void insertAtBeginning(int val) {
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

    public void removeDuplicate() {
        Node temp = head;
        while (temp != null && temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next; 
            } else {
                temp = temp.next; 
            }
        }
    }

    public static void main(String[] args) {
        RemoveDuplicates rd = new RemoveDuplicates();
        rd.insertAtBeginning(3);
        rd.insertAtBeginning(1);
        rd.insertAtBeginning(1);
        display(head);
        System.out.println("After removing the duplicates ");
        rd.removeDuplicate();
        display(head);

    }
}
//!Question Link(83) ->https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
