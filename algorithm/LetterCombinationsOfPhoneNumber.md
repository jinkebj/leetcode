# Letter Combinations of a Phone Number

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

![](LetterCombinationsOfPhoneNumber.png)

    Input: Digit string "23"
    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.

**Java: (iterative)**
```java
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if (digits == null || digits.length() == 0) return ret;

        ret.add("");
        String[] digitsMap = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for (int i = 0; i < digits.length(); i++) {
            String digitChars = digitsMap[digits.charAt(i) - '0'];

            int size = ret.size();
            for (int j = 0; j < size; j++) {
                String t = ret.remove(0);
                for (int k = 0; k < digitChars.length(); k++) {
                    ret.add(t + digitChars.charAt(k));
                }
            }
        }

        return ret;
    }
}
```

**Java: (queue)**
```java
public class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ret = new LinkedList<>();
        if (digits == null || digits.length() == 0) return ret;

        ret.add("");
        String[] digitsMap = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for (int i = 0; i < digits.length(); i++) {
            String digitChars = digitsMap[digits.charAt(i) - '0'];

            // use LinkedList as FIFO queue
            while (ret.peek().length() == i) {
                String t = ret.remove();
                for (int k = 0; k < digitChars.length(); k++) {
                    ret.add(t + digitChars.charAt(k));
                }
            }
        }

        return ret;
    }
}
```

**Java: (recursive)**
```java
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ret = new LinkedList<>();
        if (digits == null || digits.length() == 0) return ret;

        combination("", digits, 0, ret);
        return ret;
    }

    private void combination(String prefix, String digits, int offset, List<String> ret) {
        if (offset >= digits.length()) {
            ret.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, ret);
        }
    }

    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
}
```
