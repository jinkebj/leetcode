# Unique Binary Search Trees

Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

     1         3     3      2      1
      \       /     /      / \      \
       3     2     1      1   3      2
      /     /       \                 \
     2     1         2                 3

**Analysis:**
```
Define two functions:

    G(n): the number of unique BST for a sequence of length n.
    F(i, n), 1 <= i <= n: the number of unique BST, where the number i is the root of BST, and the sequence ranges from 1 to n.

The total number of unique BST G(n), is the sum of BST F(i) using each number i as a root.

    G(n) = F(1, n) + F(2, n) + ... + F(n, n).

The bottom cases, there is only one combination to construct a BST out of a sequence of length 1 (only a root) or 0 (empty tree).

    G(0)=1, G(1)=1.

For example, F(3, 7): the number of unique BST tree with number 3 as its root. To construct an unique BST out of the entire sequence [1, 2, 3, 4, 5, 6, 7] with 3 as the root, which is to say, we need to construct an unique BST out of its left subsequence [1, 2] and another BST out of the right subsequence [4, 5, 6, 7], and then combine them together (i.e. cartesian product). The tricky part is that we could consider the number of unique BST out of sequence [1,2] as G(2), and the number of of unique BST out of sequence [4, 5, 6, 7] as G(4). Therefore, F(3,7) = G(2) * G(4).

    F(i, n) = G(i-1) * G(n-i)	1 <= i <= n
```

**Java:**
```java
public class Solution {
    public int numTrees(int n) {
        int [] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int level = 2; level <= n; level++)
            for(int root = 1; root <= level; root++)
                dp[level] += dp[level - root] * dp[root - 1];
        return dp[n];
    }
}
```
