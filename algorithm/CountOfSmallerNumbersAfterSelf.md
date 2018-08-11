# Count of Smaller Numbers After Self

You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

    Input: [5,2,6,1]
    Output: [2,1,1,0]
    Explanation:
    To the right of 5 there are 2 smaller elements (2 and 1).
    To the right of 2 there is only 1 smaller element (1).
    To the right of 6 there is 1 smaller element (1).
    To the right of 1 there is 0 smaller element.

**Java:**
```java
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        LinkedList<Integer> result = new LinkedList<>();
        if (nums.length == 0) return result;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sorted.length; i++) {
            map.put(sorted[i], i);
        }

        int[] BIT = new int[nums.length + 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            result.addFirst(getSum(BIT, map.get(nums[i]) - 1));
            update(BIT, map.get(nums[i]), 1);
        }

        return result;
    }

    private void update(int[]BIT, int index, int val) {
        index++;
        while (index < BIT.length) {
            BIT[index] += val;
            index += index & (-index);
        }
    }

    private int getSum(int[]BIT, int index) {
        index++;
        int sum = 0;
        while (index > 0) {
            sum += BIT[index];
            index -= index & (-index);
        }
        return sum;
    }
}
```
