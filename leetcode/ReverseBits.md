# Reverse Bits

Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?

Related problem: Reverse Integer

**Analysis:**
```
Read input integer bit from right to left and push the bit to another integer from left to right
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
            if ((n & 1) == 1) ret++;
            n >>= 1;
        }

        return ret;
    }
}
```
