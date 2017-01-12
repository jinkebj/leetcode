# Reverse Integer

Reverse digits of an integer.

    Example1: x = 123, return 321
    Example2: x = -123, return -321

Have you thought about this?

Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

    If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

    Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

    Throw an exception? Good, but what if throwing an exception is not an option? You would then have to re-design the function (ie, add an extra parameter).

**Java:**
```java
public class Solution {
    public int reverse(int x) {
        long r = 0;
        for (; x != 0; x /= 10)
            r = r * 10 + x % 10;

        int s;
        if (r > Integer.MAX_VALUE) s = Integer.MAX_VALUE;
        else if (r < Integer.MIN_VALUE) s = Integer.MIN_VALUE;
        else s = (int)r;

        return s;
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
        if (r > INT_MAX) s = INT_MAX;
        else if (r < INT_MIN) s = INT_MIN;
        else s = (int)r;

        return s;
    }
};
```
