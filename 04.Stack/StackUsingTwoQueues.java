import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void push(int x) {
        q1.add(x);
    }

    public int pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1; // Or throw an exception
        }

        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        int popped = q1.remove();

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return popped;
    }

    public int peek() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1; // Or throw an exception
        }

        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        int topElement = q1.remove();
        q2.add(topElement);

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return topElement;
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    // Method to display all elements in the stack
    public void display() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        System.out.println("Elements in the stack: " + q1);
    }

    // Method to update an element at a specific position (0-based index)
    public void update(int index, int newValue) {
        if (index < 0 || index >= q1.size()) {
            System.out.println("Invalid index");
            return;
        }

        // Move elements to q2, updating the element at the specified index
        for (int i = 0; i < q1.size(); i++) {
            int element = q1.remove();
            if (i == index) {
                q2.add(newValue);
            } else {
                q2.add(element);
            }
        }

        // Swap the queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public static void main(String[] args) {
        StackUsingTwoQueues stack = new StackUsingTwoQueues();
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
