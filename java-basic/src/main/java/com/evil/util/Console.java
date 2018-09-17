package com.evil.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author qinhu
 * @date 2018-09-17
 */
public class Console {


    public static void out(Object x){
        System.out.println(getNow()+Thread.currentThread().toString().replace("Thread","-")+" "+x);
    }

    public static String getNow(){
        Date date=Calendar.getInstance().getTime();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        return "["+dateFormat.format(date)+"]";
    }

}
