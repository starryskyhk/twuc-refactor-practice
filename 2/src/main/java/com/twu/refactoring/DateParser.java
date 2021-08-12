package com.twu.refactoring;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

public class DateParser {
    private final String dateAndTimeString;
    private static final HashMap<String, TimeZone> KNOWN_TIME_ZONES = new HashMap<>();

    static {
        KNOWN_TIME_ZONES.put("UTC", TimeZone.getTimeZone("UTC"));
    }

    /**
     * Takes a date in ISO 8601 format and returns a date
     *
     * @param dateAndTimeString - should be in format ISO 8601 format
     *                          examples -
     *                          2012-06-17 is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17TZ is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17T15:00Z is 17th June 2012 - 15:00 in UTC TimeZone
     */
    public DateParser(String dateAndTimeString) {
        this.dateAndTimeString = dateAndTimeString;
    }

    public Date parse() {
        int year, month, date, hour, minute;

        //获取到年份字符串
        year = Year.parse(dateAndTimeString);
        //获取月份的字符串
        month = Month.parseMonth(dateAndTimeString);

        //获取日期的字符串
        date = com.twu.refactoring.Date.parseDate(dateAndTimeString);
        //如果是零点
        if (Time.dateZero(dateAndTimeString)) {
            hour = 0;
            minute = 0;
        } else {
            hour = Time.parseHour(dateAndTimeString);
            minute = Time.parseMinute(dateAndTimeString);

        }

        return getCalendar(year, month - 1, date, hour, minute).getTime();
    }

    private Calendar getCalendar(int year, int month, int date, int hour, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(KNOWN_TIME_ZONES.get("UTC"));
        calendar.set(year, month, date, hour, minute, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }
}
