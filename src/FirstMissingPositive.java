/*
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/
public class Solution {
    public int firstMissingPositive(int[] A) {
        
        bucket_sort(A);
        int i = 0;
        while(i < A.length && A[i]==i+1 ){
            i++;
        }
        return i+1;
    }
    
    private void bucket_sort(int[] A){
        for (int i=0; i< A.length; ++i){
            while(A[i] != i+1 && A[i] > 0 && A[i] <= A.length && A[i]!=A[A[i]-1] ){
                int tmp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = tmp;
            }
        }
    }
}
