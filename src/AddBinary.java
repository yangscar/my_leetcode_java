/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder re = new StringBuilder();
        int i = a.length() -1;
        int j = b.length() -1;
        int next_add = 0;
        while(i >= 0 || j >= 0 || next_add > 0){
            int ai = i < 0 ? 0 : a.charAt(i) - '0';
            int bi = j < 0 ? 0 : b.charAt(j) - '0';
            re.append((ai+bi+next_add)%2);
            next_add = (ai+bi+next_add)/2;
            --i;
            --j;
        }
        return re.reverse().toString();
    }
}
