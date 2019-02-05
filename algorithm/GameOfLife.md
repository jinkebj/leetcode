# Game of Life

According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

    Any live cell with fewer than two live neighbors dies, as if caused by under-population.
    Any live cell with two or three live neighbors lives on to the next generation.
    Any live cell with more than three live neighbors dies, as if by over-population..
    Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

Example:

    Input:
    [
    [0,1,0],
    [0,0,1],
    [1,1,1],
    [0,0,0]
    ]
    Output:
    [
    [0,0,0],
    [1,0,1],
    [0,1,1],
    [0,1,0]
    ]

Follow up:

    Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
    In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?

**Analysis:**

To solve it in place, we use 2 bits to store 2 states:

[2nd bit, 1st bit] = [next state, current state]

- 00  dead (next) <- dead (current)
- 01  dead (next) <- live (current)
- 10  live (next) <- dead (current)
- 11  live (next) <- live (current)

    In the beginning, every cell is either 00 or 01.
    Notice that 1st state is independent of 2nd state.
    Imagine all cells are instantly changing from the 1st to the 2nd state, at the same time.
    Let's count # of neighbors from 1st state and set 2nd state bit.
    Since every 2nd state is by default dead, no need to consider transition 01 -> 00.
    In the end, delete every cell's 1st state by doing >> 1.

For each cell's 1st bit, check the 8 pixels around itself, and set the cell's 2nd bit.

    Transition 01 -> 11: when board == 1 and lives >= 2 && lives <= 3.
    Transition 00 -> 10: when board == 0 and lives == 3.

To get the current state, simply do

board[i][j] & 1

To get the next state, simply do

board[i][j] >> 1

**Java:**
```java
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int countLive = 0;
                for (int p = Math.max(i - 1, 0); p < Math.min(i + 2, m); p++) {
                    for (int q = Math.max(j - 1, 0); q < Math.min(j + 2, n); q++) {
                        if (board[p][q] == 2 || board[p][q] == 1) countLive++; // count status 0 is live
                    }
                }
                countLive -= board[i][j];
                if (board[i][j] == 0 && countLive == 3) board[i][j] = 3; // status 0 is dead, next status is live
                if (board[i][j] == 1 && (countLive < 2 || countLive > 3)) board[i][j] = 2; // status 0 is live, next status is dead
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] %= 2;
            }
        }
    }
}
```