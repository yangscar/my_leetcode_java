public class Solution {
    private int[] stand_cols, main_diag, anti_diag;
    public List<String[]> solveNQueens(int n) {
        stand_cols = new int[n];
        main_diag = new int[2*n];
        anti_diag = new int[2*n];
        List<String[]> result = new ArrayList<String[]>();
        int[] C = new int[n];
        dfs(C,result,0);
        return result;
    }
    
    private boolean isValid(int row, int col, int[] C){
        int N = C.length;
        return stand_cols[col] == 0 && main_diag[row+col] ==0 &&
             anti_diag[row+N-col]==0;
    }
    
    private String[] toSolution(int[] C) {
        final int N = C.length;
        String[] result = new String[N];
        for (int i = 0; i< N; ++i){
            String s = "";
            for (int j =0; j<N; ++j){
                if (j!=C[i])
                    s+='.';
                else
                    s+='Q';
            }
            result[i] = s;
        }
        return result;
    }
    
    private void dfs(int[] C, List<String[]> result, int row){
        final int N = C.length;
        if (row == N){
            result.add(toSolution(C));
            return;
        }
        
        for (int i = 0; i < N; ++i){
            if (isValid(row, i, C)){
                C[row]=(i);
                stand_cols[i] = main_diag[row+i] = anti_diag[row+N-i] = 1;
                dfs(C,result,row+1);
                
                stand_cols[i] = main_diag[row+i] = anti_diag[row+N-i] = 0;
            }
        }
    }
}
