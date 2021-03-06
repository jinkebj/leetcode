# Minimum Moves to Equal Array Elements

Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:

    Input:
    [1,2,3]

    Output:
    3

    Explanation:
    Only three moves are needed (remember each move increments two elements):

    [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

**Analysis:**
```
Adding 1 to n - 1 elements is the same as subtracting 1 from one element.
So, best way to do this is make all the elements in the array equal to the min element.
sum(array) - n * minimum
```

**Java:**
```java
public class Solution {
    public int minMoves(int[] nums) {
        if (nums.length == 0) return 0;

        int min = nums[0];
        for (int n : nums) min = Math.min(min, n);

        int ret = 0;
        for (int n : nums) ret += n - min;

        return ret;
    }
}
```
