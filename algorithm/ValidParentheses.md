# Valid Parentheses

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

**Java:**
```java
public class Solution {
    public boolean isValid(String s) {
        if (s == null) return false;
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') stack.push(s.charAt(i));
            else if (s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') stack.pop();
            else if (s.charAt(i) == ']' && !stack.isEmpty() && stack.peek() == '[') stack.pop();
            else if (s.charAt(i) == '}' && !stack.isEmpty() && stack.peek() == '{') stack.pop();
            else return false;
        }

        return stack.isEmpty();
    }
}
```

**C++:**
```c++
class Solution {
public:
    bool isValid(string s) {
        string left = "({[";
        string right = ")}]";
        stack<char> stk;

        for (auto c : s) {
            if (left.find(c) != string::npos) {
                stk.push(c);
            } else if (stk.empty() || stk.top() != left[right.find(c)]) {
                return false;
            } else {
                stk.pop();
            }
        }
        return stk.empty();
    }
};
```
