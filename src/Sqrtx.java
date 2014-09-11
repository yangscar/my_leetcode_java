public class Solution {
    public int sqrt(int x) {
        int left = 1, right = x/2;
        int lastMid;
        if (x<2) return x;
        while(left <= right){
            int mid = left + (right-left)/2;
            if (x/mid > mid){
                left = mid+1;
            }else if(x/mid <mid){
                right = mid-1;
            }else {
                return mid;
            }
        }
        return left-1; // last left^2 <x, we add one left^2>x, so we choose left-1
    }
}
