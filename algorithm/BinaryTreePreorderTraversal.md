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
   public List<Integer> preorderTraversal(TreeNode root) {
       List<Integer> ret = new LinkedList<>();
       Deque<TreeNode> stack = new LinkedList<>();
       TreeNode node = root;

       while (!stack.isEmpty() || node != null) {
           if (node != null) {
               stack.push(node);
               ret.add(node.val);
               node = node.left;
           } else {
               node = stack.pop().right;
           }
       }

       return ret;
   }
}
```

**Java:(use stack 2)**
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
   public List<Integer> preorderTraversal(TreeNode root) {
       List<Integer> ret = new LinkedList<Integer>();
       if (root == null) return ret;

       Deque<TreeNode> stack = new LinkedList<TreeNode>();
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
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
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
                    result.add(cur.val);
                    p.right = cur;
                    cur = cur.left;
                } else {
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
    vector<int> preorderTraversal(TreeNode *root) {
        vector<int> result;
        const TreeNode *p;
        stack<const TreeNode*> s;

        p = root;
        if (p != nullptr) s.push(p);

        while (!s.empty()) {
            p = s.top();
            s.pop();
            result.push_back(p->val);

            if (p->right != nullptr) s.push(p->right);
            if (p->left != nullptr) s.push(p->left);
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
    vector<int> preorderTraversal(TreeNode *root) {
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
                    result.push_back(cur->val);
                    p->right = cur;
                    cur = cur->left;
                } else {
                    p->right = nullptr;
                    cur = cur->right;
                }
            }
        }

        return result;
    }
};
```