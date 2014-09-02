public class Solution {
    private int[] stand_cols, main_diag, anti_diag;
    private int total_num;
    public int totalNQueens(int n) {
        stand_cols = new int[n];
        main_diag = new int[2*n];
        anti_diag = new int[2*n];
        int[] C = new int[n];
        total_num = 0;
        dfs(C,0);
        return total_num;
    }

    private boolean isValid(int row, int col, int[] C){
        int N = C.length;
        return stand_cols[col] == 0 && main_diag[row+col] ==0 &&
             anti_diag[row+N-col]==0;
    }
    
    
    
    private void dfs(int[] C, int row){
        final int N = C.length;
        if (row == N){
            total_num++;
            return;
        }
        
        for (int i = 0; i < N; ++i){
            if (isValid(row, i, C)){
                C[row]=(i);
                stand_cols[i] = main_diag[row+i] = anti_diag[row+N-i] = 1;
                dfs(C,row+1);
                stand_cols[i] = main_diag[row+i] = anti_diag[row+N-i] = 0;
            }
        }
    }
}
