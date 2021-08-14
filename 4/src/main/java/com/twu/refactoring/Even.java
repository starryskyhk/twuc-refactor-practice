package com.twu.refactoring;

import java.util.Arrays;

public class Even extends Operation{
    public Even(int... numbers) {
        super(numbers);
    }

    public int countEven() {
        return (int) Arrays.stream(numbers).filter(number -> number % 2 == 0).count();
    }
}
