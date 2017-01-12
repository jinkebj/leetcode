# Remove Duplicates from Sorted Array II

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

    For example,

    Given sorted array A = [1,1,1,2,2,3],
    Your function should return length = 5, and A is now [1,1,2,2,3].

**Java:**
```java
public class Solution {
    public int removeDuplicates(int[] A) {
        final int occur = 2;
        if (A.length < occur) return A.length;

        int index = occur;
        for (int i = occur; i < A.length; i++) {
            if (A[index - occur] != A[i])
                A[index++] = A[i];
        }
        return index;
    }
}
```

**C++:**
```c++
class Solution {
public:
    int removeDuplicates(int A[], int n) {
        const int occur = 2;
        if (n <= occur) return n;

        int index = occur;
        for (int i = occur; i < n; i++) {
            if (A[index - occur] != A[i])
                A[index++] = A[i];
        }
        return index;
    }
};
```
