package com.evil.leetcode.difficulty.easy;

//Roman numerals are represented by seven different symbols: I, V, X, L, C, D an
//d M.
//
//
//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
//
// For example, two is written as II in Roman numeral, just two one's added toge
//ther. Twelve is written as, XII, which is simply X + II. The number twenty seven
// is written as XXVII, which is XX + V + II.
//
// Roman numerals are usually written largest to smallest from left to right. Ho
//wever, the numeral for four is not IIII. Instead, the number four is written as
//IV. Because the one is before the five we subtract it making four. The same prin
//ciple applies to the number nine, which is written as IX. There are six instance
//s where subtraction is used:
//
//
// I can be placed before V (5) and X (10) to make 4 and 9.
// X can be placed before L (50) and C (100) to make 40 and 90.
// C can be placed before D (500) and M (1000) to make 400 and 900.
//
//
// Given a roman numeral, convert it to an integer. Input is guaranteed to be wi
//thin the range from 1 to 3999.
//
// Example 1:
//
//
//Input: "III"
//Output: 3
//
// Example 2:
//
//
//Input: "IV"
//Output: 4
//
// Example 3:
//
//
//Input: "IX"
//Output: 9
//
// Example 4:
//
//
//Input: "LVIII"
//Output: 58
//Explanation: L = 50, V= 5, III = 3.
//
//
// Example 5:
//
//
//Input: "MCMXCIV"
//Output: 1994
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
// Related Topics Math String
// 👍 2501 👎 3676

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        String s1="III"; //3
        String s2="IV";  //4
        String s3="IX";  //9
        String s4="LVIII";//50+8=58
        String s5="MCMXCIV"; //1000+900+90+4=1994
        System.out.println(romanToInt(s1));
        System.out.println(romanToInt(s2));
        System.out.println(romanToInt(s3));
        System.out.println(romanToInt(s4));
        System.out.println(romanToInt(s5));
    }

    public static int romanToInt(String s) {
        //Symbol       Value
        //I             1
        //IV            4
        //V             5
        //IX            9
        //X             10
        //XL            40
        //L             50
        //XC            90
        //C             100
        //CD            400
        //D             500
        //CM            900
        //M             1000
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int ans = 0;
        for (int i = 0; i < s.length(); ) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                ans += map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                ans += map.get(s.substring(i, i + 1));
                i++;
            }
        }
        return ans;

    }
}
