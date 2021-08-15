package com.twu.refactoring;

public class ChildrensAmount implements AmountRule{
    @Override
    public double getAmount(int daysRented) {
         double thisAmount = 1.5;
        return daysRented > 3 ? thisAmount + (daysRented - 3) * 1.5 : thisAmount;
    }

}
