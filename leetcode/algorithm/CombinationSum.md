# Combination Sum

Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:

- All numbers (including target) will be positive integers.
- The solution set must not contain duplicate combinations.

For example, given candidate set [2, 3, 6, 7] and target 7,
A solution set is:

    [
     [7],
     [2, 2, 3]
    ]

**Java: (backtracking)**
```java
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ret = new ArrayList<>();
        doCombinate(ret, new ArrayList<Integer>(), 0, candidates, target);
        return ret;
    }

    private void doCombinate(List<List<Integer>> ret, List<Integer> cur, int start, int candidates[], int target) {
        if (target < 0) return;
        if (target == 0) {
            ret.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
            cur.add(candidates[i]);
            doCombinate(ret, cur, i, candidates, target - candidates[i]);
            cur.remove(cur.size() - 1);
        }
    }
}
```
