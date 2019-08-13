package com.evil.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author qinhulin on 2019-02-27
 */
public class DateInterval {

    // startDate <= date < endDate
    static final String startDate = "2019-02-20";
    static final String endDate = "2019-03-05";
    static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws ParseException {

        Date start = format.parse(startDate);
        Date end = format.parse(endDate);

        Date offset = start;
        do {
            System.out.println(format.format(offset));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(offset);
            calendar.add(Calendar.DATE, 1);
            offset = calendar.getTime();
        } while (offset.before(end));
    }
}
