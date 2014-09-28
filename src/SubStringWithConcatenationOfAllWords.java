/*
You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
*/
public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        Map<String, Integer> dict = new HashMap<String, Integer>();
        for (String s:L){
            if (dict.containsKey(s))
                dict.put(s,dict.get(s)+1);
            else
                dict.put(s,1);
        }
        
        
        List<Integer> ans = new ArrayList<Integer>();
        final int word_size = L[0].length();
        final int window = word_size*L.length;
        
        for (int i=0; i <= S.length() - window; ++i){
            Map<String, Integer> tmp = new HashMap<String, Integer>();
            for (int j=i; j <window+i;j+=word_size){
                String s = S.substring(j,j+word_size);
                if (!dict.containsKey(s)) break;
                if (tmp.containsKey(s))
                    tmp.put(s,tmp.get(s)+1);
                else
                    tmp.put(s,1);
            }
            if (dict.equals(tmp))
                ans.add(i);
        }
        return ans;
    }
}
