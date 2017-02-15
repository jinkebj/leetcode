# Contains Duplicate II

Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.

**Java:**
```java
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> numSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > k) numSet.remove(nums[i - k - 1]);
            if (!numSet.add(nums[i])) return true;
        }

        return false;
    }
}
```
