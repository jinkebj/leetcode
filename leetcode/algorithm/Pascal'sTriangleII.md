# Pascal's Triangle II

Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?

**Analysis:**

We can do it iterativly:

    Iterative 0: [1]
    Iterative 1: [1, 1]
    Iterative 2: [1, 1, 1] => [1, 2, 1]
    Iterative 3: [1, 1, 2, 1] => [1, 3, 3, 1]
    ...
    when j = 0, item[j] = 1; when j > 0, item[j] = item[j] + item[j + 1]

**Java:**
```java
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<>();
        if (rowIndex < 0) return ret;

        for (int i = 0; i <= rowIndex; i++) {
            ret.add(0, 1);

            for (int j = 1; j < ret.size() - 1; j++) {
                ret.set(j, ret.get(j) + ret.get(j + 1));
            }
        }

        return ret;
    }
}
```
