# Combination Sum III

Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Example 1:

    Input: k = 3, n = 7

    Output:

    [[1,2,4]]

Example 2:

    Input: k = 3, n = 9

    Output:

    [[1,2,6], [1,3,5], [2,3,4]]

**Java: (backtracking)**
```java
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<>();
        doCombinate(ret, new ArrayList<Integer>(), 1, k, n);
        return ret;
    }

    private void doCombinate(List<List<Integer>> ret, List<Integer> cur, int start, int k, int target) {
        if (target < 0) return;
        if (target == 0 && k == 0) {
            ret.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < 10 && target >= i; i++) {
            cur.add(i);
            doCombinate(ret, cur, i + 1, k - 1, target - i);
            cur.remove(cur.size() - 1);
        }
    }
}
```
