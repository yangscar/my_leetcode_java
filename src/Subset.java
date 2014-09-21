/*
Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> rt = new ArrayList<List<Integer>>();
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        Arrays.sort(S);
        dfs(rt, queue, S, 0);
        return rt;
    }
    
    private void dfs(List<List<Integer>> rt, ArrayDeque<Integer> queue, int[] s,int step){
        if (step == s.length) {
            rt.add(new ArrayList<Integer>(queue));
            return;
        }
        // choose 
        queue.offerLast(s[step]);
        dfs(rt, queue, s, step+1);
        queue.removeLast();
        //not choose
        dfs(rt, queue, s, step+1);
    }
}
