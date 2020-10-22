package com.evil.leetcode.tags.math;

/**
 * @author qinhulin on 2020-09-21
 */
public class ReverseInteger {
    public static void main(String[] args) {
        int a = 123; // ->  321
        int b = -123; //-> -321
        int c = 120;  //-> 21

        System.out.println(reverse(a));
        System.out.println(reverse(b));
        System.out.println(reverse(c));


    }

    /**
     * //pop operation:
     * pop = x % 10;
     * x /= 10;
     * <p>
     * //push operation:
     * temp = rev * 10 + pop;
     * rev = temp;
     *
     * Time Complexity: log(x)
     * Space Complexity: O(1).
     *
     * @param x
     * @return
     */

    public static int reverse(int x) {

        int rev = 0;

        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            //21474836417 ~ -21474836418
            if(rev>Integer.MAX_VALUE/10||(rev==Integer.MAX_VALUE/10&&pop>7)) return 0;
            if(rev<Integer.MIN_VALUE/10||(rev==Integer.MIN_VALUE/10&&pop<-8)) return 0;

            rev = rev * 10 + pop;
        }
        return rev;

    }

}
