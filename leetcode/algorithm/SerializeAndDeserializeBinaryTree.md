# Serialize and Deserialize Binary Tree

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

      1
     / \
    2   3
       / \
      4   5

as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.

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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "#!";

        StringBuilder ret = new StringBuilder();
        ret.append(root.val).append("!");
        ret.append(serialize(root.left));
        ret.append(serialize(root.right));

        return ret.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split("!");
        Queue<String> queue = new LinkedList<>();
        for (String string : strings) queue.offer(string);

        return reconPreOrder(queue);
    }

    // Reconstruct BST by pre-order traversal
    private TreeNode reconPreOrder(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("#")) return null;

        TreeNode head = new TreeNode(Integer.valueOf(val));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);

        return head;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
```
