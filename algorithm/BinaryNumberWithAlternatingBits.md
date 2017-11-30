# Binary Number with Alternating Bits
Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.

Example 1:

    Input: 5
    Output: True
    Explanation:
    The binary representation of 5 is: 101

Example 2:

    Input: 7
    Output: False
    Explanation:
    The binary representation of 7 is: 111.

Example 3:

    Input: 11
    Output: False
    Explanation:
    The binary representation of 11 is: 1011.

Example 4:

    Input: 10
    Output: True
    Explanation:
    The binary representation of 10 is: 1010.

**Java:**
```java
class Solution {
    public boolean hasAlternatingBits(int n) {
        int b = n & 1;
        n >>= 1;

        while (n > 0) {
            if ((n & 1 ^ b) != 1) return false;
            b = n & 1;
            n >>= 1;
        }

        return true;
    }
}
```

**Analysis:**

If n has alternating bits, then (n>>1) + n must be like 111...11.

Now, let's consider the case when n does not have alternating bits, that is, n has at least one subsequence with continuous 1 or 0 (we assume n has continuous 1 in the after) . We write n in its binary format as xxx011...110xxx, where xxx0 and 0xxx could be empty. Denote A as xxx0, B as 11...11 and C as 0xxx, n then can be expressed as ABC. We can observe that,

    If the leftmost bit of C + C>>1 is 1, then the leftmost two bits of C+(1C)>>1 is 10. E.g., if C = 011, then C + (1C)>>1 = 011 + 101 = 1000. So n + (n>>1) will have a bit with 0.
    If the leftmost bit of C + C>>1 is 0, then the leftmost two bits of 1C+(11C)>>1 is also 10. E.g., if C = 010, then 1C + (11C)>>1 = 1010 + 1101 = 10111. Note that B has a length of at least 2. So n + (n>>1) will also have a bit with 0.

Similar analysis can be done when n has continuous 0. Therefore, if n does not have alternating bits, then (n>>1) + n must Not be like 111...11.

At last, for solving this quesiton, we just need to check if (n>>1) + n + 1 is power of 2.

**Java:**
```java
class Solution {
    public boolean hasAlternatingBits(int n) {
        return (((long)n + (n >> 1) + 1) & ((long)n + (n >> 1))) == 0;
    }
}
```
