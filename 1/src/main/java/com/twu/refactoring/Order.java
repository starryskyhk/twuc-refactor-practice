package com.twu.refactoring;

import java.util.List;
import java.util.stream.Collectors;

public class Order {
    String name;
    String address;
    List<LineItem> items;

    public Order(String name, String address, List<LineItem> items) {
        this.name = name;
        this.address = address;
        this.items = items;
    }

    public String getCustomerName() {
        return name;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
        return items;
    }

    public String getItems() {
        return items.stream().map(LineItem::getLineItem).collect(Collectors.joining());
    }

    public String getCustomerInfo() {
        return name + address;
    }

    public double getTotSalesTx() {
        double totSalesTx = 0;
        totSalesTx += items.stream().mapToDouble(LineItem::getDiscountPrice).sum();
        return totSalesTx;
    }

    public double getTotal() {
        return items.stream().mapToDouble(lineItem -> lineItem.totalAmount() + lineItem.getDiscountPrice()).sum();
    }

    public String getBody() {
        return getCustomerInfo() + getItems();
    }
}
