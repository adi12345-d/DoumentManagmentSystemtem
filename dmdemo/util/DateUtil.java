package com.document.dmdemo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

    public static String formatDate(Date date) {
        return dateFormat.format(date);
    }

    public static Date parseDate(String dateString) throws ParseException {
        return dateFormat.parse(dateString);
    }
}