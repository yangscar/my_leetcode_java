/*

Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/
public class Solution {
    public int[] searchRange(int[] A, int target) {
        int lower = lower_bound(A, 0, A.length, target);
        int upper = upper_bound(A, lower, A.length, target);
        if (lower == A.length || A[lower] != target)
            return new int[]{-1, -1};
        else 
            return new int[]{lower, upper-1};
        
        
    }
    private int lower_bound(int[] A, int start, int end, int value){
        while(start!=end){
            int mid = start+(end-start)/2;
            if (value > A[mid]) start = ++mid;
            else end = mid;
        }
        return start;
    }
    private int upper_bound(int[] A, int start, int end, int value){
        while(start!=end){
            int mid = start+(end-start)/2;
            if (value >= A[mid]) start = ++mid;
            else end = mid;
        }
        return start;
    }
}
