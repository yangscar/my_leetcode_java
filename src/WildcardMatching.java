/*
mplement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
*/
public class Solution {
    public boolean isMatch(String s, String p) {
        boolean star = false;
        int S=0, P=0;
        for (; S<s.length(); ++S, ++P){
            if (P==p.length()){
                if (!star) return false;
                s=s.substring(1);
                S=-1;
                P=-1;
                continue;
            }
            switch(p.charAt(P)){
                case '?':
                    break;
                case '*':
                    star = true;
                    s=s.substring(S);
                    while(P < p.length() && p.charAt(P)=='*') P++;
                    if (P == p.length()) return true;
                    p=p.substring(P);
                    S = -1;
                    P = -1;
                    break;
                default:
                    if (s.charAt(S)!=p.charAt(P)){
                        if (!star) return false;
                        s=s.substring(1);
                        S=-1;
                        P=-1;
                    }
            }
        }
        
        while(P< p.length() && p.charAt(P) == '*') ++P;
        return P == p.length();
    }
}
