package com.twu.refactoring;

import static com.twu.refactoring.TaxiRule.*;

public class Taxi {
    private boolean airConditioned;
    private final int totalKms;
    private final boolean peakTime;

    public Taxi(boolean airConditioned, int totalKms, boolean peakTime) {
        this.airConditioned = airConditioned;
        this.totalKms = totalKms;
        this.peakTime = peakTime;
    }

    public boolean isAirConditioned() {
        return airConditioned;
    }

    public int getTotalKms() {
        return totalKms;
    }

    public boolean isPeakTime() {
        return peakTime;
    }

    private Double getPeakTimeMultiple() {
        return peakTime ? PEAK_TIME_MULTIPLIER.getValue() : OFF_PEAK_MULTIPLIER.getValue();
    }

    public double haveAirConditioned() {
        double peakTimeMultiple = getPeakTimeMultiple();
        return Math.min(RATE_CHANGE_DISTANCE.getValue(), totalKms) * PRE_RATE_CHANGE_AC_RATE.getValue() * peakTimeMultiple
        + Math.max(0, totalKms - RATE_CHANGE_DISTANCE.getValue()) * POST_RATE_CHANGE_AC_RATE.getValue() * peakTimeMultiple;
    }

    public double notAirConditioned() {
        double peakTimeMultiple = getPeakTimeMultiple();
        return Math.min(RATE_CHANGE_DISTANCE.getValue(), totalKms) * PRE_RATE_CHANGE_NON_AC_RATE.getValue() * peakTimeMultiple
        +Math.max(0, totalKms - RATE_CHANGE_DISTANCE.getValue()) * POST_RATE_CHANGE_NON_AC_RATE.getValue() * peakTimeMultiple;

    }

    public double getCost() {
        double totalCost = 0;
        totalCost += FIXED_CHARGE.getValue();
        totalCost += airConditioned?haveAirConditioned():notAirConditioned();
        return totalCost;
    }
}
