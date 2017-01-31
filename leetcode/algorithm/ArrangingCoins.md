# Arranging Coins

You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

    n = 5

    The coins can form the following rows:
    ¤
    ¤ ¤
    ¤ ¤

    Because the 3rd row is incomplete, we return 2.

Example 2:

    n = 8

    The coins can form the following rows:
    ¤
    ¤ ¤
    ¤ ¤ ¤
    ¤ ¤

    Because the 4th row is incomplete, we return 3.

**Analysis:**
```
It's Binary Search

The problem is basically asking the maximum length of consecutive number that has the running sum lesser or equal to n. In other word, find x that satisfy the following condition:

1 + 2 + 3 + 4 + 5 + 6 + 7 + ... + x <= n
sum_{i=1}^x i <= n

Running sum can be simplified,
(x * ( x + 1)) / 2 <= n

Binary search is used in this case to slowly narrow down the x that will satisfy the equation. Note that 0.5 * mid * mid + 0.5 * mid does not have overflow issue as the intermediate result is implicitly autoboxed to double data type.
```

**Java:**
```java
public class Solution {
    public int arrangeCoins(int n) {
        int start = 0;
        int end = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((0.5 * mid + 0.5 * mid * mid) <= n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start - 1;
    }
}
```
