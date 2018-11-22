package com.evil.encode;

import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author qinhu
 * @date 2018-11-15
 */
public class FileEncodeUtils {
    public static String encodeFileToBase64Binary(File file) throws Exception {
        try (FileInputStream fileInputStreamReader = new FileInputStream(file)) {
            byte[] bytes = new byte[(int) file.length()];
            fileInputStreamReader.read(bytes);
            return new String(Base64.encodeBase64(bytes), "UTF-8");
        }
    }
    public static String encodeFileToBase64Binary(String path) throws Exception {
        return encodeFileToBase64Binary(new File(path));
    }

    public static void main(String[] args) throws Exception {
       String s= encodeFileToBase64Binary("testface/face.JPG");
        System.out.println(s);
    }

}
