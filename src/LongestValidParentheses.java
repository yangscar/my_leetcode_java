/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/
public class Solution {
    public int longestValidParentheses(String s) {
        int maxLen = 0, lastR = -1;
        Deque<Integer> left = new ArrayDeque<Integer>();
        for (int i=0; i<s.length(); ++i){
            if (s.charAt(i) == '('){
                left.offerLast(i);
            } else {
                if (left.size() > 0){
                    // pair
                    left.removeLast();
                    if (left.size() > 0)
                        maxLen = Math.max(maxLen, i-left.peekLast());
                    else 
                        maxLen = Math.max(maxLen, i - lastR);
                } else {
                    lastR = i;
                }
            }
        }
        return maxLen;
    }
}
