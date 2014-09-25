/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
*/
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        final int m = matrix.length;
        if (m==0) return 0;
        final int n = matrix[0].length;
        
        int[] L, R, H;
        L = new int[n];
        R = new int[n]; Arrays.fill(R,n);
        H = new int[n];
        int ret = 0;
        for (int i = 0; i < m; ++i){
            int left = 0, right = n;
            //from left to right
            for (int j = 0; j < n; ++j){
                if (matrix[i][j] == '1'){
                    H[j]++;
                    L[j] = Math.max(L[j], left);
                }else{
                    left = j+1;
                    H[j]=0;
                    L[j]=0;
                    R[j]=n;
                }
            }
            //from right to left
            for (int j = n-1; j>=0; --j){
                if (matrix[i][j] == '1'){
                    R[j] = Math.min(R[j], right);
                    ret = Math.max(ret, (R[j]-L[j])*H[j]);
                }else{
                    right = j;
                }
            }
            
        }
        return ret;
    }
}
