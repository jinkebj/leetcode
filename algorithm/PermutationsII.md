# Permutations II

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:

    [
     [1,1,2],
     [1,2,1],
     [2,1,1]
    ]

**Java: (backtracking)**
```java
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), new boolean[nums.length], nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, boolean[] used, int [] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i - 1])) continue; // skip duplicate
                tempList.add(nums[i]);
                used[i] = true;
                backtrack(list, tempList, used, nums);
                tempList.remove(tempList.size() - 1);
                used[i] = false;
            }
        }
    }
}
```
