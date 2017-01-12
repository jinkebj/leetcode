# Jump Game

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

    For example:

    A = ==[2,3,1,1,4]==, return ==true==.
    A = ==[3,2,1,0,4]==, return ==false==.

**Java:**
```java
public class Solution {
    public boolean canJump(int[] A) {
        int reach = 1;
        int l = A.length;
        for (int i = 0; i < reach && reach < l; i++) {
            if (i + A[i] + 1 > reach ) reach = i + A[i] + 1;
        }
        return (reach >= l);
    }
}
```

**C++:**
```c++
class Solution {
public:
    bool canJump(int A[], int n) {
        int reach = 1;
        for (int i = 0; i < reach && reach < n; i++) {
            reach = max(reach, i + 1 + A[i]);
        }
        return (reach >= n);
    }
};
```
