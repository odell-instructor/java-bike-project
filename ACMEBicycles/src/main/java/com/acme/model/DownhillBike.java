package com.acme.model;

import java.math.BigDecimal;

public class DownhillBike extends AbstractMountainBike {

    public DownhillBike() {
        super(FrameColors.BLACK);
    }

    @Override
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(699.99);
    }

    @Override
    public int getStartNumber() {
        return 852654;
    }

    @Override
    public String getPrefix() {
        return "DB505";
    }
}
