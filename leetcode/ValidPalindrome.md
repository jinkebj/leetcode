# Valid Palindrome

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,

    "A man, a plan, a canal: Panama" is a palindrome.
    "race a car" is not a palindrome.

Note:

- Have you consider that the string might be empty? This is a good question to ask during an interview.
- For the purpose of this problem, we define empty string as valid palindrome.

**Java:**
```java
public class Solution {
    public boolean isPalindrome(String s) {
        String ns = s.toLowerCase();
        int i = 0;
        int j = ns.length() - 1;

        while (i < j) {
            if (!Character.isLetterOrDigit(ns.charAt(i))) i++;
            else if (!Character.isLetterOrDigit(ns.charAt(j))) j--;
            else if (ns.charAt(i) != ns.charAt(j)) return false;
            else {
                i++;
                j--;
            }
        }

        return true;
    }
}
```

**Java:**
```java
public class Solution {
    public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }
}
```

**C++:**
```c++
class Solution {
public:
    bool isPalindrome(string s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (!isalnum(s[i])) i++;
            else if (!isalnum(s[j])) j--;
            else if (tolower(s[i]) != tolower(s[j])) return false;
            else {
                i++;
                j--;
            }
        }

        return true;
    }
};
```
