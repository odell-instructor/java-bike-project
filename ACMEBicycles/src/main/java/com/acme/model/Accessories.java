package com.acme.model;

import java.math.BigDecimal;

public class Accessories implements PriceInterface {

    private final BigDecimal price;
    private final String name;

    public Accessories(String itemName, double price){
        this.name = itemName;
        this.price = BigDecimal.valueOf(price);
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    public String getItemName() {
        return name;
    }
}
