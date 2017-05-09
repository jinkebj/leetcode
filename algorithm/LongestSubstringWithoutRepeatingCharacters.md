# Longest Substring Without Repeating Characters

Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

**Analysis:**
- use a hash set to track the longest substring without repeating characters so far
- use a fast pointer j to see if character j is in the hash set or not
- if not, add it to the hash set, move j forward and update the max length
- otherwise, delete from the head by using a slow pointer i until we can put character j to the hash set

**Java:**
```java
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }
}
```
