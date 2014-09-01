/**
 * Created by neuralyang on 9/1/14.
 */

public class Solution {
    public int numTrees(int n) {
        if (n<2) return 1;
        int sum =0;
        for (int k=0; k<n;k++)
            sum+=numTrees(k)*numTrees(n-k-1);
        return sum;
    }
}
