package com.twu.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {
    private final Order order;

    public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {

		return "======Printing Orders======\n" +
			order.getBody() +
			"Sales Tax" + '\t' + order.getTotSalesTx() +
			"Total Amount" + '\t' + order.getTotal();
	}

}
