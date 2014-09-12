/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

public class Solution {
    public int search(int[] A, int target) {
        int first = 0, last = A.length;
        while(first < last){
            int mid = (first + last)>>1;
            if (A[mid] == target)
                return mid;
            else if (A[first] <= A[mid]){ // one period alway monotonic(单调)
                if (A[first] <= target && target < A[mid]) //PA <=
                    last = mid;
                else
                    first = mid + 1;
            }else {
                if (A[mid] < target && target <= A[last-1]) //PA <=
                    first = mid +1;
                else
                    last = mid;
            }
        }
        return -1;
    }
}
