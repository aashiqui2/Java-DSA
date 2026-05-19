public class StackUsingLinkedList {
    Node top;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    StackUsingLinkedList() {
        top = null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1; // or throw an exception
        }
        int poppedData = top.data;
        top = top.next;
        return poppedData;
    }

    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1; // or throw an exception
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void display() {
        if (top == null) {
            System.out.println("Stack is empty");
            return;
        }
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void update(int pos, int val) {
        if (pos < 0 || pos >= count()) {
            System.out.println("Invalid position");
            return;
        }

        Node temp = top;
        for (int i = 0; i < pos; i++) {
            temp = temp.next;
        }
        System.out.println("Updating position " + pos + " from " + temp.data + " to " + val);
        temp.data = val;
    }
    public int count()
    {
        int count=0;
        Node temp=top;
        while(temp!=null)
        {
            count++;
            temp=temp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();

        System.out.println("Top element is: " + stack.peek());

        System.out.println("Popped element is: " + stack.pop());

        stack.display();

        System.out.println("Stack is empty: " + stack.isEmpty());
        System.out.println("No of Nodes are "+stack.count());
    }
}
