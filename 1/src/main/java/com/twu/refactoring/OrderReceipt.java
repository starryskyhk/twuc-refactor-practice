package com.twu.refactoring;

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
            SALES_TAX + '\t' + order.getTotalSalesTax() +
            TOTAL_AMOUNT + '\t' + order.getTotal();
    }

}
