# Number of 1 Bits

Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.

**Java: (use system function)**
```java
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
```

**Java: (bit operation)**
```java
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ret = 0;

        // we cannot use n > 0 because the input 2147483648 would correspond to -2147483648 in java
        // and the code would not enter the while if the condition is n > 0 for n = 2147483648
        while (n != 0) {
            if ((n & 1) > 0) ret++;
            // need to use bit shifting unsigned operation >>> (while >> depends on sign extension)
            n >>>= 1;
        }

        return ret;
    }
}
```

**Java: (bit operation)**
```java
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ret = 0;

        while (n != 0) {
            ret++;
            n &= n - 1;
        }

        return ret;
    }
}
```
