# Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

**Java:**
```java
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String ret = strs[0];
        int i = 1;

        while (i < strs.length) {
            while (!strs[i].startsWith(ret)) ret = ret.substring(0, ret.length() - 1);
            i++;
        }

        return ret;
    }
}
```

**Java:**
```java
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        // sort the array, then find common prefix for the first and last item
        Arrays.sort(strs);
        String strStart = strs[0];
        String strEnd = strs[strs.length - 1];

        int i = 0;
        while (i < strStart.length() && i < strEnd.length()) {
            if (strStart.charAt(i) != strEnd.charAt(i)) break;
            i++;
        }

        return strStart.substring(0, i);
    }
}
```
