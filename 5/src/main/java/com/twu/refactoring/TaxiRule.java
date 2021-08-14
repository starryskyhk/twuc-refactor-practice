package com.twu.refactoring;

public enum TaxiRule {
    PEAK_TIME_MULTIPLIER (1.2),

    OFF_PEAK_MULTIPLIER(1.0),
    RATE_CHANGE_DISTANCE(10),
    PRE_RATE_CHANGE_NON_AC_RATE(15),
    POST_RATE_CHANGE_NON_AC_RATE(12),
    PRE_RATE_CHANGE_AC_RATE(20),
    POST_RATE_CHANGE_AC_RATE(17),
    SALES_TAX_RATE(0.1),
    FIXED_CHARGE(50);

    Double value;


    TaxiRule(double  value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
