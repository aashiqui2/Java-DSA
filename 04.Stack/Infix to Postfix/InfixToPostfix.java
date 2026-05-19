import java.util.Stack;

public class InfixToPostfix {

    // Function to get precedence of operators
    public static int precedence(char c) {
        if (c == '+' || c == '-') {
            return 1;
        } else if (c == '*' || c == '/') {
            return 2;
        } else if (c == '^') {
            return 3;
        }
        return -1;
    }

    // Function to check if the character is an operand
    public static boolean isOperand(char c) {
        return Character.isLetterOrDigit(c);
    }

    // Function to convert Infix to Postfix
    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < infix.length(); i++) {
            char current = infix.charAt(i);
            
            if (isOperand(current)) {
                postfix.append(current);  // Add operand to the result
            } else if (current == '(') {
                stack.push(current);  // Push '(' to stack
            } else if (current == ')') {
                // Pop from stack to result until '(' is found
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // Remove '('
                }
            } else {
                // Operator encountered
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(current)) {
                    postfix.append(stack.pop());  // Pop higher precedence operators to result
                }
                stack.push(current);  // Push the current operator to stack
            }
        }
        
        // Pop remaining operators from the stack
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static void main(String[] args) {
        // String infix = "a+b*(c^d-e)^(f+g*h)-i";
        String infix = "K+L-M*N+(O^P)*W/U/V*T+Q";
        System.out.println("Infix Expression: " + infix);
        System.out.println("Postfix Expression: " + infixToPostfix(infix));
    }
}
