# Search in Rotated Sorted Array II

Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Write a function to determine if a given target is in the array.

The array may contain duplicates.

**Java:**
```java
public class Solution {
    public boolean search(int[] nums, int target) {
        int first = 0;
        int last = nums.length - 1;

        while (first <= last) {
            int mid = first + (last - first) / 2;
            if (nums[mid] == target) return true;

            if (nums[first] < nums[mid]) {
                if (nums[first] <= target && target <= nums[mid]) {
                    last = mid - 1;
                } else {
                    first = mid + 1;
                }
            } else if (nums[first] > nums[mid]) {
                if (nums[mid] <= target && target <= nums[last]) {
                    first = mid + 1;
                } else {
                    last = mid - 1;
                }
            } else {
                first++;
            }
        }

        return false;
    }
}
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
