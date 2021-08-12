package com.twu.refactoring;


public class Year {

    private static Integer value;

    public Integer parse(String dateAndTimeString) {
        try {
            String yearString = dateAndTimeString.substring(0, 4);
            value = Integer.parseInt(yearString);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Year string is less than 4 characters");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Year is not an integer");
        }
        verifyYear();
        return value;
    }


    private void verifyYear() {
        if (value < 2000 || value > 2012)
            throw new IllegalArgumentException("Year cannot be less than 2000 or more than 2012");
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        Year.value = value;
    }
}
