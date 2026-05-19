import java.util.Iterator;

class LinkedList<T> implements Iterable<T> {
    Node head;

    class Node {
        T data;
        Node next;

        Node(T val) {
            data = val;
            next = null;
        }
    }

    LinkedList() {
        head = null;
    }

    public void insertAtBegining(T val) {
        Node newnode = new Node(val);
        if (head == null) {
            head = newnode;
        } else {
            newnode.next = head;
            head = newnode;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void insertAtPos(int pos, T val) {
        if (pos == 0) {
            insertAtBegining(val);
            return;
        }
        Node newnode = new Node(val);
        Node temp = head;
        for (int i = 1; i < pos; i++) {
            temp = temp.next;
            if (temp == null) {
                // it is a naive approach
                // System.out.println("Invalid Position");
                // return;
                throw new IndexOutOfBoundsException("Invalid Pos " + pos);
            }
        }
        newnode.next = temp.next;
        temp.next = newnode;
    }

    public void deleteAtPos(int pos) {
        if (head == null) {
            throw new IndexOutOfBoundsException("Deletion attempted on empty List ");
        }
        if (pos == 0) {
            deleteAtBeginning();
            return;
        }

        Node temp = head;
        Node prev = null;

        for (int i = 1; i <= pos; i++) {
            prev = temp;
            temp = temp.next;
            if (temp == null) {
                throw new IndexOutOfBoundsException("Invalid Pos " + pos);
            }
        }
        prev.next = temp.next;
    }

    public void deleteAtBeginning() {
        if (head == null) {
            throw new IndexOutOfBoundsException("Deletion attempted on empty List ");
        }
        head = head.next;
    }

    public void display(int pos) {
        Node temp = head;
        if (temp == null) {
            throw new IndexOutOfBoundsException("The list is empty no item to display ");
        }

        for (int i = 1; i < pos; i++) {
            temp = temp.next;
        }
        System.out.println(temp.data + " ");

    }

    // @Override
    public Iterator<T> iterator() {
      return new Iterator<T>(){
        Node temp=head;
        public boolean hasNext(){
            return temp!=null;
        }
        public T next(){
             T val=temp.data;
             temp=temp.next;
             return val;
        }
      };
    }

}

public class Demo1 {
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<Integer>();
        l1.insertAtBegining(1);
        l1.insertAtBegining(2);
        l1.insertAtBegining(3);
        l1.display();

        // LinkedList<String> l1 = new LinkedList<>();
        // l1.insertAtBegining("ashik");
        // l1.insertAtBegining("arun");
        // l1.insertAtBegining("harish");
        // l1.display();
        // l1.insertAtPos(3, "Gokul");
        // l1.display();
        
        // ! suppose the list is empty we get exception NullPointerException
        // l1.deleteAtPos(0);
        // l1.display();

        // ! get(pos) -done
        // l1.display(0);

        // for (String a : l1) {
        //     System.out.println(a);
        // }

        Iterator<Integer> l2=l1.iterator();
        // Iterator<String> l2=l1.iterator();
        while(l2.hasNext()){
            System.out.print(l2.next()+" ");
        }
    }
}