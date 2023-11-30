package com.acme.model;

import java.math.BigDecimal;

public abstract class AbstractRoadBike extends AbstractBike {

    public AbstractRoadBike(FrameColors color) {
        super(color);
    }

    @Override
    public String getWheelType() {
        return "Normal";
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
