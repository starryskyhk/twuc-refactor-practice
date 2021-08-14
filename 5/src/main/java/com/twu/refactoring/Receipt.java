package com.twu.refactoring;

import static com.twu.refactoring.TaxiRule.*;

public class Receipt {
    private final Taxi taxi;

    public Receipt(Taxi taxi) {
        this.taxi = taxi;
    }

    public double getTotalCost() {
        return getResult(taxi.getCost());
    }

    private double getResult(double totalCost) {
        return totalCost * (1 + SALES_TAX_RATE.getValue());
    }

}
