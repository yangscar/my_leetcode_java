/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].
*/

public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length <= 2) return A.length;
        int index = 2;
        for (int i = 2; i < A.length; i++){
            //A[index] always copy the unduplicated array of A[i]
            if (A[i] != A[index-2]) A[index++] = A[i];
        }
        return index;
    }
}
