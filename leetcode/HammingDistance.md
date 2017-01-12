# Hamming Distance

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:

    0 ≤ x, y < 2^31^.

Example:

    Input: x = 1, y = 4

    Output: 2

Explanation:

    1   (0 0 0 1)
    4   (0 1 0 0)
           ↑   ↑

The above arrows point to positions where the corresponding bits are different.

**Java:**
```java
public class Solution {
    public int hammingDistance(int x, int y) {
        int ret = 0;
        int z = x ^ y;
        while (z != 0) {
            if ((z & 1) > 0) ret++;
            z >>>= 1;
        }
        return ret;
    }
}
```

**Java:**
```java
public class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
```
