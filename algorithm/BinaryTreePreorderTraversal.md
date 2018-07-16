# Binary Tree Preorder Traversal

Given a binary tree, return the preorder traversal of its nodes' values.

For example:

    Given binary tree {1,#,2,3},

       1
        \
         2
        /
       3

    return [1,2,3].

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        helper(ret, root);
        return ret;
    }

    private void helper(List<Integer> ret, TreeNode root) {
        if (root == null) return;

        ret.add(root.val);
        helper(ret, root.left);
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                ret.add(node.val);
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop().right;
            }
        }

        return ret;
    }
}
```

**Java:(stack solution 2)**
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
   public List<Integer> preorderTraversal(TreeNode root) {
       List<Integer> ret = new LinkedList<>();
       if (root == null) return ret;

       Deque<TreeNode> stack = new LinkedList<>();
       stack.push(root);

       while (!stack.isEmpty()) {
           TreeNode node = stack.pop();
           ret.add(node.val);
           if (node.right != null) stack.push(node.right);
           if (node.left != null) stack.push(node.left);
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
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
                    ret.add(cur.val);
                    p.right = cur;
                    cur = cur.left;
                } else {
                    p.right = null;
                    cur = cur.right;
                }
            }
        }

        return ret;
    }
}
```
