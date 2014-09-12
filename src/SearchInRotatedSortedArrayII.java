/*
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
*/
public class Solution {
    public boolean search(int[] A, int target) {
        int first = 0, last = A.length;
        while(first < last){
            final int mid = (first + last)/2;
            if (A[mid] == target)
                return true;
            if (A[first] < A[mid]){
                if (A[first] <= target && target < A[mid])
                    last = mid;
                else 
                    first = mid + 1;
            } else if (A[first] > A[mid]){
                if (A[mid] < target && target <= A[last-1])
                    first = mid+1;
                else 
                    last = mid;
            } else
                // when equal, the 'first' must be contained in the [2,end), skip
                ++first;
        }
        return false;
        
    }
}
