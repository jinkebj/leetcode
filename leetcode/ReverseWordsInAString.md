# Reverse Words in a String

Given an input string, reverse the string word by word.

For example,

    Given s = "the sky is blue ",
    return "blue is sky the".

**Java: (use String.split)**
```
public class Solution {
    public String reverseWords(String s) {
        if (s == null) return null;

        StringBuilder ret = new StringBuilder();
        String[] splitWords = s.trim().split("\\s+");

        for (int i = splitWords.length - 1; i >= 0; i--) {
            ret.append(splitWords[i]);
            if (i > 0) ret.append(" ");
        }
        return ret.toString();
    }
}
```

**Java: (not use String.split)**
```java
public class Solution {
    public String reverseWords(String s) {
        if (s == null) return null;

        // remove leading, tailing and multiple spaces
        char[] chars = s.replaceAll("\\s+", " ").trim().toCharArray();

        // reverse the whole string
        reverse(chars, 0, chars.length - 1);

        // reverse every word
        int i = 0;
        int j = 0;
        for (; j < chars.length; j++) {
            if (chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
                j = i;
            } else if (j == chars.length - 1) {
                reverse(chars, i, j);
            }
        }

        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }
}
```

**Java: (not use String.split)**
```java
public class Solution {
    public String reverseWords(String s) {
        if (s == null) return null;

        // remove leading, tailing and multiple spaces
        char[] chars = s.replaceAll("\\s+", " ").trim().toCharArray();

        // reverse the whole string
        reverse(chars, 0, chars.length - 1);

        // reverse every word
        int i = 0;
        int j = 0;
        while (i < chars.length) {
            while (i < j || (i < chars.length && chars[i] == ' ')) i++; // skip spaces
            while (j < i || (j < chars.length && chars[j] != ' ')) j++; // skip non spaces
            reverse(chars, i, j - 1);
        }

        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }
}
```

**C++:**
```
class Solution {
public:
    void reverseWords(string &s) {
        string rs;
        for (int i = s.length() - 1; i >= 0; ) {
            while (i >= 0 && s[i] == ' ') i--;
            if (i < 0) break;
            if (!rs.empty()) rs.push_back(' ');
            string t;
            while (i >= 0 && s[i] != ' ') t.push_back(s[i--]);
            reverse(t.begin(), t.end());
            rs.append(t);
        }
        s = rs;
    }
};
```
**C++(not use system reverse function):**
```
class Solution {
public:
    void reverseWords(string &s) {
        string rs;
        for (int i = s.length() - 1; i >= 0; ) {
            while (i >= 0 && s[i] == ' ') i--;
            if (i < 0) break;
            if (!rs.empty()) rs.push_back(' ');
            string t;
            while (i >= 0 && s[i] != ' ') t.push_back(s[i--]);
            singleReverse(t);
            rs.append(t);
        }
        s = rs;
    }

    void singleReverse(string &s) {
        char tmp;
        for (int i = 0; i < s.length() / 2; i++) {
            tmp = s[i];
            s[i] = s[s.length() -1 - i];
            s[s.length() -1 - i] = tmp;
        }
    }
};
```
