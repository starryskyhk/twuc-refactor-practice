package com.twu.refactoring;

import java.util.Arrays;

public class Positive extends Operation{
    public Positive(int... numbers) {
        super(numbers);
    }

    public int countPositive() {
        return (int) Arrays.stream(numbers).filter(number -> number >= 0).count();
    }

}
