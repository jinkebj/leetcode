# Convert a Number to Hexadecimal

Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.

Note:

- All letters in hexadecimal (a-f) must be in lowercase.
- The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
- The given number is guaranteed to fit within the range of a 32-bit signed integer.
 You must not use any method provided by the library which converts/formats the number to hex directly.

Example 1:

    Input:
    26

    Output:
    "1a"

Example 2:

    Input:
    -1

    Output:
    "ffffffff"


**Analysis:**
```
Solution 1: To deal with negative number, the number is masked against
            long data type.
            This process will convert it to a positive long number.

Solution 2: each time we take a look at the last four digits of
            binary verion of the input, and maps that to a hex char
            shift the input to the right by 4 bits, do it again
            until input becomes 0.
```

**Java: (Solution 1)**
```java
public class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";
        long n = num & 0x00000000ffffffffL;

        StringBuilder ret = new StringBuilder();

        while (n > 0) {
            int c = (int)(n % 16);

            if (c < 10) ret.insert(0, c);
            else ret.insert(0, (char)('a' + c - 10));

            n /= 16;
        };

        return ret.toString();
    }
}
```

**Java: (Solution 2)**
```java
public class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";

        StringBuilder ret = new StringBuilder();

        while (num != 0) {
            int c = num & 15;

            if (c < 10) ret.insert(0, c);
            else ret.insert(0, (char)('a' + c - 10));

            num >>>= 4;
        };

        return ret.toString();
    }
}
```
