/*Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.

click to show corner cases.

Corner Cases:
A line other than the last line might contain only one word. What should you do in this case?
In this case, that line should be left-justified.*/
public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> res = new ArrayList<String>();
        final int n = words.length;
        int begin = 0, len = 0;
        for (int i = 0; i < n; ++i){
            if (len + words[i].length() + (i-begin) > L){
                res.add(connect(words, begin, i-1, len, L, false));
                begin = i;
                len = 0;
            } 
            len += words[i].length();
        }
        res.add(connect(words, begin, n-1, len, L, true));
        return res;
    }
    
    private String connect(String[] words, int begin, int end, int len, int L, boolean is_last){
        String s="";
        int n = end - begin + 1;
        for (int i = 0; i < n; ++i){
            s += words[begin+i];
            s=addSpaces(s, i, n-1, L-len, is_last);
        }
        
        while (s.length() < L) s+=' ';
        return s;
    }
    
    private String addSpaces(String s, int i, int n, int L, boolean is_last){
        if (n < 1 || i > n-1) return s;
        int spaces = is_last? 1: (L/n + (i<(L % n)? 1:0));
        while (spaces-- >0){
            s+=" ";
        }
        return s;
    }
}
