# Majority Element

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

**Java: (Sorting)**
```java
public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
```

**Java: (HashMap)**
```java
public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        int ret = 0;

        for (int num: nums) {
            if (!myMap.containsKey(num)) myMap.put(num, 1);
            else myMap.put(num, myMap.get(num) + 1);
            if (myMap.get(num) > nums.length / 2) {
                ret = num;
                break;
            }
        }

        return ret;
    }
}
```

**Java: (Moore voting algorithm)**
```java
public class Solution {
    public int majorityElement(int[] nums) {
        int ret = 0;
        int count = 0;

        for (int num: nums) {
            if (count == 0) ret = num;
            if (num != ret) count--;
            else count++;
        }

        return ret;
    }
}
```
