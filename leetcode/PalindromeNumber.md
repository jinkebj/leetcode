# Palindrome Number

Determine whether an integer is a palindrome. Do this without extra space.

Some hints:

- Could negative integers be palindromes? (ie, -1)

- If you are thinking of converting the integer to string, note the restriction of using extra space.

- You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

***Analysis***
```
compare half of the digits in x, so don't need to deal with overflow.
```

**Java:**
```java
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;

        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }

        return (x == rev || x == rev / 10);
    }
}
```
