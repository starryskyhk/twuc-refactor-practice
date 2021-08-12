package com.twu.refactoring;

public class Time {
    private static Integer hour;
    private static Integer minute;

    public static boolean dateZero(String dateAndTimeString) {
        return dateAndTimeString.charAt(11) == 'Z';
    }


    public static int parseMinute(String dateAndTimeString) {
        try {
            String minuteString = dateAndTimeString.substring(14, 16);
            minute = Integer.parseInt(minuteString);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Minute string is less than 2 characters");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Minute is not an integer");
        }
        verifyMinute();
        return minute;
    }
    private static void verifyMinute() {
        if (minute < 0 || minute > 59)
            throw new IllegalArgumentException("Minute cannot be less than 0 or more than 59");
    }

    private static void verifyHour() {
        if (hour < 0 || hour > 23)
            throw new IllegalArgumentException("Hour cannot be less than 0 or more than 23");
    }

    public static int parseHour(String dateAndTimeString) {
        try {
            String hourString = dateAndTimeString.substring(11, 13);
            hour = Integer.parseInt(hourString);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Hour string is less than 2 characters");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Hour is not an integer");
        }
        verifyHour();
        return hour;
    }
}
