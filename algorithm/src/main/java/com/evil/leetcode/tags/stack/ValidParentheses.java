package com.evil.leetcode.tags.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author qinhulin on 2020-09-27
 */
public class ValidParentheses {


    public static void main(String[] args) {
        String s1 = "{([])}";
        String s2 = "[]{}()";
        String s3 = "[[]{}()[";
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid(s1));
        System.out.println(validParentheses.isValid(s2));
        System.out.println(validParentheses.isValid(s3));

    }

    private Map<Character, Character> map = new HashMap<>();

    public ValidParentheses() {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }

    // { push
    // ( push
    // [ push
    // ] map.get==[ pop==[
    // ) map.get==( pop==(
    //...

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!map.containsKey(c)) {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && !stack.pop().equals(map.get(c))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
