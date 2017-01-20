# Sum of Left Leaves

Find the sum of all left leaves in a given binary tree.

Example:

        3
       / \
      9  20
        /  \
       15   7

    There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

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
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        int ret = 0;
        if (root == null) return ret;

        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) ret += root.left.val;
            else ret += sumOfLeftLeaves(root.left);
        }

        ret += sumOfLeftLeaves(root.right);

        return ret;
    }
}
```

**Java: (iterative)**
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
    public int sumOfLeftLeaves(TreeNode root) {
        int ret = 0;
        if (root == null) return ret;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    ret += node.left.val;
                } else {
                    stack.push(node.left);
                }
            }

            if (node.right != null) {
                if (node.right.left != null || node.right.right != null) {
                    stack.push(node.right);
                }
            }
        }

        return ret;
    }
}
```
