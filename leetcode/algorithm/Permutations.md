# Permutations

Given a collection of numbers, return all possible permutations.

    For example,

    [1,2,3] have the following permutations:
    [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

**Java:**
```java

```

**C++:**

**Analysis:**
典型的递归问题。

生成[2, 3]的全排列[2, 3]和[3, 2]，然后把1加上去生成[1, 2, 3]和[1, 3, 2]。
交换1和2的位置，生成[1, 3]的全排列[1, 3]和[3, 1]，然后把2加上去生成[2, 1, 3]和[2, 3, 1]。
在第二步的基础上交换2和3的位置，生成[2, 1]的全排列[2, 1]和[1, 2]，然后把3加上去生成[3, 2, 1]和[3, 1, 2]。

```c++
class Solution {
public:
    void internalPermute(vector<int> &num, int index, vector<int> &perm, vector<vector<int> > &result) {
        int size = num.size();

        if (size == index) {
            result.push_back(perm);
        }
        else {
            for (int i = index; i < size; ++i) {
                swap(num[index], num[i]);
                perm.push_back(num[index]);
                internalPermute(num, index + 1, perm, result);
                perm.pop_back();
                swap(num[index], num[i]);
            }
        }
    }

    vector<vector<int> > permute(vector<int> &num) {
        vector<vector<int> > result;
        vector<int> perm;

        internalPermute(num, 0, perm, result);

        return result;
    }
};
```
