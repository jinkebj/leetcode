# Reverse Integer

Reverse digits of an integer.

    Example1: x = 123, return 321
    Example2: x = -123, return -321

Have you thought about this?

Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

    If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

    Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

    For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

**Java:**
```java
public class Solution {
    public int reverse(int x) {
        long r = 0;
        for (int i = x; i != 0; i /= 10) {
            r = r * 10 + i % 10;
        }

        int ret;
        if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) ret = 0;
        else ret = (int)r;

        return ret;
    }
}
```

**C++:**
```c++
class Solution {
public:
    int reverse(int x) {
        long r = 0;
        for (; x != 0; x /= 10)
            r = r * 10 + x % 10;

        int s;
        if (r > INT_MAX) s = 0;
        else if (r < INT_MIN) s = 0;
        else s = (int)r;

        return s;
    }
};
```
