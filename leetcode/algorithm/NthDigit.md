# Nth Digit

Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

Note:

    n is positive and will fit within the range of a 32-bit signed integer (n < 231).

Example 1:

    Input:
    3

    Output:
    3

Example 2:

    Input:
    11

    Output:
    0

Explanation:

    The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.

**Analysis:**
```
The result sequence should be like:

1~9: 1*9=9 in total
10~99: 2*90=180 in total
100~999: 3*900=2700 in total
...
k * 9 * 10^k (k is digit length)

Straight forward way to solve the problem in 3 steps:

  1. find the length of the number where the nth digit is from
  2. find the actual number where the nth digit is from
  3. find the nth digit and return

For input 12345, we have 9+180+2700<12345<9+180+2700+36000, so the corresponding number range is 1000~9999.

12345-1-9-180-2700=9455
So we need to find the 9455th digit in 1000~9999.

1000 1001 1002 1003 ....

1000+9455/4=3363, 9455%4=3, the digit should come from the index 3 of 3363, so the result should be 3.
For 12346: 3, for 12347: 3, for 12348: 6, for 12349: 4

336(12345 start from the next 3)3

(12346)3(12347)3(12348)6(12349)4
```

**Java:**
```java
public class Solution {
    public int findNthDigit(int n) {
        int digit = 1;
        int start = 1;
        n -= 1;

        while (n / 9 / digit / start >= 1) {
            n -= 9 * digit * start;
            digit++;
            start *= 10;
        }

        return (start + n / digit + "").charAt(n % digit) - '0';
    }
}
```
