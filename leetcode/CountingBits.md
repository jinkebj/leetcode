# Counting Bits

Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

  - It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
  - Space complexity should be O(n).
  - Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.

**Analysis:**
```
Solution 1:
  An easy recurrence for this problem is f[i] = f[i / 2] + i % 2.

Solution 2:
  This uses the hint from the description about using ranges. Basically, the numbers in one range are equal to 1 plus all of the numbers in the ranges before it. If you write out the binary numbers, you can see that numbers 8-15 have the same pattern as 0-7 but with a 1 at the front.

  The logic was to copy the previous values (starting at 0) until a power of 2 was hit (new range), at which point we just reset the t pointer back to 0 to begin the new range.
```

**Java: (Solution 1)**
```java
public class Solution {
    public int[] countBits(int num) {
        int[] ret = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            ret[i] = ret[i >> 1] + (i & 1);
        }

        return ret;
    }
}
```

**Java: (Solution 2)**

```java
public class Solution {
    public int[] countBits(int num) {
        int[] ret = new int[num + 1];

        for (int i = 1, t = 0; i <= num; i++, t++) {
            if ((i & (i - 1)) == 0) t = 0;
            ret[i] = ret[t] + 1;
        }

        return ret;
    }
}
```
