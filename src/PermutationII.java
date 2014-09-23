/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
*/



public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        do {
            List<Integer> l = new ArrayList<Integer>();
            for (int n: num){
                l.add(n);
            }
            ans.add(l);
        } while(nextPermutation(num));
        return ans;
        
    }
    
    private boolean nextPermutation(int[] num){
        if (num.length <= 1) return false;
        int i, h;
        for (i=num.length-1; i > 0; --i){
            if (num[i-1] < num[i])
                break;
        }
        
        if (i==0){
            reverse(num, 0, num.length);
            return false;
        }
        
        for (h=num.length-1; h > 0; --h){
            if (num[i-1] < num[h])
                break;
        }
        
        swap(num, i-1, h);
        reverse(num, i, num.length);
        return true;
        
    }
    
    private void reverse(int[] num, int lo, int hi){
        --hi;
        while(hi>lo)
          swap(num, lo++, hi--);
    }
    private void swap(int[] num, int a, int b){
        int temp = num[a];
        num[a]= num[b];
        num[b] = temp;
    }
}
