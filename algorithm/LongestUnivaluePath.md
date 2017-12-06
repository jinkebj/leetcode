# Longest Univalue Path

Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

Note: The length of path between two nodes is represented by the number of edges between them.

Example 1:

Input:

        5
       / \
      4   5
     / \   \
    1   1   5

Output:

    2

Example 2:

Input:

        1
       / \
      4   5
     / \   \
    4   4   5

Output:

    2

Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.

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
class Solution {
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ret;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int l = node.left != null ? dfs(node.left) : 0;
        int r = node.right != null ? dfs(node.right) : 0;
        int resl = node.left != null && node.left.val == node.val ? l + 1 : 0;
        int resr = node.right != null && node.right.val == node.val ? r + 1 : 0;
        ret = Math.max(ret, resl + resr);

        return Math.max(resl, resr);
    }

    private int ret = 0;
}

```
