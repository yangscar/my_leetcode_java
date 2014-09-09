public class Solution {
    public int uniquePaths(int m, int n) {
        int[] f = new int[n];
        f[0]=1;
        for (int i = 0; i < m; i++)
            for (int j = 1; j < n; j++)
            // f[i][j] = f[i-1][j] + f[j-1][i];
            // f[0][j] = f[0][0]=1
            // f[i][0] = f[0][0]=1
               f[j]/*i*/ = f[j-1]/*i*/ + f[j]/*i-1*/;
               
        return f[n-1];
    }
}
