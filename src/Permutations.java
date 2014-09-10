/*
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

*/


public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer> > ans = new ArrayList<ArrayList<Integer> >();
        ArrayList<Integer> path = new ArrayList<Integer>();
        dfs(num, path, ans);
        return ans;


    }

    private void dfs(int[] num, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ans){
        if (path.size() == num.length) {
            ans.add(new ArrayList<Integer>(path));
            return;
        }
        // expand
        for (int i:num){
            if (!path.contains(i)){
                path.add(i);
                dfs(num,path,ans);
                path.remove(path.size()-1);
            }
        }
    }
}
