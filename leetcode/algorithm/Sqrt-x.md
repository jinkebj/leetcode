# Sqrt(x)

Implement int sqrt(int x).

Compute and return the square root of x.

**Java:**
```java
public class Solution {
    public int mySqrt(int x) {
        long r = x;
        while (r * r > x) r = (r + x / r) / 2;
        return (int)r;
    }
}
```

**Java: (binary search)**
```java
public class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;

        int left = 1;
        int right = x;
        int ret = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                left = mid + 1;
                ret = mid;
            } else {
                right = mid - 1;
            }
        }
        return ret;
    }
}
```

**C++:**
```c++
class Solution {
public:
    int sqrt(int x) {
        if (x < 2) return x;

        int left = 1;
        int right = x / 2;
        int last_mid;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (x / mid > mid) {
                left = mid + 1;
                last_mid = mid;
            } else if (x / mid < mid) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return last_mid;
    }
};
```
