# Complex Number Multiplication

Given two strings representing two complex numbers.

You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

Example 1:

    Input: "1+1i", "1+1i"
    Output: "0+2i"
    Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.

Example 2:

    Input: "1+-1i", "1+-1i"
    Output: "0+-2i"
    Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.

Note:

    The input strings will not have extra blank.
    The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.

**Analysis:**

    (a+bi) * (c+di) = (a * c - b * d)+(b * c + a * d)i

**Java:**
```java
class Solution {
    public String complexNumberMultiply(String a, String b) {
        String x[] = a.split("\\+|i");
        String y[] = b.split("\\+|i");
        int aReal = Integer.parseInt(x[0]);
        int aImg = Integer.parseInt(x[1]);
        int bReal = Integer.parseInt(y[0]);
        int bImg = Integer.parseInt(y[1]);
        return (aReal * bReal - aImg * bImg) + "+" + (aReal * bImg + aImg * bReal) + "i";
    }
}
```
