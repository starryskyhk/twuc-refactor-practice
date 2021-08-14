package com.twu.refactoring;

import java.util.Arrays;

public class Negative extends Operation{
    public Negative(int... numbers) {
        super(numbers);
    }

    public int countNegative() {
        return (int) Arrays.stream(numbers).filter(number -> number < 0).count();
    }
}
