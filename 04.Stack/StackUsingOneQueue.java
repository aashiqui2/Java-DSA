import java.util.LinkedList;
import java.util.Queue;

public class StackUsingOneQueue {
    Queue<Integer> q1 = new LinkedList<>();

    public void push(int x) {
        int size = q1.size();
        q1.add(x);

        for (int i = 0; i < size; i++) {
            q1.add(q1.remove());
        }
    }

    public int pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1; // Or throw an exception
        }
        return q1.remove();
    }

    public int peek() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1; // Or throw an exception
        }
        return q1.peek();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    // New method to display all elements in the stack
    public void display() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Elements in the stack: " + q1);
    }

    // New method to update an element at a specific position (0-based index)
    public void update(int index, int newValue) {
        if (index < 0 || index >= q1.size()) {
            System.out.println("Invalid index");
            return;
        }

        // Moving all elements to the end of the queue to bring the target element to the front
        for (int i = 0; i < index; i++) {
            q1.add(q1.remove());
        }

        // Remove the target element
        q1.remove();

        // Insert the new value at the front
        q1.add(newValue);

        // Restore the queue to its original order
        for (int i = 0; i < q1.size() - index - 1; i++) {
            q1.add(q1.remove());
        }
    }

    public static void main(String[] args) {
        StackUsingOneQueue stack = new StackUsingOneQueue();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Top element is: " + stack.peek());
        System.out.println("Popped element is: " + stack.pop());
        System.out.println("Top element is: " + stack.peek());
        stack.push(40);
        System.out.println("Top element is: " + stack.peek());
        stack.display();
        stack.update(1, 50); 
        stack.display();
    }
}
