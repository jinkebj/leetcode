# Basic Calculator

Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:

    "1 + 1" = 2
    " 2-1 + 2 " = 3
    "(1+(4+5+2)-3)+(6+8)" = 23

Note: Do not use the eval built-in library function.

**Analysis**

As the input is valid, only 5 possible input we need to pay attention:

    digit: it should be one digit from the current number
    '+': number is over, we can add the previous number and start a new number
    '-': same as above
    '(': push the previous result and the sign into the stack, set result to 0, just calculate the new result within the parenthesis.
    ')': pop out the top two numbers from stack, first one is the sign before this pair of parenthesis, second is the temporary result before this pair of parenthesis. We add them together.

Finally if there is only one number, need to add it to result.

**Java:**
```java
public class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        int number = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = 10 * number + (int)(c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result); // push result first, then sign
                stack.push(sign);
                sign = 1; // reset sign and result
                result = 0;
            } else if (c == ')') {
                result += sign * number;  
                number = 0;
                result *= stack.pop(); // get the sign before the parenthesis
                result += stack.pop(); // get the result calculated before the parenthesis
            }
        }

        if (number != 0) result += sign * number;
        return result;
    }
}
```
