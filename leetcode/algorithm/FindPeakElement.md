# Find Peak Element

A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

**Java:**
```java
public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums.length == 2) return nums[0] > nums[1] ? 0 : 1;

        for (int i = 0; i < nums.length; i++) {
            if ((i - 1 < 0 || nums[i] > nums[i - 1]) &&
                (i + 1 == nums.length || nums[i] > nums[i + 1])) return i;
        }

        return -1;
    }
}
```

**Java:**
```java
public class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high - 1) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
            else if (nums[mid] > nums[mid + 1]) high = mid - 1;
            else low = mid + 1;    
        }
        return nums[low] > nums[high] ? low : high;
    }
}
```
