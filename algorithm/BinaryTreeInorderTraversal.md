# Binary Tree Inorder Traversal

Given a binary tree, return the inorder traversal of its nodes' values.

For example:

    Given binary tree {1,#,2,3},

       1
        \
         2
        /
       3

    return [1,3,2].

    Note: Recursive solution is trivial, could you do it iteratively?

**Java:(recursive solution)**
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        helper(ret, root);
        return ret;
    }

    private void helper(List<Integer> ret, TreeNode root) {
        if (root == null) return;

        helper(ret, root.left);
        ret.add(root.val);
        helper(ret, root.right);
    }
}
```

**Java:(stack solution)**
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                ret.add(node.val);
                node = node.right;
            }
        }


        return ret;
    }
}
```

**Java:(Morris traverse)**
```java
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left == null) {
                ret.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode p = cur.left;
                while (p.right != null && p.right != cur) {
                    p = p.right;
                }

                if (p.right == null) {
                    p.right = cur;
                    cur = cur.left;
                } else {
                    ret.add(cur.val);
                    p.right = null;
                    cur = cur.right;
                }
            }
        }

        return ret;
    }
}
```
