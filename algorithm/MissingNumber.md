# Missing Number

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

**Java: (straight forward)**
```java
public class Solution {
    public int missingNumber(int[] nums) {
        int[] flag = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) flag[nums[i]] = 1;

        for (int i = 0; i < flag.length; i++) {
            if (flag[i] == 0) return i;
        }

        return -1;
    }
}
```

**Java: (math)**
```java
public class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int num: nums) sum += num;
        return (nums.length * (nums.length + 1)) / 2 - sum;
    }
}
```

**Java: (bit operation)**
```java
public class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0;
        int i = 0;
        for (i = 0; i < nums.length; i++) xor = xor ^ i ^ nums[i];

        return xor ^ i;
    }
}
```
