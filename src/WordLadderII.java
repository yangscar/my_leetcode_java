public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> ans = new ArrayList<List<String>>();
        
        if (start.equals(end)){
            List<String> l = new ArrayList<String>();
            l.add(start);
            ans.add(l);
            return ans;
        }
        
        Set<String> current = new HashSet<String>();
        Set<String> next = new HashSet<String>();
        Set<String> visited = new HashSet<String>();
        Map<String, List<String>> father = new HashMap<String, List<String>>();
        boolean found = false;
        
        current.add(start);
        while(!current.isEmpty() && !found){
            for (String word: current)
                visited.add(word);
            for (String word: current){
                Set<String> new_states = extend(word, visited, dict, end);
                for (String state: new_states){
                    if (state.equals(end)) found = true;
                    next.add(state);
                    if (!father.containsKey(state))
                        father.put(state, new ArrayList());
                    father.get(state).add(word);
                }
            }
            current.clear();
            Set<String> tmpSet = current;
            current = next;
            next = tmpSet;
        }
        
        if (found){
            Deque<String> path = new ArrayDeque<String>();
            generatePath(father, path, start, end, ans);
        }
        
        return ans;
    }
    
    private void generatePath(Map<String, List<String>> father,
        Deque<String> path, final String start, final String word,
        List<List<String>> ans){
        path.offerLast(word);
        if (word.equals(start)){
            ArrayList<String> toAdd = new ArrayList<String>(path);
            Collections.reverse(toAdd);
            ans.add(toAdd);
        } else {
            for (String f: father.get(word))
                generatePath(father, path, start, f, ans);
        }
        path.removeLast();
    }
    
    private Set<String> extend(String s, Set<String> visited, Set<String> dict, String end){
        Set<String> result = new HashSet<String>();
        for (int i = 0; i < s.length(); ++i){
            char old_char =' ';
            char[] new_word = s.toCharArray();
            for (char c = 'a'; c<='z'; ++c){
                if (c == new_word[i]) continue;
                old_char = new_word[i];
                new_word[i] =c;
                String new_str = new String(new_word);
                if ((dict.contains(new_str) || new_str.equals(end))
                    && !visited.contains(new_str))
                    result.add(new_str);
                new_word[i] = old_char;
            }
            
        }
        
        return result;
    }
}
