package com.evil.timeinterval;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Calendar;

/**
 * @author qinhulin on 2018-05-17
 */
public class TimeInterval {
    public static void main(String[] args) throws ParseException {
        System.out.println(DateUtils.addMinutes(DateUtils.parseDate("2018-05-18 11:34", "yyyy-MM-dd HH:mm"), 10).compareTo(Calendar.getInstance().getTime()));
    }
}
