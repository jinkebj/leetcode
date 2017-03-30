# Kth Largest Element in an Array

Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.

**Java:**
```java
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.offer(val);
            if (pq.size() > k) pq.poll();
        }
        return pq.peek();
    }
}
```

**Java:**
```java
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return Arrays.stream(nums)
            .sorted()
            .skip(nums.length - k)
            .limit(1)
            .sum();
    }
}
```
