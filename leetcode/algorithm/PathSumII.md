# Path Sum II

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
For example:
Given the below binary tree and sum = 22,

             5
            / \
           4   8
          /   / \
         11  13  4
        /  \    / \
       7    2  5   1

return

    [
      [5,4,11,2],
      [5,8,4,5]
    ]

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        List<Integer> curRet = new LinkedList<Integer>();
        pathSumInner(root, sum, curRet, ret);
        return ret;
    }

    private void pathSumInner(TreeNode root, int sum, List<Integer> curRet, List<List<Integer>> ret) {
        if (root == null) return;
        curRet.add(root.val);

        if (root.left == null && root.right == null && sum == root.val) {
            ret.add(new LinkedList(curRet));
            curRet.remove(curRet.size() - 1); // remove the last item for next iteration
            return;
        } else {
            pathSumInner(root.left, sum - root.val, curRet, ret);
            pathSumInner(root.right, sum - root.val, curRet, ret);
        }
        curRet.remove(curRet.size() - 1); // remove the last item for next iteration
    }
}
```
