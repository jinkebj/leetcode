# Power of Four

Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?

**Java:**
```java
public class Solution {
    public boolean isPowerOfFour(int n) {
        if (n == 0) return false;

        while (n % 4 == 0) n /= 4;
        return (n == 1);
    }
}
```

```java
public class Solution {
    public boolean isPowerOfFour(int n) {
        // 0x55555555 is to get rid of those power of 2 but not power of 4
        // so that the single 1 bit always appears at the odd position
        return (n > 0) && ((n & (n - 1)) == 0) && ((n & 0x55555555) == n);
    }
}```
