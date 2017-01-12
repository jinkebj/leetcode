# Number Complement

Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

Note:

    The given integer is guaranteed to fit within the range of a 32-bit signed integer.
    You could assume no leading zero bit in the integer’s binary representation.

Example 1:

    Input: 5
    Output: 2
    Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.

Example 2:

    Input: 1
    Output: 0
    Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.

**Analysis:**
```
The key point is: we need to find the leading zero count of num and create the mask based on it.
```

**Java:**
```java
public class Solution {
    public int findComplement(int num) {
        int num2 = ~num;

        int mask = 1;
        for (int i = 0; i < 31; i++) {
            if (num != 1) {
                mask = (mask << 1) + 1;
                num >>>= 1;
            }
        }

        return num2 & mask;
    }
}
```

**Java:**
```java
public class Solution {
    public int findComplement(int num) {
        int leadingZeroCount = Integer.numberOfLeadingZeros(num);
        int mask = 1;
        for (int i = 0; i < 31 - leadingZeroCount; i++) mask = (mask << 1) + 1;
        return ~num & mask;
    }
}
```

**Java:**
```java
public class Solution {
    public int findComplement(int num) {
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        return ~num & mask;
    }
}
```
