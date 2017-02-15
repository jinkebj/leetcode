# Subsets

Given a set of distinct integers, S, return all possible subsets.

Note:
  - Elements in a subset must be in non-descending order.
  - The solution set must not contain duplicate subsets.

For example,

    If S = [1,2,3], a solution is:

    [
      [3],
      [1],
      [2],
      [1,2,3],
      [1,3],
      [2,3],
      [1,2],
      []
    ]

**Analysis:**

Iterative Solution:
```
Take [1, 2, 3] in the problem statement as an example.
The process of generating all the subsets is like:

  1. Initially: [[]]
  2. Adding the first number to all the existed subsets: [[], [1]];
  3. Adding the second number to all the existed subsets: [[], [1], [2], [1, 2]];
  4. Adding the third number to all the existed subsets: [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]].
```
Bit Manipulation:
```
The idea is that to give all the possible subsets,
we just need to exhaust all the possible combinations of the numbers.
And each number has only two possibilities: either in or not in a subset.
This can be represented using a bit.

There is also another a way to visualize this idea.
That is, if we use the above example,
1 appears once in every two consecutive subsets,
2 appears twice in every four consecutive subsets,
3 appears four times in every eight subsets, shown in the following (initially the 8 subsets are all empty):

[], [], [], [], [], [], [], []
[], [1], [], [1], [], [1], [], [1]
[], [1], [2], [1, 2], [], [1], [2], [1, 2]
[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]
```

Backtracking:
```
Each number has only two possibilities: either in or not in a subset.
Use recursive function to add both cases.

    subsets([1,2,3,4]) =
      []
      // push(1)
      [1, subsets([2,3,4])] // if push N times in subsets([2,3,4]), the pop times is also N, so vec is also [1] after backtrack.
      // pop(), push(2)
      [2, subsets([3,4])]
      // pop(), push(3)
      [3, subsets([4])]
      // pop(), push(4)
      [4, subsets([])]
      // pop()
```

**Java: (iterative)**
```java
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int size = ret.size();
            for (int j = 0; j < size; j++) {
                List<Integer> subs = new ArrayList<>(ret.get(j));
                subs.add(nums[i]);
                ret.add(subs);
            }
        }

        return ret;
    }
}
```

**Java: (bit manipulation)**
```java
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int size = (int)Math.pow(2, nums.length);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < size; i++) ret.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < size; j++) {
                if (((j >> i) & 1) == 1) ret.get(j).add(nums[i]);
            }
        }

        return ret;
    }
}
```

**Java: (backtracking)**
```java
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start) {
        list.add(new ArrayList<>(tempList));

        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]); // contain nums[i] in subset
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1); // don't contain nums[i] in subset
        }
    }
}
```

**C++:**
```c++
class Solution {
public:
    vector<vector<int>> subsets(vector<int> &S) {
        vector<vector<int>> result;
        vector<int> path;
        sort(S.begin(), S.end());
        subsets(S, path, 0, result);
        return result;
    }

    void subsets(vector<int> &S, vector<int> &path, int step, vector<vector<int>> &result) {
        if (step == S.size()) {
            result.push_back(path);
            return;
        }

        // not select S[step]
        subsets(S, path, step + 1, result);
        // select S[step]
        path.push_back(S[step]);
        subsets(S, path, step + 1, result);
        path.pop_back();
    }
};
```
