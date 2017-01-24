# Decode Ways

A message containing letters from A-Z is being encoded to numbers using the following mapping:

    'A' -> 1
    'B' -> 2
    ...
    'Z' -> 26

Given an encoded message containing digits, determine the total number of ways to decode it.

For example,

    Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

    The number of ways decoding "12" is 2.

**Analysis:**

- use an array of size n + 1 to save subproblem solutions.
- memo[n] means an empty string will have one way to decode
- memo[n - 1] means the way to decode a string of size 1.
- if two digit combination < 26, memo[i] = memo[i + 1] + memo[i + 2], otherwise, memo[i] = memo[i + 1]
- in the end, memo[0] will be the final result.

**Java:**
```java
public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] memo = new int[n + 1];
        memo[n] = 1;
        memo[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;

        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;

            if (Integer.parseInt(s.substring(i, i + 2)) <= 26) {
                memo[i] = memo[i + 1] + memo[i + 2];
            } else {
                memo[i] = memo[i + 1];
            }
        }

        return memo[0];
    }
}
```

**C++:**
```c++
class Solution {
public:
    int numDecodings(string s) {
        if (s.empty() || s[0] == '0') return 0;

        int prev = 0;
        int cur = 1;

        for (int i = 1; i <= s.size(); ++i) {
            if (s[i - 1] == '0') cur = 0;
            if (i < 2 || !(s[i - 2] == '1' ||
                (s[i - 2] == '2' && s[i - 1] <= '6')))
            {
                prev = 0;
            }
            int tmp = cur;
            cur = cur + prev;
            prev = tmp;
        }
        return cur;
    }
};
```
