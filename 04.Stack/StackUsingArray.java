public class StackUsingArray {
    int[] stack;
    int size;
    int top;

    StackUsingArray(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        stack[++top] = data;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("stack is underflow");
            return -1;
        }
        return stack[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("stack is underflow");
            return -1;
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Nothing to display");
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
    }

    public void update(int pos, int data) {
        if (isEmpty()) {
            System.out.println("stack is underflow");
            return;
        }
        if (pos < 0 || pos > top) {
            System.out.println("position out of bounds");
            return;
        }
        stack[pos] = data;
    }

    public static void main(String[] args) {
        StackUsingArray s = new StackUsingArray(5);
        s.push(5);
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);
        int popedElement = s.pop();
        System.out.println("popedElement " + popedElement);
        int ToppestElement = s.pop();
        System.out.println("ToppestElement " + ToppestElement);
        s.display();
        s.update(0, 8);
        System.out.println("\nAfter update");
        s.display();
    }

}
