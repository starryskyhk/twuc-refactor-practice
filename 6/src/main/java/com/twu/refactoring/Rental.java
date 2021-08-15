package com.twu.refactoring;

import java.util.Objects;

public class Rental {

    private Movie movie;

    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public double getThisAmount() {
        AmountRule thisAmount = null;
        switch (movie.getPriceCode()) {
        case Movie.REGULAR:
            thisAmount = new RegularAmount();break;
        case Movie.NEW_RELEASE:
            thisAmount = new NewReleaseAmount();break;
        case Movie.CHILDRENS:
            thisAmount = new ChildrensAmount();break;
        }
        return Objects.requireNonNull(thisAmount).getAmount(daysRented);
    }

    public boolean isEarnBonus() {
        return (movie.getPriceCode() == Movie.NEW_RELEASE)
                && daysRented > 1;
    }

    public String getResult(double thisAmount) {
        return "\t" + movie.getTitle() + "\t" + thisAmount + "\n";
    }
}
