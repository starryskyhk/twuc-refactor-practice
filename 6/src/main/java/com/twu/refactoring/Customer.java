package com.twu.refactoring;

import java.util.ArrayList;

public class Customer {

	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
		for (Rental each : rentalList) {
			double thisAmount = 0;
			// determine amounts for each line
			thisAmount = each.getThisAmount();
			// show figures for this rental
			result.append(each.getResult(thisAmount));
			totalAmount += thisAmount;
		}

		for (Rental each : rentalList) {
			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if (each.isEarnBonus())
				frequentRenterPoints++;
		}
		// add footer lines
		return getFooter(totalAmount, frequentRenterPoints, result.toString());
	}

	private String getFooter(double totalAmount, int frequentRenterPoints, String result) {
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints
				+ " frequent renter points";
		return result;
	}

}
