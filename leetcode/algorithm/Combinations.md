# Combinations

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

    For example,

    If n = 4 and k = 2, a solution is:

    [
      [2,4],
      [3,4],
      [2,3],
      [1,2],
      [1,3],
      [1,4],
    ]

**Analysis:**

**Solution: (recursive)**
```
This solution follows the idea of the mathematical formula C(n, k) = C(n - 1, k - 1) + C(n - 1, k).

Here C(n, k) is divided into two situations.
Situation one, number n is selected, so we only need to select k - 1 from n - 1 next.
Situation two, number n is not selected, and the rest job is selecting k from n  -1.
```

**Solution: (backtracking)**

典型的递归回溯法

- 递归一次，填入一个数字
- 填入的数字，不能是小于当前数字的值，防止重复
- 回溯：记得remove()最后加上的一个数字，回溯到上一层
- 结束条件：填写够了k个数字的时候，当前填写完毕，回溯

**Java: (recursive)**
```java
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (k == n || k == 0) {
            List<Integer> row = new LinkedList<Integer>();
            for (int i = 1; i <= k; i++) row.add(i);
            return new LinkedList(Arrays.asList(row));
        }

        List<List<Integer>> ret = combine(n - 1, k - 1);
        ret.forEach(e -> e.add(n)); // select n
        ret.addAll(combine(n - 1, k)); // not select n

        return ret;
    }
}
```

**Java: (backtracking)**
```java
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        doCombine(ret, new ArrayList<Integer>(), 1, n, k);
        return ret;
    }

    private void doCombine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if (k == 0) {
            combs.add(new ArrayList<Integer>(comb));
            return;
        }
        for (int i = start; i <= n; i++) {
            comb.add(i);
            doCombine(combs, comb, i + 1, n, k - 1); // select current position, process next position
            comb.remove(comb.size() - 1); // clear the current position to try next possible number
            }
        }
    }
}
```

**C++:**
```c++
class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> result;
        vector<int> path;
        dfs(n, k, 1, 0, path, result);
        return result;
    }

    // start: the started number, cur: count of selected number
    void dfs(int n, int k, int start, int cur, vector<int> &path, vector<vector<int>> &result) {
        if (cur == k) result.push_back(path);

        for (int i = start; i <= n; i++) {
            path.push_back(i);
            dfs(n, k, i + 1, cur + 1, path, result);
            path.pop_back();
        }
    }
};
```
