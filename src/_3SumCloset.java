/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

*/

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int result = 0;
        int min_gap = Integer.MAX_VALUE;
        for (int i = 0; i < num.length -2; ++i){
            int j = i+1;
            int k = num.length-1;
            int sum, gap;
            while (j < k){
                sum = num[i] + num[j] + num[k];
                
                gap = Math.abs(target - sum);
                if (gap < min_gap){
                    result = sum;
                    min_gap = gap;
                }
                if (sum < target) ++j;
                else if (sum > target) --k;
                else return target;
            }
        }
        return result;
    }
}
