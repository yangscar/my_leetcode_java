/*
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
*/
public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        final int n = s.length();
        boolean[] f = new boolean[n+1];
        boolean[][] cut = new boolean[n][n+1];
        f[0] = true;
        for (int i = 1; i<=n; ++i)
            for(int j=i-1; j>=0; --j)
                if (f[j] && dict.contains(s.substring(j,i))){
                    f[i] = true;
                    cut[j][i] = true;// [j,i) is a feasible word.
                }
        List<String> res = new ArrayList<String>();
        Deque<String> path = new ArrayDeque<String>();
        dfs(s, cut, s.length(), path, res);
        return res;
        
    }
    
    private void dfs(String s, boolean[][] cut, int cur, Deque<String> path, List<String> res){
        if(cur == 0){
            String tmp="";
            for(String str:path){
                tmp += str + " ";
            }
            tmp = tmp.substring(0, tmp.length()-1);
            res.add(tmp);
        }
        
        for (int i=cur-1; i >=0; --i){
            if (cut[i][cur]){
                path.offerFirst(s.substring(i,cur));
                dfs(s, cut, i, path, res);
                path.removeFirst();
            }
        }
    }
}
