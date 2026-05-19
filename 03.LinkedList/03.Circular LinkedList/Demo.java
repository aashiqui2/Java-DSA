class CircularSinglyLinkedList {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
    }

    CircularSinglyLinkedList() {
        head = null;
    }

    public void insertBegin(int val) {
        Node newnode = new Node(val);
        if (head == null) {
            head = newnode;
            newnode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newnode.next = head;
            temp.next = newnode;
            head = newnode;
        }
    }

    public void insertAtEnd(int val) {
        Node newnode = new Node(val);
        if (head == null) {
            head = newnode;
            newnode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newnode;
            newnode.next = head;
        }
    }

    public void insertAtpos(int pos, int val) {
        if (pos == 0) {
            insertBegin(val);
            return;
        }

        if (head == null) {
            System.out.println("List is empty, unable to insert at position");
            return;
        }

        Node newnode = new Node(val);
        Node temp = head;

        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
            if (temp == head) {
                System.out.println("Position out of bounds");
                return;
            }
        }

        newnode.next = temp.next;
        temp.next = newnode;
    }

    public void deleteAtBegin() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == head) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = head.next;
            head = head.next;
        }
    }

    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == head) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != head) {
                temp = temp.next;
            }
            temp.next = head;
        }
    }

    public void deleteAtpos(int pos) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (pos == 0) {
            deleteAtBegin();
            return;
        }

        Node temp = head;
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
            if (temp.next == head) {
                System.out.println("Position out of bounds");
                return;
            }
        }

        Node nextNode = temp.next.next;
        temp.next = nextNode;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + "->");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(head)");
    }
}

public class Demo {
    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        csll.insertBegin(3);
        csll.insertBegin(2);
        csll.insertBegin(1);
        csll.insertAtEnd(4);
        csll.deleteAtpos(2);
        csll.display();
    }
}
