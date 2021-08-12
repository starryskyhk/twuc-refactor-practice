package com.twu.refactoring;

public class Month {
    private static Integer value;

    public static int parseMonth(String dateAndTimeString) {
        try {
            String monthString = dateAndTimeString.substring(5, 7);
            value = Integer.parseInt(monthString);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Month string is less than 2 characters");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Month is not an integer");
        }
        verifyMonth();
        return value;
    }


    private static void verifyMonth() {
        if (value < 1 || value > 12)
            throw new IllegalArgumentException("Month cannot be less than 1 or more than 12");
    }
}
