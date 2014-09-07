/*


Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

*/








public class Solution {
    public void sortColors(int[] A) {
        int left =0, right = A.length -1, cur =0;
        while (cur <= right) {
            if (A[cur] == 0){
                if (left == cur) {
                    left++;
                    cur++;
                    continue;
                }
                A[cur] = A[left];
                A[left++] = 0;
            }else if (A[cur]==2){
                A[cur] = A[right];
                A[right--] = 2;
            }else cur++;
        }
        
    }
}
