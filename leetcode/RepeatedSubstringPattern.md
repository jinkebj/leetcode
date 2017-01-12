# Repeated Substring Pattern

Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

Example 1:

    Input: "abab"

    Output: True

    Explanation: It's the substring "ab" twice.

Example 2:

    Input: "aba"

    Output: False

Example 3:

    Input: "abcabcabcabc"

    Output: True

    Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)

**Analysis:**
```
这个问题是要看整个字符串是不是由某个字符串组成的（字符串本身不算）。

如果一个字符串是由某个子字符串组成的，那么这个字符串的长度肯定是这个子字符串长度的倍数，也就是说子字符串长度是这个字符串长度的约数。

那好，有了以上的判断，那就是说如果一个字符串存在所谓的重复字符串模式（Repeated Substring Pattern，简称RSP）的话，那么RSP的可能长度的数目与这个字符串约数的数目是相同的。

而且还有一个特点：RSP肯定是这个字符串的前缀。
```

**Java:**
```java
public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        int len = str.length();
        List<Integer> subStrLenList = new ArrayList<Integer>();

        // get all possible length of sub string
        for (int i = 1; i < len; i++) {
            if (len % i == 0) subStrLenList.add(i);
        }

        // try every possible sub string
        for (int i : subStrLenList) {
            String subStr = str.substring(0, i);
            boolean matchFlag = true;

            for (int k = 0; k < len / i; k++) {
                if (!subStr.equals(str.substring(k * i, k * i + i))) {
                    matchFlag = false;
                    break;
                }
            }

            if (matchFlag) return true;
        }

        return false;
    }
}
```
