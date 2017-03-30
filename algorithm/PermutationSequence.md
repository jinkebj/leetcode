# Permutation Sequence

The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

    "123"
    "132"
    "213"
    "231"
    "312"
    "321"

Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.

**Analysis:**
- for n numbers the permutations can be divided to (n-1)! groups, for n-1 numbers can be divided to (n-2)! groups, and so on
- k/(n-1)! indicates the index of current number
- k%(n-1)! denotes remaining index for the remaining n-1 numbers

**Java:**
```java
public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> num = new ArrayList<>();
        for (int i = 1; i <= n; i++) num.add(i);

        int[] fact = new int[n]; // factorial
        fact[0] = 1;
        for (int i = 1; i < n; i++) fact[i] = i * fact[i-1];

        k = k - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int ind = k / fact[i - 1];
            k = k % fact[i - 1];
            sb.append(num.get(ind));
            num.remove(ind);
        }

        return sb.toString();
    }
}
```
