/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/
public class Solution {
    public int findMin(int[] num) {
        if (num[num.length-1] > num[0]) return num[0];
        return find(num,0,num.length-1);
    }
    
    private int find(int[] num, int lo, int hi){
        if (hi==lo) return num[lo];
        int mid = lo + (hi-lo)/2;
        if (mid < hi && num[mid] > num[mid+1]){
            return num[mid+1];
        if(lo < mid && num[mid] < num[mid-1])
            return num[mid];
        if (num[mid] < num[lo])
            return find(num, lo, mid-1);
        else 
            return find(num, mid+1, hi);
    }
}
