# Valid Sudoku

Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

There are just 3 rules to Sudoku.
- Each row must have the numbers 1-9 occuring just once.
- Each column must have the numbers 1-9 occuring just once.
- And the numbers 1-9 must occur just once in each of the 9 sub-boxes of the grid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

![](ValidSudoku.png)

Note:A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

**Analysis:**

Collect the set of things we see, encoded as strings. For example:

    4 in row 7
    4 in column 7
    4 in the block 0-2

Scream false if we ever fail to add something because it was already added (i.e., seen before).

**Java:**
```java
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j <9 ; j++) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                        !seen.add(number + " in column " + j) ||
                        !seen.add(number + " in block " + i / 3 + "-" + j / 3))
                        return false;
            }
        }
        return true;
    }
}
```
