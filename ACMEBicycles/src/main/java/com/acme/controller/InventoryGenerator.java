package com.acme.controller;

import com.acme.model.CrossCountryBike;
import com.acme.model.DownhillBike;
import com.acme.model.TouringBike;
import com.acme.model.VintageBike;

import java.util.ArrayList;

public class InventoryGenerator {
    private final ArrayList<TouringBike> touringBikeList;
    private final ArrayList<VintageBike> vintageBikeList;
    private final ArrayList<CrossCountryBike> crossCountryBikeList;
    private final ArrayList<DownhillBike> downhillBikeList;
    private final SerialNumberGenerator generator;

    public InventoryGenerator() {
        generator = SerialNumberGenerator.getInstance();
        touringBikeList = buildTouringInventory(new ArrayList<>());
        vintageBikeList = buildVintageInventory(new ArrayList<>());
        crossCountryBikeList = buildCrossCountryInventory(new ArrayList<>());
        downhillBikeList = buildDownHillInventory(new ArrayList<>());
    }

    public ArrayList<TouringBike> getTouringBikeList() {
        return touringBikeList;
    }

    public ArrayList<VintageBike> getVintageBikeList() {
        return vintageBikeList;
    }

    public ArrayList<CrossCountryBike> getCrossCountryBikeList() {
        return crossCountryBikeList;
    }

    public ArrayList<DownhillBike> getDownhillBikeList() {
        return downhillBikeList;
    }

    private ArrayList<TouringBike> buildTouringInventory
            (ArrayList<TouringBike> bikeList) {
        TouringBike bike = new TouringBike();
        generator.startGeneration(bike.getPrefix(), bike.getStartNumber());

        for(int i = 0; i < 5; i++) {
            bike = new TouringBike();
            bike.setSerialNumber(generator.getNextSerial());
            bikeList.add(i, bike);
        }
        return bikeList;
    }

    private ArrayList<VintageBike> buildVintageInventory
            (ArrayList<VintageBike> bikeList) {
        VintageBike bike = new VintageBike();
        generator.startGeneration(bike.getPrefix(), bike.getStartNumber());

        for(int i = 0; i < 5; i++) {
            bike = new VintageBike();
            bike.setSerialNumber(generator.getNextSerial());
            bikeList.add(i, bike);
        }
        return bikeList;
    }

    private ArrayList<DownhillBike> buildDownHillInventory
            (ArrayList<DownhillBike> bikelist) {
        DownhillBike bike = new DownhillBike();
        generator.startGeneration(bike.getPrefix(), bike.getStartNumber());

        for(int i = 0; i < 5; i++) {
            bike = new DownhillBike();
            bike.setSerialNumber(generator.getNextSerial());
            bikelist.add(i, bike);
        }
        return bikelist;
    }

    private ArrayList<CrossCountryBike> buildCrossCountryInventory
            (ArrayList<CrossCountryBike> bikeList) {
        CrossCountryBike bike = new CrossCountryBike();
        generator.startGeneration(bike.getPrefix(), bike.getStartNumber());

        for(int i = 0; i < 5; i++) {
            bike = new CrossCountryBike();
            bike.setSerialNumber(generator.getNextSerial());
            bikeList.add(i, bike);
        }
        return bikeList;
    }

}
