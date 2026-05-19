import java.util.Stack;

public class PrefixToInfix {

    public static void main(String[] args) {
        // Example prefix expression
        String prefix = "+ + - + K L * M N * / / * ^ O P W U V T Q";
        System.out.println("Prefix Expression: " + prefix);
        System.out.println("Infix Expression: " + prefixToInfix(prefix));
    }

    public static String prefixToInfix(String prefix) {
        Stack<String> stack = new Stack<>();

        // Scan the prefix expression from right to left
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char current = prefix.charAt(i);

            // If the character is an operand (alphabet or digit), push it to the stack
            if (Character.isLetterOrDigit(current)) {
                stack.push(String.valueOf(current));
            }
            // If the character is an operator, pop two operands and combine them
            else if (isOperator(current)) {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String expression = "(" + operand1 + current + operand2 + ")";
                stack.push(expression); // Push the new expression back to stack
            }
        }

        // The final element in the stack is the infix expression
        return stack.pop();
    }

    // Function to check if a character is an operator
    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }
}
