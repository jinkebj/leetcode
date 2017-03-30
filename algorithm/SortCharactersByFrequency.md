# Sort Characters By Frequency

Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

    Input:
    "tree"

    Output:
    "eert"

    Explanation:
    'e' appears twice while 'r' and 't' both appear once.
    So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:

    Input:
    "cccaaa"

    Output:
    "cccaaa"

    Explanation:
    Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
    Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:

    Input:
    "Aabb"

    Output:
    "bbAa"

    Explanation:
    "bbaA" is also a valid answer, but "Aabb" is incorrect.
    Note that 'A' and 'a' are treated as two different characters.


**Java: (utilize array for sort)**
```java
public class Solution {
    public String frequencySort(String s) {
        StringBuilder ret = new StringBuilder();
        Map<Character, Integer> charFreq = new HashMap<>();
        char[] sChars = s.toCharArray();

        // get frequency for every character
        for (char c : sChars) {
            if (charFreq.containsKey(c)) charFreq.put(c, charFreq.get(c) + 1);
            else charFreq.put(c, 1);
        }

        // utilize array for sort by frequency
        // array index => char frequency, array content => char list
        List<Character>[] freqCharArr = new List[sChars.length + 1];
        for (char key : charFreq.keySet()) {
            int freq = charFreq.get(key);
            if (freqCharArr[freq] == null) freqCharArr[freq] = new ArrayList<>();
            freqCharArr[freq].add(key);
        }

        // append char by frequency
        for (int i = freqCharArr.length - 1; i >= 0; i--) {
            if (freqCharArr[i] == null) continue;
            for (char c : freqCharArr[i]) {
                for (int j = 0; j < charFreq.get(c); j++) ret.append(c);
            }
        }

        return ret.toString();
    }
}
```

**Java: (utilize priority queue for sort)**
```java
public class Solution {
    public String frequencySort(String s) {
        StringBuilder ret = new StringBuilder();
        Map<Character, Integer> charFreq = new HashMap<>();
        char[] sChars = s.toCharArray();

        // get frequency for every character
        for (char c : sChars) {
            if (charFreq.containsKey(c)) charFreq.put(c, charFreq.get(c) + 1);
            else charFreq.put(c, 1);
        }

        // utilize priority queue for sort
        Queue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue());
        pq.addAll(charFreq.entrySet());

        // append char by frequency
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> e = pq.poll();
            for (int i = 0; i < (int)e.getValue(); i++) {
                ret.append(e.getKey());
            }
        }

        return ret.toString();
    }
}
```
