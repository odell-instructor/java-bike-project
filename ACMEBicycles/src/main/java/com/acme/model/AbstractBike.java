package com.acme.model;


import java.math.BigDecimal;

public abstract class AbstractBike implements
    PriceInterface, BikeInterface {

    private FrameColors color;
    private String serial;

    public AbstractBike(FrameColors color){
        this.color = color;
    }

    public abstract BigDecimal getPrice();
    public abstract int getStartNumber();
    public abstract String getPrefix();
    public abstract String getWheelType();
    public abstract String getOptionName();
    public abstract BigDecimal getOptionAmount();

    public FrameColors getFrameColor() {
        return color;
    }

    public void setSerialNumber(String serial) {
        this.serial = serial;
    }

    public String getSerialNumber() {
        return serial;
    }

    public void paintFrame(FrameColors color) {
        this.color = color;
    }

    @Override
    public String airTires() {
        String airMessage = "We air our bike tires" +
                " to a consistent 32 psi.";
        String testTire = "We test each tire prior to" +
                " sale for proper air pressure.";

        return airMessage +"\n"+ testTire;
    }

    @Override
    public String washFrame() {
        String washMessage = "We wash our bike frames" +
                " with non-abrasive detergent.";
        String rinseMessage = "We rinse and dry our bike" +
                " frames for a sparkling shine.";
        return washMessage +"\n"+ rinseMessage;
    }

    @Override
    public String assembleAndTestRide() {
        String assemble = "We assemble our bikes using" +
                " proper torque ratings for your safety.";
        String ride = "We test ride our bikes to ensure a proper ride.";
        return assemble +"\n"+ ride;
    }

}
