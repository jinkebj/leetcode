# Word Search

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

    For example,

    Given board =
    [
     ['A','B','C','E'],
     ['S','F','C','S'],
     ['A','D','E','E']
    ]

    word = "ABCCED", -> returns true,
    word = "SEE", -> returns true,
    word = "ABCB", -> returns false.

**Java: (backtracking)**
```java
public class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ((word.charAt(0) == board[i][j]) && search(i, j, visited, 0, board, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(int i, int j, boolean[][] visited, int index, char[][]board, String word) {
        if (index >= word.length()) return true;
        if (i >= board.length || i < 0 || j >= board[i].length || j < 0 ||
            board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;
        if (search(i - 1, j, visited, index + 1, board, word) ||
            search(i + 1, j, visited, index + 1, board, word) ||
            search(i, j - 1, visited, index + 1, board, word) ||
            search(i, j + 1, visited, index + 1, board, word)) {
            return true;
        }
        visited[i][j] = false;

        return false;
    }
}
```

**C++:**
```c++
class Solution {
public:
    bool exist(vector<vector<char> > &board, string word) {
        const int m = board.size();
        const int n = board[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (dfs(board, word, 0, i, j, visited)) return true;
        return false;
    }

    bool dfs(vector<vector<char>> &board, string word, int index, int x, int y, vector<vector<bool>> &visited) {
        if (index == word.size()) return true;

        if (x < 0 || y < 0 || x >= board.size() || y >= board[0].size()) return false;
        if (visited[x][y]) return false;
        if (board[x][y] != word[index]) return false;

        visited[x][y] = true;
        bool ret = dfs(board, word, index + 1, x - 1, y, visited) || // move up
                   dfs(board, word, index + 1, x + 1, y, visited) || // move down
                   dfs(board, word, index + 1, x, y - 1, visited) || // move left
                   dfs(board, word, index + 1, x, y + 1, visited); // move right
        visited[x][y] = false;

        return ret;
    }
};
```
