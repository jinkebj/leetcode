# String to Integer (atoi)

Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

**Java:**
```java
public class Solution {
    public int myAtoi(String str) {
        int sign = 1;
        int len = str.length();
        int num = 0;
        int i = 0;

        while (i < len && str.charAt(i) == ' ') i++;

        if (i < len && str.charAt(i) == '+') i++;
        else if (i< len && str.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        for (; i < len; i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') break;
            if (num > (Integer.MAX_VALUE - (str.charAt(i) - '0')) / 10)
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            num = num * 10 + str.charAt(i) - '0';
        }

        return num * sign;
    }
}
```

**C++:**
```c++
class Solution {
public:
    int myAtoi(const char *str) {
        int sign = 1;
        int len = strlen(str);
        int num = 0;
        int i = 0;

        while (i < len && str[i] == ' ') i++;

        if (i < len && str[i] == '+') i++;
        else if (i < len && str[i] == '-') {
            sign = -1;
            i++;
        }

        for (; i < len; i++) {
            if (str[i] < '0' || str[i] > '9') break;
            if (num  > (INT_MAX - (str[i] - '0')) / 10)
                return sign == -1 ? INT_MIN : INT_MAX;
            num = num * 10 + str[i] - '0';
        }
        return num * sign;
    }
};
```
