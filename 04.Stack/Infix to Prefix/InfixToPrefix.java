import java.util.Stack;

public class InfixToPrefix {

    public static void main(String[] args) {
        // String infix = "K+L-M*N+(O^P)*W/U/V*T+Q";
        // String infix = "A+B*C";
        String infix = "A+(B*C-(D/E^F)*G)*H";
        System.out.println("Infix Expression: " + infix);
        System.out.println("Prefix Expression: " + infixToPrefix(infix));
    }

    public static String infixToPrefix(String infix) {
      
        String reversedString = reverse(infix);
        // System.out.println(reversedString);


        String postfix = infixToPostfix(reversedString);

        String prefix = reverse(postfix);

        return prefix;
    }

    
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

    public static String infixToPostfix(String infix) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < infix.length(); i++) {
            char current = infix.charAt(i);

           
            if (Character.isLetterOrDigit(current)) {
                result.append(current);
            }

            else if (current == ')') {
                stack.push(current);
            }
            // If the character is ')', pop and append until '(' is found
            else if (current == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == ')') {
                    stack.pop(); // Remove '('
                }
            }

            else {
                while (!stack.isEmpty() && precedence(stack.peek()) >precedence(current)) {
                    result.append(stack.pop()); 
                }

                if(!stack.isEmpty() && (precedence(stack.peek()) == precedence(current) && isLeftAssociative(current)) ) {
                    stack.push(current);
                }
                else{
                    stack .push(current);
                }

            }
            System.out.println(stack);
        }

        // Pop all remaining operators from the stack
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
    public static boolean isLeftAssociative(char c)
    {
        return c != '^'; 
    }

    // Reverse a string and swap parentheses
    public static String reverse(String infix) {
        StringBuilder sb = new StringBuilder(infix);
        return sb.reverse().toString();
    }
}


        // Q+T*V/U/W*)P^O(+N*M-L+K
        // + + - + K L * M N * / / * ^ O P W U V T Q
