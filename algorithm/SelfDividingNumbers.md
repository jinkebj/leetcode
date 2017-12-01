# Self Dividing Numbers

A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

Example 1:

    Input:
    left = 1, right = 22
    Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]

Note:
The boundaries of each input argument are 1 <= left <= right <= 10000.

**Java:**
```java
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ret = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if (isSelfDivNum(i)) ret.add(i);
        }

        return ret;
    }

    private boolean isSelfDivNum(int num) {
        boolean ret = true;
        int s = num;
        while (s > 0) {
            if (s % 10 == 0 || num % (s % 10) != 0) {
                ret = false;
                break;
            }
            s /= 10;
        }

        return ret;
    }
}
```

**Java:**
```java
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int j = i;
            for (; j > 0; j /= 10) {
                if ((j % 10 == 0) || (i % (j % 10) != 0)) break;
            }
            if (j == 0) list.add(i);
        }
        return list;
    }
}
```