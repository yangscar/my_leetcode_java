public class Solution {
    final int N = 9;
    public void solveSudoku(char[][] board) {
        search(board, 0);
    }
    
    private boolean search(char[][] board, int pos){
        
        while(pos < N*N && board[pos/N][pos%N]!='.'){
            pos++;
        }
        
        if (pos >= N*N) return true;
        int row = pos/ N, col = pos %N;
        
        for (char c = '1'; c <='9'; ++c){
            if (isValid(board, row, col, c)){
                board[row][col] = c;
                if (search(board, pos+1))
                    return true;
                //board[row][col] = '.';
            }
        }
        // can not find
        board[row][col] = '.';
        return false;
        
    }
    
    private boolean isValid(char[][] board, int row, int col, char c){
        int cellRow = row/3*3, cellCol = col/3*3;
        for (int i = 0; i < 9; ++i){
            if(board[row][i] == c || board[i][col] == c || board[cellRow+i/3][cellCol+i%3] == c)
                return false;
        }
        return true;
    }
    
}
