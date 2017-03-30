# Count Primes

Count the number of prime numbers less than a non-negative number, n.

**Analysis:**
The Sieve of Eratosthenes is one of the most efficient ways to find all prime numbers up to n.

We start off with a table of n numbers. Let's look at the first number, 2. We know all multiples of 2 must not be primes, so we mark them off as non-primes. Then we look at the next number, 3. Similarly, all multiples of 3 such as 3 × 2 = 6, 3 × 3 = 9, ... must not be primes, so we mark them off as well.

**Java:**
```java
public class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = 2; j * i < n; j++) notPrime[j * i] = true;
            }
        }

        return count;
    }
}
```
