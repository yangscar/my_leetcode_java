/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.

*/
public class Solution {
    public int longestConsecutive(int[] num) {
        HashMap<Integer, Boolean> used = new HashMap<Integer, Boolean>();
        for (int i:num) used.put(i,false);
        int longest = 0;
        
        for (int i:num){
            if (used.get(i)) continue;
            int len = 1;
            used.put(i,true);
            for (int j = i+1;used.containsKey(j)&&!used.get(j);++j){
                used.put(j,true);
                ++len;
            }
            for (int j = i-1;used.containsKey(j)&&!used.get(j);--j){
                used.put(j,true);
                ++len;
            }
            longest = Math.max(longest, len);
            
        }
        return longest;
    }
}
