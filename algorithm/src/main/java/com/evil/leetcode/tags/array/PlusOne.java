package com.evil.leetcode.tags.array;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author qinhulin on 2020-10-22
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] arr1={1,2,3};
        int[] arr2={1,9};
        int[] arr3={9,9};
        System.out.println(Arrays.toString(plusOne(arr1)));
        System.out.println(Arrays.toString(plusOne(arr2)));
        System.out.println(Arrays.toString(plusOne(arr3)));

    }

    /***
     *
     */

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if(digits[i]!=0)
                return digits;
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}
