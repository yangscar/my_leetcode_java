/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"

*/

public class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<String>();
        if (n == 0) {ans.add(""); return ans;}
        if (n == 1) {ans.add("()");return ans;}
        
        for (int i = 0; i < n; i++)
            for (String inner: generateParenthesis(i))
                for (String outer: generateParenthesis(n-i-1))
                    ans.add("("+inner+")"+outer);
        
        
        return ans;
    }
}
