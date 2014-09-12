/*
Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
*/
public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start.equals(end)) return 1;
        
        List<String> queue = new ArrayList<String>();
        int level = 1;
        queue.add(start);
        int begin = 0;
        char[] endCharArray = end.toCharArray();
        Set<String> used = new HashSet<String>();
        used.add(start);
        
        // BFS
        while (begin < queue.size()){
            int tail = queue.size();
            for (int i = begin; i < tail; i++){
                char[] word = queue.get(i).toCharArray();
                for (int j = 0; j < word.length; j++){
                    char curChar = word[j];
                    for (char c = 'a'; c <= 'z'; c++){
                        if (c == curChar){
                            continue;
                        }
                        word[j] = c;
                        if (Arrays.equals(word,endCharArray)){
                            // exit;
                            return level + 1;
                        }
                        String nextWord = new String(word);
                        if (dict.contains(nextWord) 
                            && !used.contains(nextWord)){
                            used.add(nextWord);
                            queue.add(nextWord);
                        }
                        word[j] = curChar; // put back;
                    }
                }
            }
            level++;
            begin = tail; // forward search
        }
        return 0;
    }
}
