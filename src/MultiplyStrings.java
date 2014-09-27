public class Solution {
    public String multiply(String num1, String num2) {
        return toString(multiply(toList(num1), toList(num2)));
    }
    
    private List<Integer> multiply(List<Integer> l1, List<Integer> l2){
        List<Integer> result = new ArrayList<Integer>();
        for (int offset = 0; offset < l2.size(); ++offset){
            if (l2.get(offset) != 0){
                List<Integer> tmp = multiplyDigit(l1, l2.get(offset));
                result = add(result, tmp, offset);
            }
        }
        return result;
    }
    
    private List<Integer> multiplyDigit(List<Integer> l, int digit){
        List<Integer> result = new ArrayList<Integer>();
        int carry = 0;
        for (int i: l){
            result.add((i*digit+carry) % 10);
            carry = (i*digit+carry)/10;
        }
        if (carry!=0) result.add(carry);
        return result;
    }
    
    private List<Integer> add(List<Integer> old, List<Integer> tmp, int offset){
        List<Integer> result = new ArrayList<Integer>();
        int index = 0;
        while (index < offset){
            if (index < old.size()){
                result.add(old.get(index));
            }else
                result.add(0);
            ++index;
        }
        
        int carry = 0;
        for (int i:tmp){
            int value = i+carry+(index < old.size()? old.get(index):0);
            result.add(value%10);
            carry = value /10;
            ++index;
        }
        if (carry !=0)
            result.add(carry);
        return result;
    }
    
    private List<Integer> toList(String s) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = s.length()-1; i>=0; --i){
            result.add(s.charAt(i)-'0');
        }
        return result;
    }
    
    private String toString(List<Integer> l){
        StringBuilder b = new StringBuilder();
        int i = l.size() -1;
        
        while(i>=0 && l.get(i) ==0)
            --i;
        for(;i>=0;--i){
            b.append(l.get(i));
        }
        return b.length()==0? "0": b.toString();
        
    }
    
}
