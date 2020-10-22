package com.evil.leetcode.tags.math;

//Determine whether an integer is a palindrome. An integer is a palindrome when
//it reads the same backward as forward.
//
// Example 1:
//
//
//Input: 121
//Output: true
//
//
// Example 2:
//
//
//Input: -121
//Output: false
//Explanation: From left to right, it reads -121. From right to left, it becomes
// 121-. Therefore it is not a palindrome.
//
//
// Example 3:
//
//
//Input: 10
//Output: false
//Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
//
//
// Follow up:
//
// Coud you solve it without converting the integer to a string?
// Related Topics Math
// 👍 2560 👎 1602
public class PalindromeNumber {

    public static void main(String[] args) {
       int a=1;
       int b=314;
       int c=4114;
       int d=-151;
       int e=7170;

        System.out.println(isPalindrome(a));
        System.out.println(isPalindrome(b));
        System.out.println(isPalindrome(c));
        System.out.println(isPalindrome(d));
        System.out.println(isPalindrome(e));
    }

    public static boolean isPalindrome(int x) {

        if(x<0||(x%10==0&&x!=0)){
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == revertedNumber || x == revertedNumber/10;
    }
}
