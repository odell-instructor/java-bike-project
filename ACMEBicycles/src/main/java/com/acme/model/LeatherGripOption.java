package com.acme.model;

import java.math.BigDecimal;

public class LeatherGripOption extends AbstractBikeOption {

    public LeatherGripOption(AbstractBike bike) {
        super(bike);
    }

    @Override
    public String getOptionName() {
        return "Leather Grips Upgrade";
    }

    @Override
    public BigDecimal getOptionAmount() {
        return BigDecimal.valueOf(49.99);
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

    @Override
    public String getSerialNumber() {
        return decoratedBike.getSerialNumber();
    }

    @Override
    public String toString() {
        return decoratedBike.toString();
    }
}
