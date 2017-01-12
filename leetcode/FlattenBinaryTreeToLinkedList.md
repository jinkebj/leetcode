# Flatten Binary Tree to Linked List

Given a binary tree, flatten it to a linked list in-place.

    For example,

    Given


             1
            / \
           2   5
          / \   \
         3   4   6

     The flattened tree should look like:

       1
        \
         2
          \
           3
            \
             4
              \
               5
                \
                 6

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
    public void flatten(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode node = stack.pop();

            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);

            node.left = null;
            if (!stack.empty()) node.right = stack.peek();
        }
    }
}
```

**C++:**
```c++
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    void flatten(TreeNode *root) {
        if (root == nullptr) return;

        stack<TreeNode*> s;
        s.push(root);
        while (!s.empty()) {
            TreeNode* p = s.top();
            s.pop();

            if (p->right != nullptr) s.push(p->right);
            if (p->left != nullptr) s.push(p->left);

            p->left = nullptr;
            if (!s.empty()) p->right = s.top();
        }
    }
};
```
