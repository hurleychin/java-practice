package com.evil.dp;

/**
 * @author qinhulin on 2020-10-22
 */
public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci fibonacci=new Fibonacci();
        for(int i=1;i<=20;i++){
            System.out.println(fibonacci.dp(i));
        }

    }

    /**
     * 时间复杂度: O(2^n)
     *      f(20)
     *      /  \
     *    f(19) f(18)
     *  2^0+2^1+2^2+....2^(n-1)
     * @param n
     * @return
     */
    public int recursive(int n){
        if(n<2){
            return n;
        }else {
            return recursive(n-1)+recursive(n-2);
        }
    }

    /**
     * 时间复杂度： O(n)
     *
     * 动态转移方程
     * n=1,f(n)=1
     * n=2,f(n)=1
     * n>2,f(n)=f(n-1)+f(n-2)
     *
     * @param n
     * @return
     */

    public int dp(int n) {
        if (n == 2 || n == 1)
            return 1;
        int prev = 1, curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }
}
