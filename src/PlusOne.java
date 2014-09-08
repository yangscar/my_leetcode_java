/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/


public class Solution {
    public int[] plusOne(int[] digits) {
        int to_plus = 1;
        for (int i = digits.length -1; i>=0; i--){
            digits[i] += to_plus;
            if (digits[i] == 10){
                digits[i]=0;
            } else {
                to_plus = 0;
                break;
            }
        }
        int[] re;
        
        if (to_plus == 1) {
            re = new int[digits.length + 1];
            System.arraycopy(digits,0,re,1,digits.length);
            re[0] = 1;
            return re;
        }else return digits;
        
    }
}
