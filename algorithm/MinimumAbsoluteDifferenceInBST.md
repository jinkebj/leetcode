# Minimum Absolute Difference in BST

Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

    Input:

       1
        \
         3
        /
       2

    Output:
    1

    Explanation:
    The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).

Note: There are at least two nodes in this BST.

**Java: (in-Order traverse)**

The most common idea is to first in-Order traverse the tree and compare the delta between each of the adjacent values.
It's guaranteed to have the correct answer because it is a BST thus in-Order traversal values are sorted.

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
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return min;

        getMinimumDifference(root.left);

        if (prev != null) min = Math.min(min, root.val - prev);
        prev = root.val;

        getMinimumDifference(root.right);

        return min;
    }

    private int min = Integer.MAX_VALUE;
    private Integer prev = null;
}
```

**Java: (use priority queue)**
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
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;

        // level order traverse
    	Queue<TreeNode> queue = new LinkedList<>();
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	queue.offer(root);
    	while (!queue.isEmpty()) {
    		TreeNode cur = queue.poll();
    		pq.offer(cur.val);
    		if (cur.left != null) queue.offer(cur.left);
    		if (cur.right != null) queue.offer(cur.right);
    	}

    	int pre = Integer.MAX_VALUE;
    	int min = Integer.MAX_VALUE;
    	while (!pq.isEmpty()) {
    		int cur = pq.poll();
    		min = Math.min(min, (int)Math.abs(cur - pre));
    		pre = cur;
    	}
    	return min;
    }
}
```
