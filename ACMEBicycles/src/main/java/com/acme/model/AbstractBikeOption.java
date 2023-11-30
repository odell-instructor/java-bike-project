package com.acme.model;

import java.math.BigDecimal;

public abstract class AbstractBikeOption
        extends AbstractBike {

    protected AbstractBike decoratedBike;

    public AbstractBikeOption(AbstractBike bike) {
        super(bike.getFrameColor());
        decoratedBike = bike;
    }

    public abstract String getOptionName();
    public abstract BigDecimal getOptionAmount();


}
