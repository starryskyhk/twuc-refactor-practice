package com.twu.refactoring;

public class RegularAmount implements AmountRule{
    @Override
    public double getAmount(int daysRented) {
        double thisAmount = 2;
        return daysRented > 2 ? thisAmount +  (daysRented - 2) * 1.5 : thisAmount;
    }
}
