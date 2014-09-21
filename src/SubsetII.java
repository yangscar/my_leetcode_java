/*
Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        subsets.add(new ArrayList<Integer>());
        int last = 1;
        for (int i = 0; i < num.length; ++i){
            int start = 0;
            if (i > 0 && num[i] == num[i-1])
                start = last; //last last
            last = subsets.size();
            for (int j = start; j < last; ++j){
                List<Integer> subset = new ArrayList<Integer>(subsets.get(j));
                subset.add(num[i]);
                subsets.add(subset);
            }
        }
        return subsets;
    }
}
