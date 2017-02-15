# Word Ladder

Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

- Only one letter can be changed at a time.
- Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

For example,

    Given:
    beginWord = "hit"
    endWord = "cog"
    wordList = ["hot","dot","dog","lot","log","cog"]

    As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
    return its length 5.

Note:

- Return 0 if there is no such transformation sequence.
- All words have the same length.
- All words contain only lowercase alphabetic characters.
- You may assume no duplicates in the word list.
- You may assume beginWord and endWord are non-empty and are not the same.

**Java:**
```java
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null) return 0;
        if (!wordList.contains(endWord)) return 0;
        if (beginWord.equals(endWord)) return 1;

        List<String> queue = new LinkedList<>();
        Map<String, Integer> vis = new HashMap<>();
        queue.add(beginWord);
        vis.put(beginWord, 1);

        while (!queue.isEmpty()) {
            String cur = queue.remove();
            int step = vis.get(cur);
            char[] buffer = cur.toCharArray();
            for (int i = 0; i < cur.length(); ++i) {
                for (char c = 'a'; c <= 'z'; ++c) {
                    if (c == cur.charAt(i)) continue;
                    buffer[i] = c;
                    String next = new String(buffer);
                    if (wordList.contains(next) && !vis.containsKey(next)) {
                        if (next.equals(endWord)) return step + 1;
                        vis.put(next, step + 1);
                        queue.add(next);
                    }
                }
                buffer[i] = cur.charAt(i);
            }
        } // end while
        return 0;
    }
}
```
