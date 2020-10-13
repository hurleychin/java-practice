package com.evil.leetcode.difficulty.easy;

/**
 * @author qinhulin on 2020-09-28
 */
public class ImplementStrStr {
    public static void main(String[] args) {
        String haystack = "hello", needle = "ll" ;
        System.out.println(strStr(haystack,needle));

    }

    public static int strStr(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();

        for (int start = 0; start < n - L + 1; ++start) {
            if (haystack.substring(start, start + L).equals(needle)) {
                return start;
            }
        }
        return -1;
    }
}
