# Binary Tree Level Order Traversal

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:

Given binary tree {3,9,20,#,#,15,7},

        3
       / \
      9  20
        /  \
       15   7

    return its level order traversal as:

    [
      [3],
      [9,20],
      [15,7]
    ]

**Java: (recursive)**
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        helper(ret, 0, root);
        return ret;
    }

    private void helper(List<List<Integer>> ret, int height, TreeNode root) {
        if (root == null) return;

        if (height >= ret.size()) ret.add(new ArrayList<>());
        ret.get(height).add(root.val);
        helper(ret, height + 1, root.left);
        helper(ret, height + 1, root.right);
    }
}
```

**Java: (BFS)**
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> levelValues = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                levelValues.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            ret.add(levelValues);
        }

        return ret;
    }
}
```
