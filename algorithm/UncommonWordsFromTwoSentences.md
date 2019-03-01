# Uncommon Words from Two Sentences

We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)

A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

Return a list of all uncommon words.

You may return the list in any order.



Example 1:

Input: A = "this apple is sweet", B = "this apple is sour"
Output: ["sweet","sour"]

Example 2:

Input: A = "apple apple", B = "banana"
Output: ["banana"]



Note:

    0 <= A.length <= 200
    0 <= B.length <= 200
    A and B both contain only spaces and lowercase letters.

**Java:**
```java
class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        List<String> ret = new ArrayList<>();
        Map<String, Integer> wordCount = new HashMap<>();

        for (String str : A.split(" ")) {
            wordCount.put(str, wordCount.getOrDefault(str, 0) + 1);
        }
        for (String str : B.split(" ")) {
            wordCount.put(str, wordCount.getOrDefault(str, 0) + 1);
        }

        for (String str : wordCount.keySet()) {
            if (wordCount.get(str) == 1) ret.add(str);
        }

        return ret.toArray(new String[ret.size()]);
    }
}
```