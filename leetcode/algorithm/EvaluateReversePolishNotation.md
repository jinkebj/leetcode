# Evaluate Reverse Polish Notation

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /.
Each operand may be an integer or another expression.

Some examples:

     ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
     ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

**Java:**
```java
public class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String s : tokens) {
            if (s.equals("+")) stack.push(stack.pop() + stack.pop());
            else if (s.equals("-")) stack.push(-stack.pop() + stack.pop());
            else if (s.equals("*")) stack.push(stack.pop() * stack.pop());
            else if (s.equals("/")) {
                int tmp = stack.pop();
                stack.push(stack.pop() / tmp);
            } else stack.push(Integer.valueOf(s));
        }

        return stack.peek();
    }
}
```
