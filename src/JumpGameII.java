/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*/

public class Solution {
    public int jump(int[] A) {
        int step = 0;
        int last = 0; // max distance reached
        int cur = 0; // max distance can be reached by "res+1" steps
        for (int i = 0; i < A.length; ++i){
            if (i > last){
                if (cur <= last)
                    return 0;
                last = cur;
                step++;
                
            }
            cur = Math.max(cur, i+A[i]);
        }
        return step;
    }
}
