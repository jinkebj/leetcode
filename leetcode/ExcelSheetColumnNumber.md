# Excel Sheet Column Number

Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28

**Java:**
```java
public class Solution {
    public int titleToNumber(String s) {
        int ret = 0;
        int factor = 1;
        char[] sChars = s.toCharArray();

        for (int i = sChars.length - 1; i >= 0; i--) {
            ret += (sChars[i] - 'A' + 1 ) * factor;
            factor *= 26;
        }

        return ret;
    }
}
```

**Java:**
```java
public class Solution {
    public int titleToNumber(String s) {
        int ret = 0;

        for (int i = 0; i < s.length(); i++) {
            ret = ret * 26 + s.charAt(i) - 'A' + 1 ;
        }

        return ret;
    }
}
```
