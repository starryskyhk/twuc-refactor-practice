package com.twu.refactoring;


public class NumberCruncher extends Operation{
    public NumberCruncher(int... numbers) {
        super(numbers);
    }

    public int countEven() {
        return new Even(numbers).countEven();
    }

    public int countOdd() {
        return new Odd(numbers).countOdd();
    }

    public int countPositive() {
        return new Positive(numbers).countPositive();
    }

    public int countNegative() {
        return new Negative(numbers).countNegative();
    }
}
