/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> sets = new ArrayList<List<Integer>>();
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        dfs(sets, queue, candidates, target, 0, 0);
        return sets;
    }
    private void dfs(List<List<Integer>> sets, ArrayDeque<Integer> queue, int[] can, int tar, int sum, int i){
        if (i>= can.length || sum+can[i] > tar) return;
        else if (sum+can[i] == tar){
            queue.offerLast(can[i]);
            ArrayList<Integer> toAdd = new ArrayList<Integer>(queue);
            if (!sets.contains(toAdd))
                sets.add(toAdd);
            queue.removeLast();
            return;
        }
        
        dfs(sets, queue, can, tar, sum, i+1); // not add cur
        queue.offerLast(can[i]);
        dfs(sets, queue, can, tar, sum+can[i], i); // add cur, next is cur
        dfs(sets, queue, can, tar, sum+can[i], i+1);// add cur, next +1
        queue.removeLast();
        return;
    }
}
