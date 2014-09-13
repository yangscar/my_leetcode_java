/*

Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

*/

public class Solution {
    public int singleNumber(int[] A) {
        int one = 0, two = 0, three = 0;
        for (int i = 0; i < A.length; ++i){
             
            two |= (one & A[i]); // appear twice
            one ^= A[i];         // appear once
            three = ~ (one & two); // if once and twice => three times
            one &= three;
            two &= three;
        }
        return one;
    }
}
