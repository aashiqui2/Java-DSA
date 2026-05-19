# Infix to PostFix Conversion
1.Print operands as they arrive
2.If stack is empty or contains a left paranthesis on top, push the incoming operator on to the stack
3.If incoming symbol is '(' push it onto stack
4.If incoming symbol is ')' pop the stack  & print the operator until left paranthesis is found.
5.If the incoming symbol has higher precedence then the top of the stack,push it on to the stack
6.If incoming symbol has lower precedence then the top of the stack, pop & print the top. then test the incoming oerator against the new top of the  stack.
7.If incoming operator has equal precedence  with th e top of the stack, use associativity rule.
   associativity: L to R then pop & print the top of the stack & the push the incoming operator.
                   R to L then push the incoming operator
8.At the end of the expression ,pop & print all the oprtator of stack. 

K+L-M*N+(O^P)*W/U/V*T+Q

KL+MN*-OP^W*U/V/T*+Q+