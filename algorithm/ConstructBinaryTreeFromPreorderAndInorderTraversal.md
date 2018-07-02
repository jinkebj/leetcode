# Construct Binary Tree from Preorder and Inorder Traversal

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

    preorder = [3,9,20,15,7]
    inorder = [9,3,15,20,7]

Return the following binary tree:

      3
     / \
    9  20
      /  \
     15   7

**Analysis:**

- preorder[0] = 3 is root node
- for inorder array, [9] construct left tree, [15, 20, 7] construct right tree
- loop above step to construct sub tree

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart >= inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // index of current root in inorder
        for (int i = inStart; i < inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
                break;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex, preorder, inorder);
        root.right = helper(preStart + 1 + inIndex - inStart, inIndex + 1, inEnd, preorder, inorder);

        return root;
    }
}

```
