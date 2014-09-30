/*
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
*/
public class Solution {
    enum Input{
            INVALID,    //0
            SPACE,      //1
            SIGN,       //2
            DIGIT,      //3
            DOT,        //4
            EXPONENT,   //5
            NUM_INPUTS  //6
        }
    public boolean isNumber(String s) {
        
        int[][] next = {
            {-1, 0, 1, 3, 2, -1},     //0
            {-1, -1, -1, 3, 2, -1},   //1
            {-1, -1, -1, 6, -1, -1},  //2
            {-1, -1, -1, 3, 8, 4},    //3
            {-1, -1, 5, 7, -1, -1},   //4
            {-1, -1, -1, 7,-1, -1},   //5   
            {-1, -1, -1, 6, -1, 4},   //6
            {-1, -1, -1, 7, -1, -1},  //7
            {-1, -1, -1, 6, -1, 4}    //8
        };
        s = s.trim();
        int state = 0;
        for (int i = 0;i < s.length(); ++i){
            Input input = Input.INVALID;
            char ch = s.charAt(i);
            if (Character.isSpace(ch))
                input = Input.SPACE;
            else if (Character.isDigit(ch))
                input = Input.DIGIT;
            else if (ch=='.')
                input = Input.DOT;
            else if (ch=='E' || ch =='e')
                input = Input.EXPONENT;
            else if (ch =='+' || ch == '-')
                input = Input.SIGN;
            
            state = next[state][input.ordinal()];
            if (state == -1) return false;
        }
        return state == 3 || state == 6 || state == 7 || state ==8;
    }
}
