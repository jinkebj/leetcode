# Reverse String

Write a function that takes a string as input and returns the string reversed.

    Example:
    Given s = "hello", return "olleh".

**Java:**
```java
public class Solution {
    public String reverseString(String s) {
        char[] charArray = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            char tmp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = tmp;
            i++;
            j--;
        }

        return new String(charArray);
    }
}
```
