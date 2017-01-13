# Reverse Bits

Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?

Related problem: Reverse Integer

**Analysis:**

Straightforward Solution:
```
Read input integer bit from right to left and push the bit to another integer from left to right.
```
Optimized Solution:
```
Refer to jdk's implementation of Integer.reverse

    1. 交换每两位
        i = (i & 0x55555555) << 1 | (i >>> 1) & 0x55555555;
    2. 交换每四位中的前两位和后两位
        i = (i & 0x33333333) << 2 | (i >>> 2) & 0x33333333;
    3. 交换每八位中的前四位和后四位
        i = (i & 0x0f0f0f0f) << 4 | (i >>> 4) & 0x0f0f0f0f;
    4. 交换相邻的两个字节然后交换前后两个双字节
        i = (i << 24) | ((i & 0xff00) << 8) | ((i >>> 8) & 0xff00) | (i >>> 24);
```

**Java:**
```java
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if (n == 0) return 0;

        int ret = 0;
        for (int i = 0; i < 32; i++) {
            ret <<= 1;
            ret += n & 1;
            n >>>= 1;
        }

        return ret;
    }
}
```

**Java:**
```java
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        return Integer.reverse(n);
    }
}
```

**Java:**
```java
public class Solution {
    // you need treat i as an unsigned value
    public int reverseBits(int i) {
        i = (i & 0x55555555) << 1 | (i >>> 1) & 0x55555555;
        i = (i & 0x33333333) << 2 | (i >>> 2) & 0x33333333;
        i = (i & 0x0f0f0f0f) << 4 | (i >>> 4) & 0x0f0f0f0f;
        i = (i << 24) | ((i & 0xff00) << 8) | ((i >>> 8) & 0xff00) | (i >>> 24);
        return i;
    }
}
```
