/*
利用康托编码的思路,假设有n个不重复的元素,第k个排列是a1,a2,a3,...,an,那么a1 是 哪一个位置呢?
我们把 a1 去掉,那么剩下的排列为 a2, a3, ..., an, 共计 n − 1 个元素,n − 1 个元素共有 (n − 1)! 个排列,于是就可以知道 a1 = k/(n − 1)!。
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/



public class Solution {
    private int factorial(int n){
        int res = 1;
        for (int i = 1; i <= n; ++i)
            res *= i;
        return res;
    }
    public String getPermutation(int n, int k) {
        --k;
        char[] ans=new char[n];
        boolean[] visit = new boolean[10];
        Arrays.fill(visit, false);
        for (int i = 0,j; i < n; ++i){
            final int fact = factorial(n-i-1);
            int t = k / fact;
            for (j = 1; j<= n; ++j){
                if (!visit[j-1]){
                    if (t==0) break;
                    --t;
                }
            }
            ans[i] = (char)(j+'0');
            visit[j-1] = true;
            k %= fact;
        }
        
        return String.valueOf(ans);
        
    }
}
