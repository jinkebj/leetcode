# Binary Tree Level Order Traversal

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:

Given binary tree {3,9,20,#,#,15,7},

        3
       / \
      9  20
        /  \
       15   7

    return its level order traversal as:

    [
      [3],
      [9,20],
      [15,7]
    ]

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        levelOrderInner(root, ret, 0);
        return ret;
    }

    private void levelOrderInner(TreeNode root, List<List<Integer>> ret, int height) {
        if (root == null) return;
        if (height >= ret.size()) ret.add(new ArrayList<Integer>());
        ret.get(height).add(root.val);
        levelOrderInner(root.left, ret, height + 1);
        levelOrderInner(root.right, ret, height + 1);
    }
}
```

**Java: (BFS)**
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) return ret;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> levelValues = new ArrayList<Integer>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                levelValues.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            ret.add(levelValues);
        }

        return ret;
    }
}
```

**C++: (recursive)**
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
    vector<vector<int> > levelOrder(TreeNode *root) {
        vector<vector<int>> result;
        traverse(root, 1, result);
        return result;
    }

    void traverse(TreeNode * node, size_t level, vector<vector<int>> &result) {
        if (!node) return;

        if (level > result.size()) {
            result.push_back(vector<int>());
        }

        result[level -1].push_back(node->val);
        traverse(node->left, level + 1, result);
        traverse(node->right, level + 1, result);
    }
};
```

**C++: (iterative)**
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
    vector<vector<int> > levelOrder(TreeNode *root) {
        vector<vector<int>> result;
        if (root == nullptr) return result;

        queue<TreeNode*> current, next;
        vector<int> item;

        current.push(root);
        while (!current.empty()) {
            while (!current.empty()) {
               TreeNode* node = current.front();
               current.pop();
               item.push_back(node->val);
               if (node->left != nullptr) next.push(node->left);
               if (node->right != nullptr) next.push(node->right);
            }

            result.push_back(item);
            item.clear();
            swap(next, current);
        }

        return result;
    }
};
```
