package com.evil.file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author qinhulin
 * @date 2019-12-22
 */
public class HexoGenerateImage {
    private static String hexoSourceBase="./";
    public static void main(String[] args) throws IOException {

        if(args.length!=0){
            hexoSourceBase=args[0];
        }

       //遍历_post目录，复制_post/*/images中图片到images
        File post=new File(hexoSourceBase+"_posts");
        copyImages(post);
        System.out.println("Done!");
    }

    private static void copyImages(File root) throws IOException {
        File []files=root.listFiles();
        for(File file:files){
            //复制到./images
            if(file.isDirectory()){
                if (file.getName().contains("images")) {
                    for (File image : file.listFiles()) {
                        System.out.println("Copying image: "+image.getName());
                        FileUtils.copyFileToDirectory(image, new File(hexoSourceBase + "images"));
                    }
                }else{
                    copyImages(file);
                }
            }
        }
    }
}
