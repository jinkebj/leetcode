# Search in Rotated Sorted Array II

Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.

**Java:**
```java

```

**C++:**
```c++
class Solution {
public:
    bool search(int A[], int n, int target) {
        int first = 0;
        int last = n - 1;
        while (first <= last) {
            int mid = (first + last) / 2;
            if (A[mid] == target) return true;

            if (A[first] < A[mid]) {
                if (A[first] <= target && target <= A[mid])
                    last = mid - 1;
                else
                    first = mid + 1;
            } else if (A[first] > A[mid]) {
                if (A[mid] <= target && target <= A[last])
                    first = mid + 1;
                else
                    last = mid - 1;
            } else {
                first++;
            }
        }
        return false;
    }
};
```
