# Reverse String

Write a function that takes a string as input and returns the string reversed.

    Example:
    Given s = "hello", return "olleh".

**Java:**
```java
public class Solution {
    public String reverseString(String s) {
        if (s == null) return null;

        char[] charArray = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            char tmp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = tmp;
            i++;
            j--;
        }

        return new String(charArray);
    }
}
```

**Java:**
```java
public class Solution {
    public String reverseString(String s) {
        if (s == null) return null;

        byte[] bytes = s.getBytes();
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            bytes[i] = (byte) (bytes[i] ^ bytes[j]);
            bytes[j] = (byte) (bytes[i] ^ bytes[j]);
            bytes[i] = (byte) (bytes[i] ^ bytes[j]);
            i++;
            j--;
        }

        return new String(bytes);
    }
}
```

**Java:**
```java
public class Solution {
    public String reverseString(String s) {
        if (s == null) return null;

        StringBuilder st = new StringBuilder(s);
        st.reverse();

        return st.toString();
    }
}
```
