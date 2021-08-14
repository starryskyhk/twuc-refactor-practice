package com.twu.refactoring;

import static com.twu.refactoring.TaxiRule.*;

public class Receipt {
    private final Taxi taxi;

    public Receipt(Taxi taxi) {
        this.taxi = taxi;
    }

    public double getTotalCost() {
        double totalCost = 0;

        // fixed charges
        totalCost += FIXED_CHARGE.getValue();

        // taxi charges
        int totalKms = taxi.getTotalKms();
        double peakTimeMultiple = taxi.isPeakTime() ? PEAK_TIME_MULTIPLIER.getValue() : OFF_PEAK_MULTIPLIER.getValue();
        if(taxi.isAirConditioned()) {
            totalCost += Math.min(RATE_CHANGE_DISTANCE.getValue(), totalKms) * PRE_RATE_CHANGE_AC_RATE.getValue() * peakTimeMultiple;
            totalCost += Math.max(0, totalKms - RATE_CHANGE_DISTANCE.getValue()) * POST_RATE_CHANGE_AC_RATE.getValue() * peakTimeMultiple;
        } else {
            totalCost += Math.min(RATE_CHANGE_DISTANCE.getValue(), totalKms) * PRE_RATE_CHANGE_NON_AC_RATE.getValue() * peakTimeMultiple;
            totalCost += Math.max(0, totalKms - RATE_CHANGE_DISTANCE.getValue()) * POST_RATE_CHANGE_NON_AC_RATE.getValue() * peakTimeMultiple;
        }

        return totalCost * (1 + SALES_TAX_RATE.getValue());
    }
}
