

public class Solution {
    public int longestConsecutive(int[] num) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int size = num.length;
        int len = 1;
        
        for (int i = 0; i < size; i++){
            if (map.containsKey(num[i])) continue;
            map.put(num[i],1);
            // union to left old, if left has old
            if (map.containsKey(num[i]-1))
                len = Math.max(len, mergeCluster(map, num[i]-1,num[i]));
            // union to right old, if right has old
            if (map.containsKey(num[i]+1))
                len = Math.max(len, mergeCluster(map, num[i],num[i]+1));
                
            
        }
        return size == 0 ? 0 : len;
    }
    
    private int mergeCluster(HashMap<Integer, Integer> map,
                                int left, int right){
        // one of left or right must be 1, the other must be old length
        int upper = right + map.get(right) -1;
        int lower = left - map.get(left) +1;
        int len = upper - lower +1;
        map.put(upper,len);
        map.put(lower,len);
        return len;
    }
}
