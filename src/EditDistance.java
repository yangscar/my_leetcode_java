/*
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
*/

public class Solution {
    public int minDistance(String word1, String word2) {
        final int m = word1.length(), n = word2.length();
        int[][] f = new int[m+1][n+1];
        for (int i = 0; i <= m; ++i)
            f[i][0] = i;
        for (int j = 0; j <= n; ++j)
            f[0][j] = j;
        
        for (int i = 1; i <= m; ++i)
            for (int j = 1; j <= n; ++j){
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    f[i][j] = f[i-1][j-1];
                else
                    f[i][j] = 1 + Math.min(Math.min(f[i-1][j],f[i][j-1]),f[i-1][j-1]);
            }
        
        return f[m][n];
    }
}
