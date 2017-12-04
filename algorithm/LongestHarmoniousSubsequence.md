# Longest Harmonious Subsequence



We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.

Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.

Example 1:

    Input: [1,3,2,2,5,2,3,7]
    Output: 5
    Explanation: The longest harmonious subsequence is [3,2,2,2,3].

Note: The length of the input array will not exceed 20,000.

**Java:**
```java
class Solution {
    public int findLHS(int[] nums) {
        int ret = 0;

        Map<Integer, Integer> numCountMap = new HashMap<>();
        for (int num : nums) numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);

        for (int key : numCountMap.keySet()) {
            if (!numCountMap.containsKey(key + 1)) continue;
            ret = Math.max(ret, numCountMap.get(key) + numCountMap.get(key + 1));
        }

        return ret;
    }
}
```
