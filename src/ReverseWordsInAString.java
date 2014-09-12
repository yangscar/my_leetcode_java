/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

click to show clarification.

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.

*/
public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String res = "";
        char[] chars = s.toCharArray();
        int end = chars.length;
        for (int i=chars.length-2; i>0; i--){
            if (chars[i]==' '){
                if (chars[i+1]!=' '){
                    res+=s.subSequence(i+1,end);
                    res+=" ";
                }
                end = i;
            }
        }
        res+=s.subSequence(0,end);
        return res;
    }
}
