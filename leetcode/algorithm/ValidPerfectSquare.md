# Valid Perfect Square

Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

    Input: 16
    Returns: True

Example 2:

    Input: 14
    Returns: False

**Java:**
```java
public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;

        boolean ret = false;
        for (int i = 2; i <= num / 2; i++) {
            if (i * i == num) return true;
            else if (i * i > num) return false;
        }
        return ret;
    }
}
```

**Java:**
```java
public class Solution {
    public boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * mid == num) return true;
            else if (mid * mid < num) low = (int)mid + 1;
            else high = (int)mid - 1;
        }
        return false;
    }
}
```
