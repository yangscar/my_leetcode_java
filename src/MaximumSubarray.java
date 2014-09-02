public class Solution {
    public int maxSubArray(int[] A) {
        if (A.length ==0) return 0;
        int max_sum = A[0], include_me_max_sum = A[0];
        for (int i=1;i<A.length;i++){
            cur_max_sum = Math.max(include_me_max_sum+A[i], A[i]);
            max_sum = Math.max(max_sum,include_me_max_sum);
        }
        return max_sum;
    }
}
