package com.twu.refactoring;

import java.util.Arrays;

public class Odd extends Operation{
    public Odd(int... numbers) {
        super(numbers);
    }

    public int countOdd() {
        return (int) Arrays.stream(numbers).filter(number -> number % 2 == 1).count();
    }
}
