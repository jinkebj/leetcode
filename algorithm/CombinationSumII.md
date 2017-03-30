# Combination Sum II

Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:

- All numbers (including target) will be positive integers.
- The solution set must not contain duplicate combinations.

For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
A solution set is:

    [
     [1, 7],
     [1, 2, 5],
     [2, 6],
     [1, 1, 6]
    ]

**Java: (backtracking)**
```java
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if (i > start && candidates[i] == candidates[i - 1]) continue; // skip duplicate
            cur.add(candidates[i]);
            doCombinate(ret, cur, i + 1, candidates, target - candidates[i]);
            cur.remove(cur.size() - 1);
        }
    }
}
```
