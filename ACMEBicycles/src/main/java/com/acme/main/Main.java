package com.acme.main;

import com.acme.controller.InventoryGenerator;
import com.acme.controller.SerialNumberGenerator;
import com.acme.model.*;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        //testReceipt();
        orderItems();
    }

    public static void orderItems() {
        SampleOrder order = new SampleOrder();
        order.welcomeMessage();
    }

    private static void testReceipt() {
        ArrayList<AbstractBike> bike = new ArrayList<>();
        ArrayList<AbstractBike> customUpgrade = new ArrayList<>();
        ArrayList<Accessories> accessoryList = new ArrayList<>();
        InventoryGenerator gen = new InventoryGenerator();
        bike.add(gen.getCrossCountryBikeList().get(0));
        bike.add(gen.getDownhillBikeList().get(0));
        AbstractBike custom = gen.getVintageBikeList().get(0);
        custom = new LeatherSeatOption(custom);
        bike.add(custom);
        customUpgrade.add(custom);
        customUpgrade.add(new GoldFrameOption(custom));

        accessoryList.add(0, new Accessories("Helmet", 29.99));

        new SampleReceipt(bike, customUpgrade, accessoryList);
    }

    private static void testingSerialNumbers() {
        DownhillBike bike = new DownhillBike();
        SerialNumberGenerator generator =
                SerialNumberGenerator.getInstance();
        generator.startGeneration(bike.getPrefix(),
                bike.getStartNumber());
        bike.setSerialNumber(generator.getNextSerial());
        System.out.println(bike.getSerialNumber());

        System.out.println("Next serial in line is " +
                generator.getNextSerial());
        System.out.println("Next serial in line is " +
                generator.getNextSerial());
        System.out.println("Next serial in line is " +
                generator.getNextSerial());
        System.out.println("Next serial in line is " +
                generator.getNextSerial());
        System.out.println("Next serial in line is " +
                generator.getNextSerial());

        System.out.println(bike.getPrefix() + " From above " +
                generator.getRecentNumber());

        SerialNumberGenerator myGen =
                SerialNumberGenerator.getInstance();
        VintageBike oldBike = new VintageBike();
        myGen.startGeneration(oldBike.getPrefix(),
                oldBike.getStartNumber());

        System.out.println();
        System.out.println("Vintage Next serial in line is " +
                myGen.getNextSerial());
        System.out.println("Vintage Next serial in line is " +
                myGen.getNextSerial());
        System.out.println("Vintage Next serial in line is " +
                myGen.getNextSerial());
        System.out.println();

        System.out.println("Next serial in line is " +
                generator.getNextSerial());
        System.out.println("Next serial in line is " +
                generator.getNextSerial());
    }


    private static void testCustomOptions() {
        VintageBike bike = new VintageBike();
        LeatherSeatOption option1 = new LeatherSeatOption(bike);
        System.out.println(option1.getOptionName());
        double bikePrice = option1.getPrice()
                .add(option1.getOptionAmount()).doubleValue();
        System.out.println(bikePrice);
        GoldFrameOption option2 = new GoldFrameOption(option1);
        System.out.println(option2.getOptionName());
        System.out.println(option2.getFrameColor());
        bikePrice += option2.getOptionAmount().doubleValue();
        System.out.println(bikePrice);
    }

}
