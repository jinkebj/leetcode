# Kth Smallest Element in a BST

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

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
     public int kthSmallest(TreeNode root, int k) {
         Deque<TreeNode> stack = new ArrayDeque<>();
         TreeNode node = root;
         int i = 1;

         while (!stack.isEmpty() || node != null) {
             if (node != null) {
                 stack.push(node);
                 node = node.left;
             } else {
                 node = stack.pop();
                 if (i == k) {
                     return node.val;
                 } else {
                     i++;
                 }
                 node = node.right;
             }
         }

         return Integer.MIN_VALUE;
     }
 }
```
