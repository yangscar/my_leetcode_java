/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        Deque<String> q = new ArrayDeque<String>();
        dfs(res,q,s,1,0);
        return res;
    }
    
    private void dfs(List<String> res, Deque<String> q, String s, int digit, int begin){
        String sub;
        if (begin >= s.length()) return;
        if (digit == 4){
            if (s.length() - begin >3 ) return;
            sub = s.substring(begin,s.length());
            if (isValid(sub)){
                q.offerLast(sub);
                res.add(toString(new ArrayDeque(q)));
                q.removeLast();
            }
        }
        
        for (int len = Math.min(3,s.length()-begin); len >0; --len){
            sub = s.substring(begin, begin+len);
            if (isValid(sub)){
                q.offerLast(sub);
                dfs(res,q,s,digit+1,begin+len);
                q.removeLast();
            }
        }
        
        return;
        
    }
    
    private boolean isValid(String s){
        
        if (s.length()>1 && s.charAt(0)=='0') return false;
        if (s.length()<3) return true;
        else if(s.charAt(0)-'0'<2)
            return true;
        else if((s.charAt(0)-'0')*100+(s.charAt(1)-'0')*10+(s.charAt(2)-'0') <256)
            return true;
        else return false;
    }
    
    private String toString(Deque<String> q){
        String s="";
        while(q.size()>1){
            s+=q.removeFirst();
            s+=".";
        }
        s+=q.removeFirst();
        return s;
    }
}
