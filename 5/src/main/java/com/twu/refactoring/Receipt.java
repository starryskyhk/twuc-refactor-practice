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
        double peakTimeMultiple = getPeakTimeMultiple();
        if(taxi.isAirConditioned()) {
            totalCost += haveAirConditioned(peakTimeMultiple);
        } else {
            totalCost += notAirConditioned(peakTimeMultiple);
        }

        return getResult(totalCost);
    }

    private Double getPeakTimeMultiple() {
        return taxi.isPeakTime() ? PEAK_TIME_MULTIPLIER.getValue() : OFF_PEAK_MULTIPLIER.getValue();
    }

    private double getResult(double totalCost) {
        return totalCost * (1 + SALES_TAX_RATE.getValue());
    }

    public double haveAirConditioned(double peakTimeMultiple) {
        int totalKms = taxi.getTotalKms();
        return Math.min(RATE_CHANGE_DISTANCE.getValue(), totalKms) * PRE_RATE_CHANGE_AC_RATE.getValue() * peakTimeMultiple
        + Math.max(0, totalKms - RATE_CHANGE_DISTANCE.getValue()) * POST_RATE_CHANGE_AC_RATE.getValue() * peakTimeMultiple;
    }

    public double notAirConditioned(double peakTimeMultiple) {
        int totalKms = taxi.getTotalKms();
        return Math.min(RATE_CHANGE_DISTANCE.getValue(), totalKms) * PRE_RATE_CHANGE_NON_AC_RATE.getValue() * peakTimeMultiple
        +Math.max(0, totalKms - RATE_CHANGE_DISTANCE.getValue()) * POST_RATE_CHANGE_NON_AC_RATE.getValue() * peakTimeMultiple;

    }
}
