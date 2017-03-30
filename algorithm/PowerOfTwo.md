# Power of Two

Given an integer, write a function to determine if it is a power of two.

**Java:**
```java
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;

        while (n % 2 == 0) n /= 2;
        return (n == 1);
    }
}
```

**Java:**
```java
public class Solution {
    public boolean isPowerOfTwo(int n) {
        // a power of two in binary form has and only has one "1"
        return (n > 0 && Integer.bitCount(n) == 1 );
    }
}
```

**Java:**
```java
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return (n > 0 && (n & (n - 1)) == 0 );
    }
}
```
