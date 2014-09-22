/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> sets = new ArrayList<List<String>>();
        ArrayDeque<String> queue = new ArrayDeque<String>();
        dfs(sets, queue, s, 0,1);
        return sets;
    }
    
    private boolean isPalindrome(String s, int lo, int hi){
        while(lo < hi && s.charAt(lo) == s.charAt(hi)){
            ++lo;
            --hi;
        }
        return lo >= hi;
    }
    
    
    private void dfs(List<List<String>> sets, ArrayDeque<String> queue, String s, int lo, int hi){
        if (hi == s.length()) {
            if (isPalindrome(s, lo, hi-1)){
                queue.offerLast(s.substring(lo, hi));
                sets.add(new ArrayList<String>(queue));
                queue.removeLast();
            }
            return;
        }
        
        if (isPalindrome(s, lo, hi-1)){
            queue.offerLast(s.substring(lo,hi));
            dfs(sets, queue, s, hi, hi+1);
            queue.removeLast();
        }
        dfs(sets,queue,s,lo, hi+1);
        
    }
}
