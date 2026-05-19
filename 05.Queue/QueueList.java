public class QueueList {
    private Node front, rear;

    class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
    }

    public QueueList() {
        front = rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(int item) {
        Node newNode = new Node(item);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    public int dequeue() {
        if (front == null) {
            throw new RuntimeException("Dequeue from empty queue");
        }

        Node temp = front;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return temp.data;
    }

    public int peek() {
        if (front == null) {
            throw new RuntimeException("Peek from empty queue");
        }
        return front.data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int count() {
        int count = 0;
        Node temp = front;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        QueueList q = new QueueList();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.print("Queue: ");
        q.display();

        System.out.println("Dequeued item: " + q.dequeue());
        System.out.print("Queue after dequeue: ");
        q.display();

        System.out.println("Front item: " + q.peek());
    }
}
