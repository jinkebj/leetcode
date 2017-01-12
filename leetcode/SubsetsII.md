# Subsets II

Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

    [
     [2],
     [1],
     [1,2,2],
     [2,2],
     [1,2],
     []
    ]

**Analysis:**

我们以S=[1,2,2]为例:

    [[]]
    [[], [1]] // size = 2
    [[], [1], [2], [1, 2]] // start from last size 2
    [[], [1], [2], [1, 2], [2, 2], [1, 2, 2]]

可以发现从S=[1,2]变化到S=[1,2,2]时，多出来的有两个子集[2,2]和[1,2,2]，这两个子集，其实就是 [2], [1,2]末尾都加上2 而产生。而[2], [1,2] 这两个子集实际上是 S=[1,2]的解到 S=[1]的解 新添加的部分。

因此，若S中有重复元素，可以先排序；遍历过程中如果发现当前元素S[i] 和 S[i-1] 相同，那么不同于原有思路中“将当前res中所有自己拷贝一份再在末尾添加S[i]”的做法，我们只将res中上一次添加进来的子集拷贝一份，末尾添加S[i]

**Java:**
```java
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList();
        ret.add(new ArrayList());
        Arrays.sort(nums);
        int size = 0;

        for (int i = 0; i < nums.length; i++) {
            int start = (i > 0 && nums[i] == nums[i - 1]) ? size : 0;
            size = ret.size();

            // for the duplicate num, only append it to last time newly added subset
            for (int j = start; j < size; j++) {
                List<Integer> subs = new ArrayList(ret.get(j));
                subs.add(nums[i]);
                ret.add(subs);
            }
        }

        return ret;
    }
}
```
