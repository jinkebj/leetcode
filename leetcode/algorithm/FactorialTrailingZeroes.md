# Factorial Trailing Zeroes

Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

**Analysis:**
```
Because from 1 to n, the number of 2 factors is always bigger than the number of 5 factors. So we only need to find the number of 5 factors among 1...n.

1st loop: 5, 10, 15, 20, 25, 30, ....

2nd loop: 25 50 ......
```

**Java:**
```java
public class Solution {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
```
