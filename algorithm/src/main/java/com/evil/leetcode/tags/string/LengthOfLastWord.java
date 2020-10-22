package com.evil.leetcode.tags.string;

/**
 * @author qinhulin on 2020-10-22
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        String str1="Hello World";
        String str2="Hello World  ";
        System.out.println(lengthOfLastWord(str1));
        System.out.println(lengthOfLastWord(str2));
    }

    public static int lengthOfLastWord(String s){
        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' ') end--;
        if(end < 0) return 0;
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }

}
