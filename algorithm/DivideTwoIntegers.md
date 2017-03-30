# Divide Two Integers

Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.

**Java:**
```java
public class Solution {
    public int divide(int dividend, int divisor) {
        // cast to positive long to avoid integer overflow cases
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) sign = -1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        // take care the edge cases
        if (ldivisor == 0) return Integer.MAX_VALUE;
        if ((ldividend == 0) || (ldividend < ldivisor))  return 0;

        long lans = ldivide(ldividend, ldivisor);

        int ans;
        if (lans > Integer.MAX_VALUE) {
            ans = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int)(sign * lans);
        }

        return ans;
    }

    private long ldivide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) return 0;

        //  find the largest multiple so that (divisor * multiple <= dividend)
        //  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason
        //  think this as a binary search
        long sum = ldivisor;
        long multiple = 1;
        while ((sum + sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        // look for additional value for the multiple from the reminder (dividend - sum) recursively.
        return multiple + ldivide(ldividend - sum, ldivisor);
    }
}
```

**C++:**
```c++
class Solution {
public:
    int divide(int dividend, int divisor) {
        int result = 0;
        const bool sign = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);

        if (dividend == INT_MIN && divisor == -1) return INT_MAX;

        unsigned int a = dividend >= 0 ? dividend : -dividend;
        unsigned int b = divisor >= 0 ? divisor : -divisor;

        while (a >= b) {
            int multi = 1;
            unsigned int bb = b;
            while (a >= bb) {
                a -= bb;
                result += multi;

                if (bb < INT_MAX >> 1) {
                    bb += bb;
                    multi += multi;
                }
            }
        }

        if (sign) return -result;
        else return result;
    }
};
```
