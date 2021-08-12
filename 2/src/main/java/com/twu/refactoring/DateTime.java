package com.twu.refactoring;

import java.util.Calendar;
import java.util.TimeZone;

public class DateTime {
    private final Year year = new Year();
    private final Month month = new Month();
    private final Date date = new Date();
    private final Time time = new Time();

    public Calendar parse(String dateAndTimeString, TimeZone timeZone) {
        year.setValue(year.parse(dateAndTimeString));
        month.setValue(month.parseMonth(dateAndTimeString));
        date.setValue(date.parseDate(dateAndTimeString));
        time.setHour(time.parseHour(dateAndTimeString));
        time.setMinute(time.parseMinute(dateAndTimeString));
        return getCalendar(timeZone);
    }

    private Calendar getCalendar(TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(timeZone);
        calendar.set(year.getValue(), month.getValue() - 1, date.getValue(), time.getHour(), time.getMinute(), 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }
}
