package com.acme.model;

import java.math.BigDecimal;

public class TouringBike extends AbstractRoadBike {

    public TouringBike() {
        super(FrameColors.BLUE);
    }

    @Override
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(499.99);
    }

    @Override
    public int getStartNumber() {
        return 951357;
    }

    @Override
    public String getPrefix() {
        return "TB901";
    }

    @Override
    public String toString() {
        return "Touring Bike";
    }
}
