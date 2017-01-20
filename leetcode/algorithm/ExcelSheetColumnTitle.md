# Excel Sheet Column Title

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB

**Java:**
```java
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder ret = new StringBuilder();

        while (n > 0) {
            n--;
            ret.insert(0, (char)(n % 26 + 'A'));
            n /= 26;
        }

        return ret.toString();
    }
}
```
