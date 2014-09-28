public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) throw new IllegalArgumentException("divided by 0");
        if (divisor == Integer.MIN_VALUE) 
            return dividend == Integer.MIN_VALUE? 1: 0;
        boolean negative = (dividend > 0) ^ (divisor > 0);
        boolean overflow = dividend == Integer.MIN_VALUE;
        divisor = Math.abs(divisor);
        if(overflow)
            dividend += divisor; // ?
        dividend = Math.abs(dividend);
        
        int pow = divisor;
        // double
        while((pow << 1) > 0 && dividend >= (pow << 1))
            pow <<= 1;
        
        int ans = 0;
        while(pow >= divisor){
            ans <<=1;
            if (dividend >= pow){
                dividend -=pow;
                ans++;
            }
            pow >>=1;

        }
        
        if (overflow) ++ans;
        
        return negative? -ans:ans;
    }
}
