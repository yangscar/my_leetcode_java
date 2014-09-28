/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/
public class Solution {
    public String minWindow(String S, String T) {
        if (S.isEmpty() || S.length() < T.length()) return "";
        final int ASCII_MAX=256;
        int[] appeared_count = new int[ASCII_MAX];
        int[] expected_count = new int[ASCII_MAX];
        for (char c: T.toCharArray()) expected_count[c]++;
        int min_end = Integer.MAX_VALUE-1, min_start = 0;
        int start = 0;
        int appeared_c = 0;
        for (int end = 0; end<S.length(); ++end){
            if (expected_count[S.charAt(end)]>0){
                appeared_count[S.charAt(end)]++;
                if (appeared_count[S.charAt(end)] <= expected_count[S.charAt(end)]) appeared_c++;
            }
            if (appeared_c == T.length()){
                while(expected_count[S.charAt(start)]==0 ||
                      appeared_count[S.charAt(start)] > expected_count[S.charAt(start)]){
                      appeared_count[S.charAt(start)]--;
                      start++;
                }
                if (end-start+1 < min_end-min_start+1){
                    min_start = start;
                    min_end = end;
                }    
            }
        }
        
        return min_end>S.length()? "":S.substring(min_start, min_end+1);
        
    }
}
