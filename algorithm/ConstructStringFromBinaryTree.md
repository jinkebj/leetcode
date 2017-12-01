# Construct String from Binary Tree

You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

Example 1:

    Input: Binary tree: [1,2,3,4]
           1
         /   \
        2     3
       /    
      4     

    Output: "1(2(4))(3)"

    Explanation: Originallay it needs to be "1(2(4)())(3()())",
    but you need to omit all the unnecessary empty parenthesis pairs.
    And it will be "1(2(4))(3)".

Example 2:

    Input: Binary tree: [1,2,3,null,4]
           1
         /   \
        2     3
         \  
          4

    Output: "1(2()(4))(3)"

    Explanation: Almost the same as the first example,
    except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.

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
class Solution {
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        StringBuilder ret = new StringBuilder();

        Deque<TreeNode> stack = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        stack.push(t);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (visited.contains(node)) {
                ret.append(")");
                stack.pop();
            } else {
                ret.append("(").append(node.val);
                visited.add(node);

                if (node.left == null && node.right != null) ret.append("()");
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            }
        }

        return ret.substring(1, ret.length() - 1);
    }
}
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
class Solution {
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        String ret = t.val + "";

        String left = tree2str(t.left);
        String right = tree2str(t.right);

        if (left == "" && right == "") return ret;
        if (left == "") return ret + "()" + "(" + right + ")";
        if (right == "") return ret + "(" + left + ")";

        return ret + "(" + left + ")" + "(" + right + ")";
    }
}
```
