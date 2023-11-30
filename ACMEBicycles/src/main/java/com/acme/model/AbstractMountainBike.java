package com.acme.model;

import java.math.BigDecimal;

public abstract class AbstractMountainBike extends AbstractBike {

    public AbstractMountainBike(FrameColors color) {
        super(color);
    }

    @Override
    public String getWheelType() {
        return "Wide";
    }

    @Override
    public BigDecimal getOptionAmount() {
        return BigDecimal.valueOf(0.0);
    }

    @Override
    public String getOptionName() {
        return "";
    }
}
