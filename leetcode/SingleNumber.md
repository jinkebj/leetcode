# Single Number

Given an array of integers, every element appears twice except for one. Find that single one.

Note:

    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

**Java:**
```java
public class Solution {
    public int singleNumber(int[] A) {
        int x = 0;
        for (int i = 0; i < A.length; i++) x ^= A[i];
        return x;
    }
}
```

**C++:**
```c++
class Solution {
public:
    int singleNumber(int A[], int n) {
        int x = 0;
        for (int i = 0; i < n; i++) x ^= A[i];
        return x;
    }
};
```
