# Sqrt(x)

Implement int sqrt(int x).

Compute and return the square root of x.

**Java:**
```java

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
