package com.acme.model;

import java.math.BigDecimal;

public class WhiteTireOption extends AbstractBikeOption {

    public WhiteTireOption(AbstractBike bike) {
        super(bike);
    }

    @Override
    public String getOptionName() {
        return "White Tire Option";
    }

    @Override
    public BigDecimal getOptionAmount() {
        return BigDecimal.valueOf(29.99);
    }

    @Override
    public BigDecimal getPrice() {
        return decoratedBike.getPrice();
    }

    @Override
    public int getStartNumber() {
        return decoratedBike.getStartNumber();
    }

    @Override
    public String getPrefix() {
        return decoratedBike.getPrefix();
    }

    @Override
    public String getWheelType() {
        return decoratedBike.getWheelType();
    }
}
