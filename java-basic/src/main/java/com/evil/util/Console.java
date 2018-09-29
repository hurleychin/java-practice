package com.evil.util;

import java.rmi.server.UID;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author qinhu
 * @date 2018-09-17
 */
public class Console {


    public static void out(Object x){
        System.err.println(getTime()+Thread.currentThread().toString().replace("Thread","-")+" "+x);
    }

    public static String getTime(){
        Date date=Calendar.getInstance().getTime();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        return "["+dateFormat.format(date)+"]";
    }

    public static String getUniqueId() {
        String uidStr = (new UID()).toString();
        int uidLength = uidStr.length();
        StringBuffer safeString = new StringBuffer(uidLength);

        for(int i = 0; i < uidLength; ++i) {
            char c = uidStr.charAt(i);
            if (!Character.isLetter(c) && !Character.isDigit(c)) {
                safeString.append('_');
            } else {
                safeString.append(c);
            }
        }

        return safeString.toString();
    }

    public static void main(String[] args) {
        out(getUniqueId());
    }

}
