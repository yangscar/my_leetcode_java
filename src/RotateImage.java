/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?

*/


public class Solution {
    public void rotate(int[][] matrix) {
        final int n = matrix.length;
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n-i; j++)
                swap(matrix, i, j, n-1-j, n-1-i);
        for (int i = 0; i < n/2; i++)
            for (int j = 0; j < n; j++)
                swap(matrix, i, j, n-1-i,j);
            
    }
    private void swap (int[][] m, int i, int j, int a, int b){
        int tmp = m[i][j];
        m[i][j]=m[a][b];
        m[a][b]=tmp;
    }
}
