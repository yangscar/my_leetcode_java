public class Solution {
    public double pow(double x, int n) {
        boolean overflow = false;
        if (n == Integer.MIN_VALUE){
            overflow = true;
            ++n;
        }
        
        if (n==0 )
            return 1;
        else if (n>0)
            return power(x, n);
        else
            return overflow? 1/(power(x,-n)*x) :1 / power(x,-n);
    }
    private double power(double x, int n){
        if (n == 1) return x;
        double tmp = power(x, n/2);
        if (n % 2 == 0)
            return tmp*tmp;
        else
            return tmp*tmp*x;
    }
}
