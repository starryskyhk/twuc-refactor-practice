package com.twu.refactoring;

public class Date {
    private static Integer value;

    private static void verifyDate() {
        if (value < 1 || value > 31)
            throw new IllegalArgumentException("Date cannot be less than 1 or more than 31");
    }

    public static int parseDate(String dateAndTimeString) {
        try {
            String dateString = dateAndTimeString.substring(8, 10);
            value = Integer.parseInt(dateString);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Date string is less than 2 characters");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Date is not an integer");
        }
        verifyDate();
        return value;
    }
}
