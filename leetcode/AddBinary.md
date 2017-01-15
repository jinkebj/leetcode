# Add Binary

Given two binary strings, return their sum (also a binary string).

    For example:

    a = "11"
    b = "1"
    Return "100".

**Java:**
```java
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ret = new StringBuilder();
        int ia = a.length();
        int ib = b.length();
        int carry = 0;

        for (int ma = ia - 1, mb = ib - 1; ma >= 0 || mb >= 0; ma--, mb--) {
            int na = ma < 0 ? 0 : a.charAt(ma) - '0';
            int nb = mb < 0 ? 0 : b.charAt(mb) - '0';
            int val = (na + nb + carry) % 2;
            carry = (na + nb + carry) / 2;
            ret.insert(0, val);
        }
        if (carry == 1) ret.insert(0, 1);

        return ret.toString();
    }
}
```
