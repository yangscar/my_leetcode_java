/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

*/

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rt = new ArrayList<List<Integer>>();
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        findCombine(rt, queue, n, k, 1, 0);
        return rt;
    }
    
    private void findCombine(List<List<Integer>> rt, ArrayDeque<Integer> queue, int n, int k, int start, int cur){
        if (cur == k) {
            rt.add(new ArrayList<Integer>(queue));
            return;
        }
        for (int i = start; i <= n; ++i){
            queue.offerLast(i);
            findCombine(rt, queue, n, k, i+1, cur+1);
            queue.removeLast();
        }
    }
}
