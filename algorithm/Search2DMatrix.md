# Search a 2D Matrix

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

- Integers in each row are sorted from left to right.
- The first integer of each row is greater than the last integer of the previous row.

For example,

    Consider the following matrix:

    [
      [1,   3,  5,  7],
      [10, 11, 16, 20],
      [23, 30, 34, 50]
    ]

    Given target = 3, return true.

**Java:**
```java
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return false;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int begin = 0;
        int end = rows * cols - 1;

        while (begin <= end) {
            int mid = (begin + end) / 2;
            int midValue = matrix[mid / cols][mid % cols];

            if ( midValue == target) return true;
            else if (midValue < target) begin = mid + 1;
            else end = mid - 1;
        }

        return false;
    }
}
```
