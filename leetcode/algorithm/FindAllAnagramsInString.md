# Find All Anagrams in a String

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

    Example 1:

    Input:
    s: "cbaebabacd" p: "abc"

    Output:
    [0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

    Example 2:

    Input:
    s: "abab" p: "ab"

    Output:
    [0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

**Java:**
```java
public class Solution {
  public class Solution {
      public List<Integer> findAnagrams(String s, String p) {
          List<Integer> ret = new ArrayList<>();
          int size = p.length();

          for (int i = 0; i < s.length(); i++) {
              if ((i + size) > s.length()) break;
              if (isAnagram(s.substring(i, i + size), p)) ret.add(i);
          }

          return ret;
      }

      private boolean isAnagram(String s, String p) {
          int[] charCount = new int[26];

          for (int i = 0; i < s.length(); i++) {
              charCount[s.charAt(i) - 'a']++;
          }

          for (int i = 0; i < p.length(); i++) {
              charCount[p.charAt(i) - 'a']--;
          }

          for (int i = 0; i < charCount.length; i++) {
              if (charCount[i] != 0) return false;
          }

          return true;
      }
  }
```
