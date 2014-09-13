public class Solution {
    class Pair<T1,T2>{
        public T1 first;
        public T2 second;
        Pair(T1 first, T2 second){
            this.first = first;
            this.second = second;
        }
    }
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num.length < 4) return result;
        Arrays.sort(num);
        int last = num.length;
        ArrayList<Pair<Integer, Integer>> list;
        HashMap<Integer, ArrayList<Pair<Integer, Integer>>> cache = new HashMap<Integer, ArrayList<Pair<Integer, Integer>>>();
        for (int a = 0; a < last-3; ++a){
            for (int b = a+1; b < last-2; ++b){
                int key = num[a]+num[b];
                if (!cache.containsKey(key))
                    cache.put(key, new ArrayList<Pair<Integer, Integer>>());
                list = cache.get(key);
                list.add(new Pair<Integer, Integer>(a,b));
            }
        }
        
        for (int c = 2; c < last-1; ++c){
            for (int d = c+1; d < last; ++d){
                final int key = target - num[c]-num[d];
                if (!cache.containsKey(key)) continue;
                list = cache.get(key);
                for (int i = 0; i < list.size(); ++i){
                    if (c <= list.get(i).second) continue;
                    ArrayList<Integer> line = new ArrayList<Integer>();
                    line.addAll(Arrays.asList(num[list.get(i).first],num[list.get(i).second],num[c],num[d]));
                    if (!result.contains(line)) result.add(line);
                }
            }
        }
        return result;
    }
}
