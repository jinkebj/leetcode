# Majority Element II

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.

**Analysis:**
- for Boyer-Moore Majority Vote algorithm, refer to http://goo.gl/64Nams
- the essential concepts is you keep a counter for the majority number X.
- if you find a number Y that is not X, the current counter should deduce 1. The reason is that if there is 5 X and 4 Y, there would be one (5-4) more X than Y. This could be explained as "4 X being paired out by 4 Y".
- the requirement is finding the majority for more than ceiling of [n/3], the answer would be less than or equal to two numbers. we can modify the algorithm to maintain two counters for two majorities.

**Java: (Boyer-Moore Majority Vote algorithm)**
```java
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;
        List<Integer> ret = new ArrayList<>();
        if (nums == null || len == 0) return ret;

        int number1 = nums[0];
        int number2 = nums[0];
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] == number1) count1++;
            else if (nums[i] == number2) count2++;
            else if (count1 == 0) {
                number1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                number2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == number1) count1++;
            else if (nums[i] == number2) count2++;
        }

        if (count1 > len / 3) ret.add(number1);
        if (count2 > len / 3) ret.add(number2);

        return ret;
    }
}
```
