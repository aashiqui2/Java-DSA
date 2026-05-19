# Rules for Infix to Prefix Conversion:
1. Reverse the infix expression:
   - Replace `(` with `)` and `)` with `(`.
   - Reverse the entire string.

2. Follow similar steps as Infix to Postfix conversion:
   - **Operands**: Print operands as they arrive.
   - **Stack is empty or contains a right parenthesis** (`)`): Push the incoming operator onto the stack.
   - **Incoming symbol is a `)`**: Push it onto the stack.
   - **Incoming symbol is a `(`**: Pop the stack and print operators until a `)` is found.
   - **Precedence**:
     - If the incoming operator has **higher precedence** than the top of the stack, push it onto the stack.
     - If the incoming operator has **lower precedence**, pop and print the operator from the stack, then test the incoming operator against the new top of the stack.
   - **Equal precedence (Associativity)**:
     - If associativity is **left-to-right**, pop and print the top of the stack, then push the incoming operator.
     - If associativity is **right-to-left**, push the incoming operator onto the stack.

3. **End of the expression**: At the end of the reversed infix expression, pop and print all the operators from the stack.

4. **Reverse the final output**: After converting the reversed infix expression to postfix, reverse the result to get the final prefix expression.

---

# Key Points to Remember:
- Precedence: Operators with higher precedence bind more tightly. Common precedence order:
  1. Parentheses: `()`
  2. Exponentiation: `^` (right-to-left associativity)
  3. Multiplication/Division: `*`, `/` (left-to-right associativity)
  4. Addition/Subtraction: `+`, `-` (left-to-right associativity)
  
- Associativity: Determines the order of evaluation for operators with the same precedence.