# House Robber II

Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

**Analysis:**

This problem can be decomposed into two House Robber problems.
Suppose there are n houses, since house 0 and n - 1 are now neighbors, we cannot rob them together and thus the solution is now the maximum of

- Rob houses 0 to n - 2;
- Rob houses 1 to n - 1.
- edge cases (n == 1) are handled explicitly.

**Java:**
```java
public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
    	return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    public int rob(int[] nums, int lo, int hi) {
        int preRob = 0;
        int preNotRob = 0;
        int rob = 0;
        int notRob = 0;
        for (int i = lo; i <= hi; i++) {
          	rob = preNotRob + nums[i];
        	notRob = Math.max(preRob, preNotRob);

        	preNotRob = notRob;
        	preRob = rob;
        }
        return Math.max(rob, notRob);
    }
}
```
