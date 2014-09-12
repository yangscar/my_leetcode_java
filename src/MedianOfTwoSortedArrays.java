/*
There are two sorted arrays A and B of size m and n respectively. 
Find the median of the two sorted arrays. 
The overall run time complexity should be O(log (m+n)).
*/


public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int total = A.length + B.length;
        if (total % 2 == 1)
            return findkth(A, B, total/2 +1);
        else 
            return (findkth(A, B, total/2)+findkth(A, B, total/2 +1))/2.0;
    }
    private int findkth(int[] A, int[] B, int k){
        int m = A.length, n = B.length;
        if (m > n) return findkth(B,A,k);
        if (m == 0) return B[k-1];
        if (k == 1) return Math.min(A[0],B[0]);
        //divide according to the k/2-1 
        int a_mid = Math.min(k/2, m), b_mid = k - a_mid;
        if (A[a_mid-1] < B[b_mid-1])
            return findkth(Arrays.copyOfRange(A,a_mid,m),B,k-a_mid);
        else if (A[a_mid-1] > B[b_mid-1])
            return findkth(A,Arrays.copyOfRange(B,b_mid,n),k-b_mid);
        else
            return A[a_mid-1];
    }
}
