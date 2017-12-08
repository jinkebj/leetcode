# Largest Palindrome Product

Find the largest palindrome made from the product of two n-digit numbers.

Since the result could be very large, you should return the largest palindrome mod 1337.

Example:

    Input: 2

    Output: 987

    Explanation: 99 x 91 = 9009, 9009 % 1337 = 987

Note:

- The range of n is [1,8].

**Java:**
```java
class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) return 9;

        int max = (int)Math.pow(10, n) - 1;
        for (int v = max - 1; v > max / 10; v--) {
            long u = Long.valueOf(v + new StringBuilder().append(v).reverse().toString());
            for (long x = max; x * x >= u; x--)
                if (u % x == 0) return (int)(u % 1337);
        }

        return 0;
    }
}
```
