# Binary Tree Paths

Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

      1
    /   \
    2     3
    \
     5

All root-to-leaf paths are:

    ["1->2->5", "1->3"]

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<String>();
        if (root != null) searchBT(root, "", ret);
        return ret;
    }

    private void searchBT(TreeNode root, String path, List<String> ret) {
        if (root.left == null && root.right == null) ret.add(path + root.val);
        if (root.left != null) searchBT(root.left, path + root.val + "->", ret);
        if (root.right != null) searchBT(root.right, path + root.val + "->", ret);
    }
}
```
