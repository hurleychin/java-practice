package com.evil.ntp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;


public final class TimeClient {

    public static void main(String[] args) {
        String webUrl1 = "http://www.taobao111111.com";// 淘宝
        String webUrl2 = "http://www.baidu.com";// 百度
        String webUrl3 = "http://www.360.cn";// 360
        String webUrl4 = "http://www.163.com/";// 网易
        String webUrl5 = "http://www.ntsc.ac.cn";// 中国科学院国家授时中心
        System.out.println(getNetworkTime(webUrl1) + " [淘宝]");
        System.out.println(getNetworkTime(webUrl2) + " [百度]");
        System.out.println(getNetworkTime(webUrl3) + " [360]");
        System.out.println(getNetworkTime(webUrl4) + " [网易]");
        System.out.println(getNetworkTime(webUrl5) + " [中国科学院国家授时中心]");
    }

    public static String getNetworkTime(String webUrl)  {

        URLConnection conn = null;
        try {
            URL url = new URL(webUrl);
            conn = url.openConnection();
            conn.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        long dateL = conn.getDate();
            Date date = new Date(dateL);
            SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
            return dateFormat.format(date);
    }


}
