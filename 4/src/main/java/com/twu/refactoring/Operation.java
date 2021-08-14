package com.twu.refactoring;


public abstract class Operation {

    protected int[] numbers;



    public Operation(int... numbers) {
        this.numbers = numbers;
    }

    public int countEven() {
        return 0;
    }


    public int countOdd() {
        return 0;
    }


    public int countPositive() {
        return 0;
    }

    public int countNegative() {
        return 0;
    }

}
