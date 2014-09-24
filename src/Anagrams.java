/*
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
*/
public class Solution {
    public List<String> anagrams(String[] strs) {
        Map<String, List<String>> group = new HashMap<String, List<String>>();
        List<String> result = new  ArrayList<String>();
        
        for (String s : strs){
            char[] key = s.toCharArray();
            Arrays.sort(key);
            String keyStr = new String(key);
            if (!group.containsKey(keyStr))
                group.put(keyStr,new ArrayList<String>());
            group.get(keyStr).add(s);
            
        }
        Iterator it = group.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,List<String>> entry = (Map.Entry<String,List<String>>) it.next();
            List<String> strList = entry.getValue();
            if (strList.size()>1){
                result.addAll(strList);
            }
        } 
        
        return result;
        
    }
}
