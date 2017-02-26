# Most Frequent Subtree Sum

Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

Examples 1
Input:

      5
     /  \
    2   -3

return [2, -3, 4], since all the values happen only once, return all of them in any order.

Examples 2
Input:

      5
     /  \
    2   -5

return [2], since 2 happens twice, however -5 only occur once.

Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.

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
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];

        Map<Integer, Integer> map = new HashMap<>();
        helper(map, root);
        List<Integer> ret = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == max) ret.add(entry.getKey());
        }

        return ret.stream().mapToInt(i -> i).toArray();
    }

    private int helper(Map<Integer, Integer> map, TreeNode node) {
        int left = (node.left == null) ? 0 : helper(map, node.left);
        int right = (node.right == null) ? 0 : helper(map, node.right);
        int sum = left + right + node.val;

        map.put(sum, map.getOrDefault(sum, 0) + 1);
        max = Math.max(max, map.get(sum));

        return sum;
    }

    private int max = 0;
}
```
