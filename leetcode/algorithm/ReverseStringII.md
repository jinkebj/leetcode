# Reverse String II

Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.

Example:

    Input: s = "abcdefg", k = 2
    Output: "bacdfeg"

Restrictions:

    The string consists of lower English letters only.
    Length of the given string and k will in the range [1, 10000]


**Java:**
```java
public class Solution {
    public String reverseStr(String s, int k) {
        if (k == 0) return s;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i % (2 * k) == 0) {
                reverse(chars, i, i + k - 1);
                i += k - 1;
            }
        }

        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        if (end >= chars.length) end = chars.length - 1;

        while (start < end) {
            char tmp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = tmp;
        }
    }
}
```
