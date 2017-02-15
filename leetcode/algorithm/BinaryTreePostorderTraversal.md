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
    vector<int> postorderTraversal(TreeNode *root) {
        vector<int> result;
        const TreeNode* p = root;
        const TreeNode* q;
        stack<const TreeNode*> s;

        do {
            while (p != nullptr) {
                s.push(p);
                p = p->left;
            }

            q = nullptr;

            while (!s.empty()) {
                p = s.top();
                s.pop();
                if (p->right == q) {
                    result.push_back(p->val);
                    q = p;
                } else {
                    s.push(p);
                    p = p->right;
                    break;
                }
            }
        } while (!s.empty());

        return result;

    }
};
```
