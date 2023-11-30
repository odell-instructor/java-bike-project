package com.acme.controller;

import com.acme.model.BikeInterface;

public class PrepSale {
    public void prepareForSale(BikeInterface bike) {
        Registration.allocatingBikeSerialNumber();
        Documentation.printBrochure();
        bike.airTires();
        bike.assembleAndTestRide();
        bike.washFrame();
    }
}
