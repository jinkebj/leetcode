# Roman to Integer

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

**Java:**
```java
public class Solution {
    public int romanToInt(String s) {
        int ret = 0;
        for (int i = 1; i < s.length(); i++) {
            if (toNumber(s.charAt(i - 1)) < toNumber(s.charAt(i))) {
                ret -= toNumber(s.charAt(i - 1));
            } else {
                ret += toNumber(s.charAt(i - 1));
            }
        }
        ret += toNumber(s.charAt(s.length() - 1));
        return ret;
    }

    private int toNumber(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default : return 0;
        }
    }
}
```

**C++:**
```c++
class Solution {
public:
    int romanToInt(string s) {
        int result = 0;
        for (int i = 0; i < s.size(); i++) {
            if (i > 0 && map(s[i]) > map(s[i - 1])) {
                result = result + map(s[i]) - 2 * map(s[i - 1]);
            } else {
                result = result + map(s[i]);
            }
        }
        return result;
    }

    inline int map(const char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
};
```
