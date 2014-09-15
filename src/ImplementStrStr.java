public class Solution {
    // kmp
    public String strStr(String haystack, String needle) {
        
        
        final int n = haystack.length(), m = needle.length();
        if (haystack == null || needle == null || m > n) {
                return null;
            }
        if (needle == "") {
                return haystack;
        }
        
        
        // calc the next array
        char[] P = needle.toCharArray();
        int[] next = new int[m];
        int j = -1, i = 0;
        next[0] = j; // -1 is '*'
        while(i < m-1)
            if ( j < 0 || P[j] == P[i]){
                j++;i++;
                next[i] = (P[j] != P[i]) ? j: next[j]; //use the failure info
            } else
                j = next[j];
    
        j = 0; i = 0;
        char[] T = haystack.toCharArray();
        while ((j < m) && (i < n))
             if ( j < 0 || P[j] == T[i]){
                j++;i++;
            } else
                j = next[j];
                
        // whether pattern str is test complete while all test str tested.
        return (i-j > n - m )? null: haystack.substring(i-j);
        
    }
}
