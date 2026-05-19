import java.util.Stack;
public class QueueUsingStacks {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int item) {
        stack1.push(item);
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        for (int i = stack2.size() - 1; i >= 0; i--) {
            System.out.print(stack2.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.print("Queue: ");
        queue.display();

        System.out.println("Dequeued item: " + queue.dequeue());
        System.out.print("Queue after dequeue: ");
        queue.display();

        System.out.println("Front item: " + queue.peek());
    }
}


































// import java.util.Stack;

// public class QueueUsingStack {
//     static class Queue {
//         // Two stacks to implement the queue
//         Stack<Integer> s1 = new Stack<>();
//         Stack<Integer> s2 = new Stack<>();

//         // Check if the queue is empty
//         public boolean isEmpty() {
//             return s1.isEmpty() && s2.isEmpty();
//         }

//         // Add an element to the queue
//         public void add(int data) {
//             s1.push(data);
//         }

//         // Remove an element from the queue
//         public int remove() { 
//             if (s2.isEmpty()) {
//                 while (!s1.isEmpty()) {
//                     s2.push(s1.pop());
//                 }
//             }
//             if (s2.isEmpty()) {
//                 System.out.println("Queue is empty");
//                 return -1; // Or throw an exception
//             }
//             return s2.pop();
//         }

//         // Get the front element of the queue
//         public int peek() {
//             if (s2.isEmpty()) {
//                 while (!s1.isEmpty()) {
//                     s2.push(s1.pop());
//                 }
//             }
//             if (s2.isEmpty()) {
//                 System.out.println("Queue is empty");
//                 return -1; // Or throw an exception
//             }
//             return s2.peek();
//         }
//     }

//     public static void main(String[] args) {
//         Queue q = new Queue();
//         q.add(1);
//         q.add(2);
//         q.add(3);
//         q.add(4);
//         q.add(5);
        

//         while (!q.isEmpty()) {
//             System.out.println(q.peek());
//             q.remove();
//         }
//         q.remove();
//     }
// }
