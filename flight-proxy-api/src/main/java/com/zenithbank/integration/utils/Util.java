package com.zenithbank.integration.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Util {
    public static Date addDaysToDate(Date dt, Integer numberOfDays) throws ParseException {
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
        dt = dtf.parse(dtf.format(dt));

        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        cal.add(Calendar.DATE, numberOfDays);
        return cal.getTime();
    }
}
