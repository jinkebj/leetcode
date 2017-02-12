# House Robber III

The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:

      3
     / \
    2   3
     \   \
      3   1

Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

Example 2:

        3
       / \
      4   5
     / \   \
    1   3   1

Maximum amount of money the thief can rob = 4 + 5 = 9.

**Analysis:**
- dfs all the nodes of the tree, each node return two number which represent by int[] num
- num[0] is the max value while rob this node
- num[1] is the max value while not rob this value
- current node return value only depend on its children's value.

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
    public int rob(TreeNode root) {
        int[] num = dfs(root);
        return Math.max(num[0], num[1]);
    }
    private int[] dfs(TreeNode x) {
        if (x == null) return new int[2];

        int[] left = dfs(x.left);
        int[] right = dfs(x.right);

        int[] res = new int[2];
        res[0] = left[1] + right[1] + x.val;
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return res;
    }
}
```
