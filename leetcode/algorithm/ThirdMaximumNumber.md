# Third Maximum Number

Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:

    Input: [3, 2, 1]

    Output: 1

    Explanation: The third maximum is 1.

Example 2:

    Input: [1, 2]

    Output: 2

    Explanation: The third maximum does not exist, so the maximum (2) is returned instead.

Example 3:

    Input: [2, 2, 3, 1]

    Output: 1

    Explanation: Note that the third maximum here means the third maximum distinct number.
    Both numbers with value 2 are both considered as second maximum.

**Java:**
```java
public class Solution {
    public int thirdMax(int[] nums) {
        int count = 0;
        boolean minFlag = false;
        int[] sortedNums = new int[3];
        for (int i = 0; i < 3; i++) {
            sortedNums[i] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!minFlag && (nums[i] == Integer.MIN_VALUE)) {
                count++;
                minFlag = true;
            }
            if (nums[i] == sortedNums[2] || nums[i] == sortedNums[1]) continue;

            if (nums[i] > sortedNums[2]) {
                sortedNums[0] = sortedNums[1];
                sortedNums[1] = sortedNums[2];
                sortedNums[2] = nums[i];
                count++;
            } else if (nums[i] > sortedNums[1]) {
                sortedNums[0] = sortedNums[1];
                sortedNums[1] = nums[i];
                count++;
            } else if (nums[i] >= sortedNums[0]) {
                sortedNums[0] = nums[i];
                count++;
            }
        }

        if (count >= 3) return sortedNums[0];
        else return sortedNums[2];
    }
}
```
**Java: (use priority queue)**
```java
public class Solution {
    public int thirdMax(int[] nums) {
        Queue<Integer> pg = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.contains(num)) {
                pg.offer(num);
                set.add(num);
            }
            if (pg.size() > 3) set.remove(pg.poll());
        }

        if (pg.size() < 3) {
            while (pg.size() > 1) pg.poll();
        }

        return pg.peek();
    }
}
```
