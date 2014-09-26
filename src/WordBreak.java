/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        int n = s.length();
        boolean[] f = new boolean[n+1];
        f[0] = true;
        for (int i = 1; i <= n; ++i )
            for (int j = i-1; j >=0; --j){
                if (f[j] && dict.contains(s.substring(j,i)))
                    f[i] = true;
            }
        return f[n];
    }
}
