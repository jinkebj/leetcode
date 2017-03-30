# Partition Equal Subset Sum

Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:

- Each of the array element will not exceed 100.
- The array size will not exceed 200.

Example 1:

    Input: [1, 5, 11, 5]

    Output: true

    Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:

    Input: [1, 2, 3, 5]

    Output: false

    Explanation: The array cannot be partitioned into equal sum subsets.

**Analysis:**
- this problem is essentially let us to find whether there are several numbers in a set which are able to sum to a sum/2
- actually, this is a 0/1 knapsack problem, for each number, we can pick it or not
- define dp[i] means whether we can sum to i, dp[0] is true(zero number consists of sum 0 is true)
- for each number, we pick it or not pick it: dp[i] = dp[i] || dp[i - num]

**Java:**
```java
public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % 2 != 0) return false; // sum must be even
        sum /= 2;

        int n = nums.length;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[sum];
    }
}
```
