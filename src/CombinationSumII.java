public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        dfs(ans, queue, num, 0, 0, target);
        return ans;
    }
    
    private void dfs(List<List<Integer>> ans, ArrayDeque<Integer> queue, int[] num, int i, int sum, int target){
        if (i>= num.length || sum + num[i] > target) return;
        if (sum + num[i] == target){
            queue.offerLast(num[i]);
            ArrayList<Integer> tmp = new ArrayList<Integer>(queue);
            if (!ans.contains(tmp))
                ans.add(tmp);
            queue.removeLast();
            return;
        }
        
        dfs(ans, queue, num, i+1, sum, target);
        queue.offerLast(num[i]);
        dfs(ans, queue, num, i+1, sum+num[i],target);
        queue.removeLast();
        
    }
}
