# Palindrome Partitioning

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

    For example,

    given s = "aab",

    Return

      [
        ["aa","b"],
        ["a","a","b"]
      ]

**Java: (DP)**
- the pair is to mark a range for the substring is a palindrome. if pair[i][j] is true, that means sub string from i to j is palindrome
- the result[i], is to store all possible partitions from beginning to index i (exclusive)
- from the past result we can determine current result

```java
public class Solution {
     public static List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>>[] result = new List[len + 1];
        result[0] = new ArrayList<List<String>>();
        result[0].add(new ArrayList<String>());

        boolean[][] pair = new boolean[len][len];
        for (int i = 0; i < s.length(); i++) {
            result[i + 1] = new ArrayList<List<String>>();
            for (int left = 0; left <= i; left++) {
                if (s.charAt(left) == s.charAt(i) && (i - left <= 1 || pair[left + 1][i - 1])) {
                    pair[left][i] = true;
                    String str = s.substring(left, i + 1);
                    for (List<String> r : result[left]) {
                        List<String> ri = new ArrayList<String>(r);
                        ri.add(str);
                        result[i + 1].add(ri);
                    }
                }
            }
        }

        return result[len];
    }
}
```

**Java: (backtracking)**
```java
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> resultLst = new ArrayList<List<String>>();
        List<String> currLst = new ArrayList<String>();
        backTrack(resultLst, currLst, s, 0);
        return resultLst;
    }

    private void backTrack(List<List<String>> resultLst, List<String> currLst, String s, int start) {
        if (currLst.size() > 0 && start >= s.length()) {
            resultLst.add(new ArrayList<String>(currLst));
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                currLst.add(s.substring(start, i + 1));
                backTrack(resultLst, currLst, s, i + 1);
                currLst.remove(currLst.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }
}
```
