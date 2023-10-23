package com.evil.string;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.junit.jupiter.api.Test;

/**
 * StringTest
 *
 * @author qinhu
 * @version 0.0.1
 * @since 2023-06-07
 */
public class StringTest {
    @Test
    public void stringJoinTest(){

        System.out.println(String.join(",","a","b","c"));

    }

    @Test
    public void stringLengthTest(){
        String str="hello,我是中国人"; //11个字符，但是占用了6+15个字节
        System.out.println(str.getBytes().length);

        String longString = "This is a long string that needs to be split into smaller parts.";
        int maxLength = 10; // 设置最大长度

        String[] parts = splitString(longString, maxLength);
        for (String part : parts) {
            System.out.println(part);
        }
    }

    @Test
    public void  stringBufferTest(){
        StringBuffer sb = new StringBuffer();
        sb.append("hello");
        sb.append(",");
        sb.append("world");
        sb.replace(0, 5, "good");
        System.out.println(sb.toString());
    }

    public static String[] splitString(String longString, int maxLength) {
        int length = longString.length();
        int numParts = (length + maxLength - 1) / maxLength; // 计算切割后的部分数量
        String[] parts = new String[numParts];

        for (int i = 0; i < numParts; i++) {
            int start = i * maxLength;
            int end = Math.min(start + maxLength, length);
            parts[i] = longString.substring(start, end);
        }

        return parts;
    }

}
