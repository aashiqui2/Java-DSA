class CircularDoublyLinkedList {
    Node head;

    class Node {
        Node prev;
        int data;
        Node next;

        Node(int val) {
            data = val;
            prev = null;
            next = null;
        }
    }

    CircularDoublyLinkedList() {
        head = null;
    }

    public void insertBegin(int val) {
        Node newnode = new Node(val);
        if (head == null) {
            newnode.next = newnode;
            newnode.prev = newnode;
            head = newnode;
        } else {
            Node tail = head.prev;
            newnode.next = head;
            newnode.prev = tail;
            head.prev = newnode;
            tail.next = newnode;
            head = newnode;
        }
    }

    public void insertAtEnd(int val) {
        Node newnode = new Node(val);
        if (head == null) {
            newnode.next = newnode;
            newnode.prev = newnode;
            head = newnode;
        } else {
            Node tail = head.prev;
            newnode.next = head;
            newnode.prev = tail;
            tail.next = newnode;
            head.prev = newnode;
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

        Node temp = head;
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
            if (temp == head) {
                System.out.println("Position out of bounds");
                return;
            }
        }

        Node newnode = new Node(val);
        Node nextNode = temp.next;

        newnode.prev = temp;
        newnode.next = nextNode;
        temp.next = newnode;
        nextNode.prev = newnode;
    }

    public void deleteAtBegin() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == head) {
            head = null;
        } else {
            Node tail = head.prev;
            head = head.next;
            head.prev = tail;
            tail.next = head;
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
            Node tail = head.prev;
            Node newTail = tail.prev;
            newTail.next = head;
            head.prev = newTail;
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
        for (int i = 0; i < pos; i++) {
            temp = temp.next;
            if (temp == head) {
                System.out.println("Position out of bounds");
                return;
            }
        }

        Node prevNode = temp.prev;
        Node nextNode = temp.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        if (temp == head) {
            head = nextNode;
        }
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
        CircularDoublyLinkedList dl = new CircularDoublyLinkedList();
        dl.insertBegin(3);
        dl.insertBegin(2);
        dl.insertBegin(1);
        dl.insertAtEnd(4);
        dl.deleteAtpos(2);
        dl.display();
    }
}
