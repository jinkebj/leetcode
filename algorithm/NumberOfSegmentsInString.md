# Number of Segments in a String

Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

Please note that the string does not contain any non-printable characters.

Example:

    Input: "Hello, my name is John"
    Output: 5

**Java:**
```java
public class Solution {
    public int countSegments(String s) {
        if (s == null || s.trim().isEmpty()) return 0;
        return s.trim().split("\\s+").length;
    }
}
```

**Java:**
```java
public class Solution {
    public int countSegments(String s) {
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) ret++;
        }
        return ret;
    }
}
```
