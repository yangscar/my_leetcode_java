public class Solution {
    public int findMin(int[] num) {
        return find(num,0,num.length-1);
    }
    
    private int find(int[] a, int l, int r){
        while (l < r && a[l] >= a[r]){
            int m = l + (r-l)/2;
            if (a[m] > a[l])
                l = m + 1;
            else if (a[m] < a[l])
                r = m;
            else
                ++l;
        }
        return a[l];
    }
}
