# Valid Anagram

Given two strings s and t, write a function to determine if t is an anagram of s.

    For example,

    s = "anagram", t = "nagaram", return true.
    s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

**Analysis:**

> 对于字符出现次数做个统计就好了。因为只有26个小写字母，所以可以建立一个大小为26的索引数组charcount，用来统计每个字符的出现次数。
对于s, 将其作为字符数组进行遍历，在遍历的过程中，对每个出现的字符计数加一。
对于t， 同样将其遍历，对每个出现的字符计数减一。
如果s和t是anagram， 那么最后的charcount数组中所有字符的计数都应该是0， 否则就不是anagram。


**Java:**
```java
public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] charCount = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            charCount[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] != 0) return false;
        }

        return true;
    }
}
```
