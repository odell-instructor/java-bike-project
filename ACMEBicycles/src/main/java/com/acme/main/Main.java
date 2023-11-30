package com.acme.main;

import com.acme.controller.PrepSale;
import com.acme.controller.SerialNumberGenerator;
import com.acme.model.DownhillBike;
import com.acme.model.GoldFrameOption;
import com.acme.model.LeatherSeatOption;
import com.acme.model.VintageBike;


public class Main {

    public static void main(String[] args) {

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
