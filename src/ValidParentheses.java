/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> queue = new ArrayDeque();
        HashMap<Character, Character> mp = new HashMap<Character, Character>();
        mp.put(')','(');
        mp.put(']','[');
        mp.put('}','{');
        mp.put('(','*');
        mp.put('[','*');
        mp.put('{','*');
        for (int i=0; i< s.length(); ++i){
            char cur = s.charAt(i);
            
            if (queue.isEmpty() || mp.get(cur)=='*'){
                queue.offerLast(cur);
            }else if (queue.peekLast() == mp.get(cur)){
                queue.removeLast();
            }else {
                queue.offerLast(cur);
            }
        }
        return queue.isEmpty();
    }
}
