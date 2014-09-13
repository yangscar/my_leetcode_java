/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
*/
public class Solution {
    public int trap(int[] A) {
        final int n = A.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        for (int i = 1; i< n; ++i){
            maxLeft[i] = Math.max(maxLeft[i-1],A[i-1]);
            maxRight[n-i-1] = Math.max(maxRight[n-i],A[n-i]);
        }
        
        int sum = 0;
        
        for (int i = 0; i < n; ++i){
            int height = Math.max(0,Math.min(maxLeft[i],maxRight[i])-A[i]);
            sum+=height;
        }
        return sum;
    }
}
