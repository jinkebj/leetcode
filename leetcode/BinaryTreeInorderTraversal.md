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

**Java:(use stack)**
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;

        while (!stack.empty() || node != null) {
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
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left == null) {
                result.add(cur.val);
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
                    result.add(cur.val);
                    p.right = null;
                    cur = cur.right;
                }
            }
        }

        return result;
    }
}
```

**C++:(use stack)**
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
    vector<int> inorderTraversal(TreeNode *root) {
        vector<int> result;
        const TreeNode* p = root;
        stack<const TreeNode*> s;

        while (!s.empty() || p!= nullptr) {
            if (p != nullptr) {
                s.push(p);
                p = p->left;
            } else {
                p = s.top();
                s.pop();
                result.push_back(p->val);
                p = p->right;
            }
        }
        return result;
    }
};
```

**C++:(Morris traverse)**
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
    vector<int> inorderTraversal(TreeNode *root) {
        vector<int> result;
        TreeNode* cur = root;

        while (cur != nullptr) {
            if (cur->left == nullptr) {
                result.push_back(cur->val);
                cur = cur->right;
            } else {
                TreeNode* p = cur->left;
                while (p->right != nullptr && p->right != cur) {
                    p = p->right;
                }
                if (p->right == nullptr) {
                    p->right = cur;
                    cur = cur->left;
                } else {
                    result.push_back(cur->val);
                    p->right = nullptr;
                    cur = cur->right;
                }
            }
        }

        return result;
    }
};
```
