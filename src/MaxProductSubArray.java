/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/
public class Solution {
    public int maxProduct(int[] A) {
        final int n = A.length;
        int[] min = new int[n];
        int[] max = new int[n];
        
        min[0] = A[0];
        max[0] = A[0];
        int max_res=max[0];
        for (int i=1; i < n; ++i){
            min[i] = Math.min(A[i],Math.min(min[i-1]*A[i],max[i-1]*A[i]));
            max[i] = Math.max(A[i],Math.max(min[i-1]*A[i],max[i-1]*A[i]));
            max_res = Math.max(max_res, max[i]);
        }
        return max_res;
    }
}
