/*
XOR; 
can be extended to even cases
*/

public class Solution {
    public int singleNumber(int[] A) {
        int x = 0;
        for (int i = 0; i < A.length; ++i){
            x ^= A[i];
        }
        return x;
    }
}
