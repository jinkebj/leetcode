# Plus One

Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

**Java:**
```java
public class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> retList = new LinkedList<Integer>();
        int carry = 1;
        int sum = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            sum = digits[i] + carry;
            carry = sum / 10;
            retList.add(0, sum % 10);
        }
        if (sum > 9) retList.add(0, carry);

        int[] ret = new int[retList.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = retList.get(i);
        }

        return ret;
    }
}
```

**C++:**
```c++
class Solution {
public:
    vector<int> plusOne(vector<int> &digits) {
        const int addNum = 1;
        int carry = addNum;

        for (auto it = digits.rbegin(); it != digits.rend(); it++) {
            *it = *it + carry;
            carry = *it / 10;
            *it = *it % 10;
        }
        if (carry > 0) digits.insert(digits.begin(), 1);

        return digits;
    }
};
```
