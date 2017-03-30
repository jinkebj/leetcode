# Contiguous Array

Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:

    Input: [0,1]
    Output: 2
    Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

Example 2:

    Input: [0,1,0]
    Output: 2
    Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

Note: The length of the given binary array will not exceed 50,000.

**Analysis:**
- change 0 in the original array to -1, then sum[i, j] == 0 means there are even number of -1 and 1 between index i and j
- put (sum[0, i], i) to HashMap
- sum[0, i] == sum[0, j] means there is contiguous subarray from index i to j

**Java:**
```java
public class Solution {
    public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }

        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int sum = 0;
        int ret = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumToIndex.containsKey(sum)) ret = Math.max(ret, i - sumToIndex.get(sum));
            else sumToIndex.put(sum, i);
        }

        return ret;
    }
}
```
