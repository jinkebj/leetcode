# Binary Tree Postorder Traversal

Given a binary tree, return the postorder traversal of its nodes' values.

For example:

    Given binary tree {1,#,2,3},

       1
        \
         2
        /
       3

    return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?

**Analysis:**
```
Post order traversal is similar with pre order traversal,
the only difference is, we use the following access sequence:
    root -> right -> left
and every time put the element to the beginning of list.
Then the content in list became:
    left -> right -> root
```

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        helper(ret, root);
        return ret;
    }

    private void helper(List<Integer> ret, TreeNode root) {
        if (root == null) return;

        helper(ret, root.left);
        helper(ret, root.right);
        ret.add(root.val);
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                ret.add(0, node.val);
                stack.push(node);
                node = node.right;
            } else {
                node = stack.pop().left;
            }
        }

        return ret;
    }
}
```
