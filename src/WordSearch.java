/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/
public class Solution {
    public boolean exist(char[][] board, String word) {
        final int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; ++i)
            for (int j=0; j<n; ++j){
                if (dfs(board, word, visited, i,j,0))
                    return true;
            }
        
        return false;
    }
    private boolean dfs(char[][] board, String s, boolean[][] visited, int row, int col, int digit){
        if (row <0 ||col < 0 || row >= board.length || col >= board[0].length) return false;
        if (digit == s.length()-1){
            if (!visited[row][col] && s.charAt(digit) == board[row][col])
                return true;
            else
                return false;
        }
        
        int index=digit;
        if (!visited[row][col] && s.charAt(digit)==board[row][col]){
            visited[row][col] = true;
            index++;

        boolean ret= dfs(board, s, visited, row+1, col, index) ||
               dfs(board, s, visited, row, col+1, index) ||
               dfs(board, s, visited, row-1, col, index) ||
               dfs(board, s, visited, row, col-1, index);
        visited[row][col] = false;
        
        return ret;
        }else 
            return false;
    }
}
