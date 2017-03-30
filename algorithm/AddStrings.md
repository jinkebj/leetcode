# Add Strings

Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

  - The length of both num1 and num2 is < 5100.
  - Both num1 and num2 contains only digits 0-9.
  - Both num1 and num2 does not contain any leading zero.
  - You must not use any built-in BigInteger library or convert the inputs to integer directly.

**Java:**
```java
public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder ret = new StringBuilder();

        int i = num1.length();
        int j = num2.length();
        int carry = 0;
        char[] num1Chars = num1.toCharArray();
        char[] num2Chars = num2.toCharArray();

        while (i > 0 || j > 0 || carry == 1) {
            int a = (i > 0 ? (num1Chars[--i] - '0') : 0);
            int b = (j > 0 ? (num2Chars[--j] - '0') : 0);
            int sum = a + b + carry;

            ret.insert(0, sum % 10);
            carry = sum / 10;
        }

        return ret.toString();
    }
}
```
