# Isomorphic Strings

Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,

    Given "egg", "add", return true.
    Given "foo", "bar", return false.
    Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.

**Java: (use HashMap)**
```java
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        for (int i = 0; i < sChars.length; i++) {
            if (map.containsKey(sChars[i])) {
                if (!map.get(sChars[i]).equals(tChars[i])) return false;
            } else if (map.containsValue(tChars[i])) {
                return false;
            } else {
                map.put(sChars[i], tChars[i]);
            }
        }

        return true;
    }
}
```

**Java: (use Array)**
```java
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        // use m to store char location in 2 strings
        int[] m  = new int[512];

        for (int i = 0; i < s.length(); i++) {
            if (m[s.charAt(i)] != m[t.charAt(i) + 256]) return false;
            m[s.charAt(i)] = i + 1;
            m[t.charAt(i) + 256] = i + 1;
        }

        return true;
    }
}
```
