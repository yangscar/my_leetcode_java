public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length()!=s1.length()+s2.length()) return false;
        if (s1.length() < s2.length()) return isInterleave(s2, s1, s3);
        boolean[] f = new boolean[s2.length()+1];
        f[0]= true;

        for (int i = 1; i <=s2.length(); ++i)
            f[i] = f[i-1] && s2.charAt(i-1) == s3.charAt(i-1);
        
        for (int i = 1; i <=s1.length(); ++i){
            f[0] = f[0] && s1.charAt(i-1) == s3.charAt(i-1);
            for(int j = 1; j<=s2.length();++j)
                f[j] = (s1.charAt(i-1)==s3.charAt(i+j-1) && f[j]) 
                        || (s2.charAt(j-1)==s3.charAt(i+j-1) && f[j-1]);
        }
        return f[s2.length()];
    }
}
