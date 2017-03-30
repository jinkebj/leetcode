# Sort Colors

Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:

You are not suppose to use the library's sort function for this problem.

Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?

**Java:**
```java
public class Solution {
    public void sortColors(int[] nums) {
        int num0 = 0;
        int num1 = 0;
        int num2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) num0++;
            else if (nums[i] == 1) num1++;
            else if (nums[i] == 2) num2++;
        }

        for (int i = 0; i < num0; i++) nums[i] = 0;
        for (int i = 0; i < num1; i++) nums[num0 + i] = 1;
        for (int i = 0; i < num2; i++) nums[num0 + num1 + i] = 2;
    }
}
```

**Java:**
```java
public class Solution {
    public void sortColors(int[] nums) {
        int i = 0; // pointer for 0
        int j = 0; // pointer for 1
        int k = nums.length - 1; // pointer for 2
        for (; i <= k; i++) {
            if (nums[i] == 0 && i != j) swap(nums, i--, j++);
            else if (nums[i] == 2 && i != k) swap(nums, i--, k--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
```
