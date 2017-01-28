# Convert Sorted Array to Binary Search Tree

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

**Java:**
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return doSortedArrayToBST(nums, 0, nums.length);
    }

    private TreeNode doSortedArrayToBST(int[] nums, int start, int end) {
        if (end <= start) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = doSortedArrayToBST(nums, start, mid);
        root.right = doSortedArrayToBST(nums, mid + 1, end);
        return root;
    }
}
```
