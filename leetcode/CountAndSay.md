# Count and Say

The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

**Analysis:**
The "1" is the 1st string, and calculate the n th string.
The following are sequence from n=1 to n=10:

    1.     1
    2.     11
    3.     21
    4.     1211
    5.     111221
    6.     312211
    7.     13112221
    8.     1113213211
    9.     31131211131221
    10.   13211311123113112211

From the examples you can see, the (i+1)th sequence is the "count and say" of the ith sequence!

**Java:**
```java
public class Solution {
    public String countAndSay(int n) {
        StringBuilder curr = new StringBuilder("1");
        StringBuilder prev;
        int count;
        char say;

        for (int i = 1; i < n; i++) {
            prev = curr;
            curr = new StringBuilder();
            count = 1;
            say = prev.charAt(0);

            for (int j = 1; j < prev.length(); j++) {
                if (prev.charAt(j) == say) {
                    count++;
                } else {
                    curr.append(count).append(say);
                    count = 1;
                    say = prev.charAt(j);
                }
            }
            curr.append(count).append(say);
        }

        return curr.toString();
    }
}
```
