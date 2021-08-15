package com.twu.refactoring;

public class NewReleaseAmount implements AmountRule
{
    @Override
    public double getAmount(int daysRented) {
        return daysRented * 3;
    }
}
