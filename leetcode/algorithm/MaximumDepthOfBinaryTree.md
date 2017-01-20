# Maximum Depth of Binary Tree

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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
    public int maxDepth(TreeNode root) {
        int ret = 0;
        if (root == null) return ret;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            ret++;
        }

        return ret;
    }
}
```

**Java: (DFS)**
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
   public int maxDepth(TreeNode root) {
       int ret = 0;
       if (root == null) return ret;

       Deque<TreeNode> nodeStack = new LinkedList<TreeNode>();
       Deque<Integer> depthStack = new ArrayDeque<Integer>();
       nodeStack.push(root);
       depthStack.push(1);

       while (!nodeStack.isEmpty()) {
           TreeNode node = nodeStack.pop();
           int depth = depthStack.pop();
           ret = Math.max(ret, depth);

           if (node.left != null) {
               nodeStack.push(node.left);
               depthStack.push(depth + 1);
           }

           if (node.right != null) {
               nodeStack.push(node.right);
               depthStack.push(depth + 1);
           }
       }

       return ret;
   }
}
```
