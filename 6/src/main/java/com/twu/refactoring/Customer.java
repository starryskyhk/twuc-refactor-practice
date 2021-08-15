package com.twu.refactoring;

import java.util.ArrayList;

public class Customer {

	public static final String AMOUNT_OWED_IS = "Amount owed is ";
	public static final String YOU_EARNED = "You earned ";
	public static final String FREQUENT_RENTER_POINTS = " frequent renter points";
	public static final String RENTAL_RECORD_FOR = "Rental Record for ";
	private final String name;
	private final ArrayList<Rental> rentalList = new ArrayList<>();

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
		return  getHead()
			+ getBody()
			+ getFooter();
	}

	private String getHead() {
		return RENTAL_RECORD_FOR + name + "\n";
	}

	private String getBody() {
		StringBuilder body = new StringBuilder();
		rentalList.forEach(rental -> body.append(rental.getResult()));
		return body.toString();
	}

	private int getFrequentRenterPoints() {
		return rentalList.stream().mapToInt(Rental::getEachRenterPoint).sum();
	}

	private double getTotalAmount() {
		return rentalList.stream().mapToDouble(Rental::getThisAmount).sum();
	}

	private String getFooter() {
		String result = "";
		result += AMOUNT_OWED_IS + getTotalAmount() + "\n";
		result += YOU_EARNED + getFrequentRenterPoints()
				+ FREQUENT_RENTER_POINTS;
		return result;
	}

}
