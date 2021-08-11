package com.twu.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {
	public static final String HEAD = "======Printing Orders======\n";
	public static final String SALES_TAX = "Sales Tax";
	public static final String TOTAL_AMOUNT = "Total Amount";
	private final Order order;

    public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {

		return HEAD +
			order.getBody() +
			SALES_TAX + '\t' + order.getTotSalesTx() +
			TOTAL_AMOUNT + '\t' + order.getTotal();
	}

}
