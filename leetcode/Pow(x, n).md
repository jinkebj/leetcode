# Pow(x, n)

Implement pow(x, n).

**Java:**
```java
public class Solution {
    public double myPow(double x, int n) {
        if (n < 0) return 1.0 / myPower(x, n);
        else return myPower(x, n);
    }

    private double myPower(double x, int n) {
        if (n == 0) return 1;
        double v = myPower(x, n / 2);
        if (n % 2 == 0) return v * v;
        else return v * v * x;
    }
}
```

**Java:**
```java
public class Solution {
    public double myPow(double x, int n) {
        double ret = 1;
        long absN = Math.abs((long)n);
        while (absN > 0) {
            if ((absN & 1) == 1) ret *= x;
            x *= x;
            absN >>= 1;
        }

        return n < 0 ? 1 / ret : ret;
    }
}
```

**C++:**
```c++
class Solution {
public:
    double pow(double x, int n) {
        if (n < 0) return 1.0 / power(x, n);
        else return power(x, n);
    }

    double power(double x, int n) {
        if (n == 0) return 1;
        double v = power(x, n / 2);
        if (n % 2 == 0) return v * v;
        else return v * v * x;
    }
};
```
