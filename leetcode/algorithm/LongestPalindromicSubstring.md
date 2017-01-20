# Longest Palindromic Substring

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

    Input: "babad"
    Output: "bab"
    Note: "aba" is also a valid answer.

Example:

    Input: "cbbd"
    Output: "bb"

**Analysis:**
```
Example: "xxxbcbxxxxxa", (x is random character, not all x are equal) now we
          are dealing with the last character 'a'. The current longest palindrome
          is "bcb" with length 3.
1. check "xxxxa" so if it is palindrome we could get a new palindrome of length 5.
2. check "xxxa" so if it is palindrome we could get a new palindrome of length 4.
3. do NOT check "xxa" or any shorter string since the length of the new string is
   no bigger than current longest length.
4. do NOT check "xxxxxa" or any longer string because if "xxxxxa" is palindrome
   then "xxxx" got  from cutting off the head and tail is also palindrom. It has
   length > 3 which is impossible.'
```

**Java:**
```java
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null) return null;
        String ret = "";
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i - maxLen - 1, i)) {
                ret = s.substring(i - maxLen - 1, i + 1);
                maxLen += 2;
            } else if (isPalindrome(s, i - maxLen, i)) {
                ret = s.substring(i - maxLen, i + 1);
                maxLen += 1;
            }
        }

        return ret;
    }

    private boolean isPalindrome(String s, int start, int end) {
        if (start < 0) return false;

        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }

        return true;
    }
}
```
