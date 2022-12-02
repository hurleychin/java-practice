package com.evil.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author qinhu at 2022-07-13
 */
public class RegexEcho {
    public static void main(String[] args) {
        Pattern pattern=Pattern.compile("^a.*c$");
        Matcher m1=pattern.matcher("abc");
        Matcher m2=pattern.matcher("abd");
        Matcher m3=pattern.matcher(" abbc");
        Matcher m4=pattern.matcher("aabbc");

        System.out.println(m1.matches());
        System.out.println(m2.matches());
        System.out.println(m3.matches());
        System.out.println(m4.matches());

    }
}
