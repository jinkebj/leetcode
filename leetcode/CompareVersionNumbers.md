# Compare Version Numbers

Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

    0.1 < 1.1 < 1.2 < 13.37

**Java: (use String.split)**
```java
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1Strs = version1.split("\\.");
        String[] v2Strs = version2.split("\\.");

        for (int i = 0; i < v1Strs.length || i < v2Strs.length; i++) {
            int v1 = i < v1Strs.length ? Integer.parseInt(v1Strs[i]) : 0;
            int v2 = i < v2Strs.length ? Integer.parseInt(v2Strs[i]) : 0;

            if (v1 < v2) return -1;
            else if (v1 > v2) return 1;
            else continue;
        }

        return 0;
    }
}
```

**Java: (not use String.split)**
```java
public class Solution {
    public int compareVersion(String version1, String version2) {
        int temp1 = 0;
        int temp2 = 0;
        int len1 = version1.length();
        int len2 = version2.length();
        int i = 0;
        int j = 0;

        while (i < len1 || j < len2) {
            temp1 = 0;
            temp2 = 0;

            while (i < len1 && version1.charAt(i) != '.') {
                temp1 = temp1 * 10 + version1.charAt(i++) - '0';
            }

            while (j < len2 && version2.charAt(j) != '.') {
                temp2 = temp2 * 10 + version2.charAt(j++) - '0';
            }

            if (temp1 > temp2) return 1;
            else if (temp1 < temp2) return -1;
            else {
                i++;
                j++;
            }
        }

        return 0;
    }
}
```
