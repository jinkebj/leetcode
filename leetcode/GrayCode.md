# Gray Code

The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

    00 - 0
    01 - 1
    11 - 3
    10 - 2

Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

**Analysis:**
```
The idea is simple. G(i) = i^ (i/2)
```

**Java:**
```java
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList();
        for (int i = 0; i < (1 << n); i++) ret.add(i ^ (i >> 1));
        return ret;
    }
}
```
