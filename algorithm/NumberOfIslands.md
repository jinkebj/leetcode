# Number of Islands

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

    11110
    11010
    11000
    00000

Answer: 1

Example 2:

    11000
    11000
    00100
    00011

Answer: 3

**Analysis:**

The algorithm works as follow:

    1. Scan each cell in the grid.
    2. If the cell value is '1' explore that island.
    3. Mark the explored island cells with '0'.
    4. Once finished exploring that island, increment islands counter.

**Java:**
```java
public class Solution {
    public int numIslands(char[][] grid) {
        int ret = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    ret++;
                    clearRestOfLand(grid, i, j);
                }
            }
        }

        return ret;
    }

    private void clearRestOfLand(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') return;

        grid[i][j] = '0';
        clearRestOfLand(grid, i + 1, j);
        clearRestOfLand(grid, i - 1, j);
        clearRestOfLand(grid, i, j + 1);
        clearRestOfLand(grid, i, j - 1);
    }
}
```
