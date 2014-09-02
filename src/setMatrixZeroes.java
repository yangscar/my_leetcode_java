public class Solution {
    public void setZeroes(int[][] matrix) {
        final int row = matrix.length;
        final int col = matrix[0].length;
        boolean row_has_zero = false;
        boolean col_has_zero = false;
        
        for (int i=0; i< col ; i++)
            if (matrix[0][i] == 0) {
                row_has_zero = true;
                break;
            }
        
        for (int i = 0; i < row; i++)
            if (matrix[i][0] == 0){
                col_has_zero = true;
                break;
            }
            
        for (int i=1; i< row; i++)
            for (int j=1; j < col; j++)
                if (matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            
        for (int i=1; i <row; i++)
            for (int j=1;j < col; j++)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j]=0;
        
        if (row_has_zero)
            for (int i=0; i < col; i++)
                matrix[0][i] = 0;
        
        if (col_has_zero)
            for (int i=0; i< row; i++)
                matrix[i][0] = 0;
        
    }
}
