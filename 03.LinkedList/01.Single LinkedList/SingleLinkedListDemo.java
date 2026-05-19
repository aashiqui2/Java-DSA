import java.util.Scanner;

public class SingleLinkedListDemo {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head = null;

    public void insertAtBeginning(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        System.out.println("Inserted " + val + " at the beginning");
    }

    public void insertAtPos(int pos, int val) {
        if (pos == 0) {
            insertAtBeginning(val);
            return;
        }
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            for (int i = 0; i < pos - 1; i++) {
                if (temp == null || temp.next == null) {
                    System.out.println("Invalid position");
                    return;
                }
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        System.out.println("Inserted " + val + " at pos " + pos);
    }

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

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        System.out.print("Elements in the list are: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void deleteBegin() {
        if (head == null) {
            System.out.println("Linked List is empty | Nothing to delete");
            return;
        } else {
            head = head.next;
        }
        System.out.println("Node deleted at the beginning");
    }

    public void deleteEnd() {
        if (head == null) {
            System.out.println("Linked List is empty | Nothing to delete");
            return;
        } else if (head.next == null) {
            head = null;
        } else {
            Node temp = head;
            Node prev = null;
            while (temp.next != null) {
                prev = temp;
                temp = temp.next;
            }
            if (prev != null) {
                prev.next = null;
            }
        }
        System.out.println("Node deleted at the end");
    }

    public void deleteFromPos(int pos) {
        if (head == null) {
            System.out.println("Linked List is empty | Nothing to delete");
            return;
        }
        Node temp = head;
        Node prev = null;
        if (pos == 0) {
            head = head.next;
            System.out.println("Deleted " + temp.data);
            return;
        }
        for (int i = 0; i < pos; i++) {
            if (temp == null) {
                System.out.println("Invalid position");
                return;
            }
            prev = temp;
            temp = temp.next;
        }
        if (prev != null && temp != null) {
            prev.next = temp.next;
            System.out.println("Deleted " + temp.data);
        } else {
            System.out.println("Invalid position");
        }
    }

    public void search(int val) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        int pos = 0;
        while (temp != null) {
            if (temp.data == val) {
                System.out.println("Value " + val + " found at position " + pos);
                return;
            }
            temp = temp.next;
            pos++;
        }
        System.out.println("Value " + val + " not found in the list");
    }

    public int length() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void update(int pos, int newVal) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        for (int i = 0; i < pos; i++) {
            if (temp == null) {
                System.out.println("Invalid position");
                return;
            }
            temp = temp.next;
        }
        if (temp != null) {
            System.out.println("Updated node at position " + pos + " from " + temp.data + " to " + newVal);
            temp.data = newVal;
        } else {
            System.out.println("Invalid position");
        }
    }

    public int sum() {
        int sum = 0;
        Node temp = head;
        while (temp != null) {
            sum += temp.data;
            temp = temp.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        SingleLinkedListDemo list = new SingleLinkedListDemo();
        Scanner scanner = new Scanner(System.in);
        int choice, val, pos;

        while (true) {
            System.out.println("\n--------Linked List Menu-----------");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at specified position");
            System.out.println("4. Display the list");
            System.out.println("5. Delete at Beginning");
            System.out.println("6. Delete at End");
            System.out.println("7. Delete from specified position");
            System.out.println("8. Search the element");
            System.out.println("9. Find the length");
            System.out.println("10. update the value at Pos");
            System.out.println("11. Exit");
            System.out.println("--------------------------------------");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the data: ");
                    val = scanner.nextInt();
                    list.insertAtBeginning(val);
                    break;
                case 2:
                    System.out.print("Enter the data: ");
                    val = scanner.nextInt();
                    list.insertAtEnd(val);
                    break;
                case 3:
                    System.out.print("Enter the position: ");
                    pos = scanner.nextInt();
                    System.out.print("Enter the data: ");
                    val = scanner.nextInt();
                    list.insertAtPos(pos, val);
                    break;
                case 4:
                    list.display();
                    break;
                case 5:
                    list.deleteBegin();
                    break;
                case 6:
                    list.deleteEnd();
                    break;
                case 7:
                    System.out.print("Enter the position: ");
                    pos = scanner.nextInt();
                    list.deleteFromPos(pos);
                    break;
                case 8:
                    System.out.print("Enter the data to search: ");
                    val = scanner.nextInt();
                    list.search(val);
                    break;
                case 9:
                    System.out.println("Length of the list is " + list.length());
                    break;
                case 10:
                    list.update(2, 3);
                    System.out.println("The value is updated");
                    break;
                case 11:
                    System.out.println("Sum of Nodes is " + list.sum());
                case 12:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Wrong choice");
                    break;
            }
        }
    }
}
