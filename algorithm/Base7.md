# Base 7

Given an integer, return its base 7 string representation.

Example 1:

    Input: 100
    Output: "202"

Example 2:

    Input: -7
    Output: "-10"

Note: The input will be in range of [-1e7, 1e7].

**Java:**
```java
public class Solution {
    public String convertToBase7(int num) {
        if (num == 0) return "0";

        int number = Math.abs(num);
        StringBuilder ret = new StringBuilder();
        while (number > 0) {
            ret.insert(0, number % 7);
            number /= 7;
        }
        if (num < 0) ret.insert(0, "-");

        return ret.toString();
    }
}
```

**Java:**
```java
public class Solution {
    public String convertToBase7(int num) {
        return Integer.toString(num, 7);
    }
}
```
