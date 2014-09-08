/*

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)



*/


public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer> > ans = new ArrayList<ArrayList<Integer> >();
        
        if (num.length < 3) return ans;
        Arrays.sort(num);
        final int target = 0;
        
        int left, right;
        for (int i = 0; i< num.length -2; i++ ){
            if (i> 0 && num[i] == num [i-1]) continue;
            left = i+1;
            right = num.length -1;
            while (left < right ){
                if (left > i + 1 && num[left] == num[left-1]){
                    left++;
                    continue;
                }
                if (right < num.length -1 && num[right] == num[right+1]){
                    right--;
                    continue;
                }
                if (num[i]+num[left]+num[right]==target){
                    add(ans,num[i],num[left],num[right]);
                    left++;
                } else if (num[i]+num[left]+num[right] > target){
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }
    
    private void add(ArrayList<ArrayList<Integer> > rs, int a, int b, int c){
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        tmp.add(a);
        tmp.add(b);
        tmp.add(c);
        rs.add(tmp);
    }
}
