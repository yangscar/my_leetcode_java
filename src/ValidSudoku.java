/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

*/

public class Solution {
    private boolean check(char ch, boolean[] used){
        if (ch == '.') return true;
        if (used[ch-'1']) return false;
        return used[ch-'1'] = true;
    }
    public boolean isValidSudoku(char[][] board) {
        boolean[] used = new boolean[9];
        Arrays.fill(used,false);
        for (int i = 0; i < 9; ++i){
            Arrays.fill(used, false);
            // check row
            for (int j = 0; j < 9; ++j)
                if (!check(board[i][j], used)) return false;
            Arrays.fill(used, false);
            // check column
            for (int j = 0; j < 9; ++j)
                if (!check(board[j][i], used)) return false;
        }
        
        //check sub board
        for (int r = 0; r < 3; ++r)
            for (int c = 0; c < 3; ++c){
                Arrays.fill(used, false);
                for (int i = r*3; i < r*3 +3; ++i)
                    for (int j = c*3; j < c*3+3; ++j)
                        if (!check(board[j][i], used)) return false;
                    
            }
        return true;
    }
}
