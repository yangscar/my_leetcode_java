/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)


*/
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num.length < 4) return result;
        Arrays.sort(num);
        int last = num.length;
        
        for (int a = 0; a < last -3; ++a){
            for (int b = a+1; b < last -2; ++b){
                int c = b+1;
                int d = last-1;
                while(c < d){
                    if (num[a]+num[b]+num[c]+num[d] <target){
                        ++c;
                    }else if (num[a]+num[b]+num[c]+num[d] > target){
                        --d;
                    }else {
                        ArrayList<Integer> line = new ArrayList<Integer>();
                        line.addAll(Arrays.asList(num[a],num[b],num[c],num[d]));
                        if (!result.contains(line))
                            result.add(line);
                        ++c;
                        --d;
                    }
                }
            }
        }
        ArrayList<ArrayList<Integer>> newList = new ArrayList<ArrayList<Integer>>(new HashSet<ArrayList<Integer>>(result));
        return newList;
        
    }
}
