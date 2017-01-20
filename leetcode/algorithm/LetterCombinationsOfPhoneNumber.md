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
        List<String> ret = new ArrayList();
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
        LinkedList<String> ret = new LinkedList();
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
        result = new ArrayList<String>();
        if (digits.isEmpty()) {
            result.add("");
            return result;
        }

        initMap();
        array = digits.toCharArray();

        cons = new char[digits.length()];
        for (Character ch : map.get(array[0]))
            letterCombinationsHelper(0, ch);
        return result;
    }

    private void letterCombinationsHelper(int i, char c) {
        cons[i++] = c;
        if (i == array.length) {
            result.add(new String(cons));
            return;
        }
        for (Character ch : map.get(array[i]))
            letterCombinationsHelper(i, ch);
    }

    private void initMap() {
        map = new HashMap<Character, Character[]>();
        map.put('2', new Character[]{'a', 'b', 'c'});
        map.put('3', new Character[]{'d', 'e', 'f'});
        map.put('4', new Character[]{'g', 'h', 'i'});
        map.put('5', new Character[]{'j', 'k', 'l'});
        map.put('6', new Character[]{'m', 'n', 'o'});
        map.put('7', new Character[]{'p', 'q', 'r', 's'});
        map.put('8', new Character[]{'t', 'u', 'v'});
        map.put('9', new Character[]{'w', 'x', 'y', 'z'});
    }

    private Map<Character,Character[]> map;
    private char[] array;
    private char[] cons;
    private List<String> result;

}
```
