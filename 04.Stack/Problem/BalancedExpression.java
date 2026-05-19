import java.util.Stack;
public class BalancedExpression {
    static Stack<Character> stack = new Stack<>();

    static void push(char c) {
        stack.push(c);
    }

    static void pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            stack.pop();
        }
    }

    static boolean isMatchingPair(char openb, char closeb) {
        return (openb == '{' && closeb == '}') ||
               (openb == '[' && closeb == ']') ||
               (openb == '(' && closeb == ')');
    }

    public static void main(String[] args) {
        char[] c = {'{', '[', '(', ')', '[', ']', ']', '}'};
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '{' || c[i] == '(' || c[i] == '[') {
                push(c[i]);
            } else if (c[i] == '}' || c[i] == ')' || c[i] == ']') {
                if (stack.isEmpty()) {
                    System.out.println("Not closed properly");
                    return;
                }
                char topChar = stack.peek();
                if (isMatchingPair(topChar, c[i])) {
                    pop(); 
                }
            }
        }
        
        if (stack.isEmpty()) {
            System.out.println("Closed properly");
        } else {
            System.out.println("Not Closed properly");
        }
    }
}