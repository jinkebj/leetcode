# Minimum Path Sum

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

**Java:**
```java
public class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] minPathSum = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) minPathSum[0][0] = grid[0][0];
                else if (i == 0) minPathSum[0][j] = minPathSum[0][j - 1] + grid[0][j];
                else if (j == 0) minPathSum[i][0] = minPathSum[i - 1][0] + grid[i][0];
                else minPathSum[i][j] = Math.min(minPathSum[i - 1][j], minPathSum[i][j - 1]) + grid[i][j];
            }
        }

        return minPathSum[row - 1][col - 1];
    }
}
```
