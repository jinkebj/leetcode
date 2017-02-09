# Find Mode in Binary Search Tree

Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

- The left subtree of a node contains only nodes with keys less than or equal to the node's key.
- The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
- Both the left and right subtrees must also be binary search trees.

For example:
Given BST [1,null,2,2],

       1
        \
         2
        /
       2

return [2].

Note: If a tree has more than one mode, you can return them in any order.

**Analysis:**

众数(Mode)是在一组数据中,出现次数最多的数据，是一组数据中的原数据，而不是相应的次数。
一般来说，一组数据中，出现次数最多的数就叫这组数据的众数。

    例如：1，2，3，3，4的众数是3。
    但是，如果有两个或两个以上个数出现次数都是最多的，那么这几个数都是这组数据的众数。
    例如：1，2，2，3，3，4的众数是2和3。
    还有，如果所有数据出现的次数都一样，那么这组数据没有众数。
    例如：1，2，3，4，5没有众数。

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
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];

        List<Integer> list = new ArrayList<>();
        traverse(root, list);

        int[] res = new int[list.size()];
        int m = 0;
        for (Integer mode : list) res[m++] = mode;

        return res;
    }

    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;

        traverse(root.left, list);

        if (prev != null) {
            if (root.val == prev) count++;
            else count = 1;
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        prev = root.val;

        traverse(root.right, list);
    }

    private Integer prev = null;
    private int count = 1;
    private int max = 0;
}
```
