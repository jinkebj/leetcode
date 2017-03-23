# Binary Tree Zigzag Level Order Traversal

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],

      3
     / \
    9  20
      /  \
     15   7

return its zigzag level order traversal as:

    [
      [3],
      [20,9],
      [15,7]
    ]

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if (root == null) return ret;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean flag = true;

        while (!queue.isEmpty()) {
            List<Integer> levelValues = new LinkedList<>();
            int size = queue.size();

            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (flag) levelValues.add(node.val);
                else levelValues.add(0, node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            ret.add(levelValues);
            flag = !flag;
        }

        return ret;
    }
}
```
