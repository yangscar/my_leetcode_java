/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.
*/


public class Solution {
    private int[][] f ; // temp area
    private int dfs(int x, int y){
        if (x < 1 || y < 1) return 0;
        if (x == 1 && y == 1) return 1;
        return getOrUpdate(x-1,y) + getOrUpdate(x, y-1);
    }
    private int getOrUpdate(int x, int y){
        if (f[x][y] > 0) return f[x][y];
        else return f[x][y] = dfs(x,y);
    }
    public int uniquePaths(int m, int n) {
        f = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++)
            for (int j = 0; j < n+1; j++)
                f[i][j]=0;
        return getOrUpdate(m,n);
    }
    
    
}
