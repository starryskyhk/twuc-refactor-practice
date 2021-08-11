package com.twu.refactoring;

public class LineItem {
    private final String describe;
    private final double price;
    private final int quantity;

    public LineItem(String describe, double price, int quantity) {
        super();
        this.describe = describe;
        this.price = price;
        this.quantity = quantity;
    }

    public String getDescription() {
        return describe;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    double totalAmount() {
        return price * quantity;
    }

    public String getLineItem() {
        return describe + '\t' + price + '\t' + quantity + '\t' + totalAmount() + '\n';
    }

    public double getDiscountPrice() {
        return totalAmount() * .10;
    }
}
