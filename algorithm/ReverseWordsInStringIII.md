# Reverse Words in a String III

Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:

    Input: "Let's take LeetCode contest"
    Output: "s'teL ekat edoCteeL tsetnoc"

Note: In the string, each word is separated by single space and there will not be any extra space in the string.

**Java:**
```java
public class Solution {
    public String reverseWords(String s) {
        char[] sChars = s.toCharArray();
        int i = 0;
        int j = 0;

        while (j < sChars.length) {
            while (j < sChars.length && (j <= i || sChars[j] != ' ')) j++;
            reverseChars(sChars, i, j);
            i = j + 1;
        }

        return new String(sChars);
    }

    private void reverseChars(char[] sChars, int i, int j) {
        if (j >= sChars.length) j = sChars.length - 1;
        if (sChars[j] == ' ') j--;

        while (i < j) {
            char tmp = sChars[i];
            sChars[i++] = sChars[j];
            sChars[j--] = tmp;
        }
    }
}
```
