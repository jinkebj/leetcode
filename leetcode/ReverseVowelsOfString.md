# Reverse Vowels of a String

Write a function that takes a string as input and reverse only the vowels of a string.

    Example 1:
    Given s = "hello", return "holle".

    Example 2:
    Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".

**Java:**
```java
public class Solution {
    public String reverseVowels(String s) {
        char[] charArray = s.toCharArray();
        int i = 0;
        int j = charArray.length - 1;

        while (i < j) {
            while (i < j && !isVowel(charArray[i])) i++;
            while (i < j && !isVowel(charArray[j])) j--;

            char tmp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = tmp;

            i++;
            j--;
        }

        return new String(charArray);
    }

    private boolean isVowel(char c) {
        return (c == 'a') || (c == 'e') || (c == 'i') || (c == 'o') || (c == 'u') || (c == 'A') || (c == 'E') || (c == 'I') || (c == 'O') || (c == 'U');
    }
}
```
