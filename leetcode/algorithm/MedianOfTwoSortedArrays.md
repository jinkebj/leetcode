# Median of Two Sorted Arrays

There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

**Analysis:**
```
中位数(Median)是在一组数据中居于中间的数(特别注意的地方是：这组数据之前已经经过升序排列！！！)，即在这组数据中，有一半的数据比它大，有一半的数据比它小。如果这组数据包含偶数个数字，中位数是位于中间的两个数的平均值。

findKth()函数的思路如下：

1. 保持A是短的那一个数组，B是长的

2. 平分k, 一半在A，一半在B （如果A的长度不足K/2,那就pa就指到最后一个）

3. 如果pa的值 < pb的值，那证明第K个数肯定不会出现在pa之前，递归，把A数组pa之前的砍掉，同理递归砍B数组

4. 递归到 m = 0 （短的数组用完了） 就返回 B[k - 1], 或者k == 1（找第一个数）就返回min(A第一个数，B第一个数）
```

**Java:**
```java
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        int k = m + n;
        if (k % 2 != 0) {
            return findKth(A, 0, B, 0, k / 2 + 1);
        } else {
            return (findKth(A, 0, B, 0, k / 2) + findKth(A, 0, B, 0, k / 2 + 1)) / 2.0;
        }
    }

    private double findKth(int A[], int a, int B[], int b, int k) {
        // make sure A is shorter than B
        if (A.length - a > B.length - b) return findKth(B, b, A, a, k);

        if (a >= A.length) return B[b + k - 1];

        if (k == 1) return Math.min(A[a], B[b]);

        int midA = Math.min(k / 2, A.length - a);
        int midB = k - midA;

        if (A[a + midA - 1] < B[b + midB - 1]) {
            return findKth(A, a + midA, B, b, k - midA);
        } else if (A[a + midA - 1] > B[b + midB -1]) {
            return findKth(A, a, B, b + midB, k - midB);
        } else {
            return A[a + midA - 1];
        }
    }
}
```
