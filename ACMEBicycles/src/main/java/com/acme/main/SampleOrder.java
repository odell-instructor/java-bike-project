package com.acme.main;

import com.acme.controller.InventoryGenerator;
import com.acme.model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class SampleOrder {
    private final ArrayList<AbstractBike> bikeOrder;
    private final ArrayList<AbstractBike> customOptionsList;
    private final ArrayList<Accessories>  accessoryOrder;
    private final Scanner userIn;
    private final InventoryGenerator inventory;
    private AbstractBike bikeChoice;
    private AbstractBike optionsChoice;
    private Accessories bikeExtra;

    public SampleOrder() {
        bikeOrder = new ArrayList<>();
        customOptionsList = new ArrayList<>();
        accessoryOrder = new ArrayList<>();
        userIn = new Scanner(System.in);
        inventory = new InventoryGenerator();
    }

    public void welcomeMessage() {
        System.out.println("Welcome to ACME Bicycle Company");
        System.out.println("Your one stop shop for" +
                " Bicycles and Accessories.");
        buySomething();
    }

    private void buySomething() {
        System.out.println("Are you here to buy " +
                "accessories or a bike?");
        System.out.println("Your options are:\n" +
                "1 for Accessories\n2 for a Bike");
        String type = userIn.next();
        validateSomething(type);
    }

    private void buyBike() {
        System.out.println("What kind of bike would you like?");
        System.out.println("Your options are:\nc - Cross Country\n" +
                "d - DownHill\nt - Touring\nv - Vintage");
        String type = userIn.next();
        validateBikeType(type);
        frameColorOffer(bikeChoice);
        offerUpgrades();
        bikeOrder.add(bikeChoice);
        anotherBike();
        orderDone();
    }

    private void orderDone() {
        // Create Sample Receipt
        new SampleReceipt(bikeOrder, customOptionsList, accessoryOrder);
    }

    private void anotherBike() {
        System.out.println("Do you want to add another bike? yes or no");
        String answer = userIn.next();
        validateAnotherBike(answer);
    }

    private void offerUpgrades() {
        System.out.println("We offer upgrades for " +
                "your bicycle besides the gold frame color");
        System.out.println("We offer the following:\n" +
                "ls - leather seat\nlg - leather grips\n" +
                "wt - white tires\nnone - no upgrades");
        String upgrade = userIn.next();
        validateUpgrade(upgrade);
        moreUpgrades();
    }

    private void frameColorOffer(AbstractBike bike) {
        System.out.println("Our bikes come with a" +
                " default paint color.");
        System.out.println("Your current frame color" +
                " is "+bike.getFrameColor().toString().toLowerCase());
        System.out.println("Would you like this bike" +
                " with a different frame color? yes or no");
        String choice = userIn.next();
        switch (choice.toLowerCase()) {
            case "yes":
                frameColorChange(bike);
                break;
            case "no":
                break;
            default:
                System.out.println("You have entered an invalid choice.");
                frameColorOffer(bike);
        }
    }

    private void frameColorChange(AbstractBike bike) {
        System.out.println("What color frame would you like?");
        System.out.println("Your choices are:\n" +
                "bk - black\nbl - blue\n" +
                "ch - chrome\ngr - green\n" +
                "rd - red\n" +
                "gd - gold (extra charge)");
        String color = userIn.next();
        validateColorChoice(color);
    }

    private void moreUpgrades() {
        System.out.println("Do you want to add more Upgrades? yes or no");
        String val = userIn.next();

        switch (val) {
            case "yes":
                offerUpgrades();
                break;
            case "no":
                break;
            default:
                System.out.println("You have entered an invalid choice");
                moreUpgrades();
        }
    }

    private void offerAccessories() {
        System.out.println("Do you want to buy any Accessories?");
        String answer = userIn.next();
        validateOffer(answer);
    }

    private void buyAccessories() {
        System.out.println("What Accessories are you interested in?");
        System.out.println("Your options are:\nh - Helmet\ng - Gloves\n" +
                "b - bell\nbk - basket\nt - tire pump\nbh - bottle + holder\n" +
                "l - lights");
        String item = userIn.next();
        validateAccessory(item.toLowerCase());
        accessoryOrder.add(bikeExtra);
        moreAccessories();
    }

    private void moreAccessories() {
        System.out.println("Do you want to add more Accessories? yes or no");
        String val = userIn.next();

        switch (val) {
            case "yes":
                bikeExtra = null;
                buyAccessories();
                break;
            case "no":
                orderDone();
                break;
            default:
                System.out.println("You have entered an invalid choice");
                moreAccessories();
        }
    }

    private void validateOffer(String answer) {
        switch(answer) {
            case "yes":
                buyAccessories();
                break;
            case "no":
                break;
            default:
                System.out.println("You have entered an invalid choice");
                offerAccessories();
        }
    }

    private void validateAccessory(String choice) {
        switch (choice) {
            case "h":
                bikeExtra = new Accessories("Helmet", 29.99);
                break;
            case "g":
                bikeExtra = new Accessories("Gloves", 19.99);
                break;
            case "b":
                bikeExtra = new Accessories("Bell", 9.99);
                break;
            case "bk":
                bikeExtra = new Accessories("Basket", 29.99);
                break;
            case "t":
                bikeExtra = new Accessories("Pump", 39.99);
                break;
            case "bh":
                bikeExtra = new Accessories("Holder", 34.99);
                break;
            case "l":
                bikeExtra = new Accessories("Lights", 36.99);
                break;
            default:
                System.out.println("You have entered an invalid choice");
                buyAccessories();
        }
    }

    private void validateBikeType(String type) {
        switch (type) {
            case "c":
                bikeChoice = inventory.getCrossCountryBikeList().get(0);
                inventory.getCrossCountryBikeList().remove(0);
                break;
            case "d":
                bikeChoice = inventory.getDownhillBikeList().get(0);
                inventory.getDownhillBikeList().remove(0);
                break;
            case "t":
                bikeChoice = inventory.getTouringBikeList().get(0);
                inventory.getTouringBikeList().remove(0);
                break;
            case "v":
                bikeChoice = inventory.getVintageBikeList().get(0);
                inventory.getVintageBikeList().remove(0);
                break;
            default:
                System.out.println("You have entered an incorrect type");
                buyBike();
        }
    }

    private void validateColorChoice(String color) {
        switch(color) {
            case "bk":
                bikeChoice.paintFrame(FrameColors.BLACK);
                break;
            case "bl":
                bikeChoice.paintFrame(FrameColors.BLUE);
                break;
            case "ch":
                bikeChoice.paintFrame(FrameColors.CHROME);
                break;
            case "gr":
                bikeChoice.paintFrame(FrameColors.GREEN);
                break;
            case "rd":
                bikeChoice.paintFrame(FrameColors.RED);
                break;
            case "gd":
                optionsChoice = new GoldFrameOption(bikeChoice);
                customOptionsList.add(optionsChoice);
                break;
            default:
                System.out.println("You have entered and incorrect color.");
                frameColorChange(bikeChoice);
        }
    }

    private void validateAnotherBike(String answer) {
        switch (answer.toLowerCase()) {
            case "yes":
                bikeChoice = null;
                buyBike();
                break;
            case "no":
                offerAccessories();
                break;
            default:
                System.out.println("You have entered an invalid choice");
                anotherBike();
        }
    }

    private void validateUpgrade(String upgrade) {
        switch (upgrade.toLowerCase()){
            case "ls":
                optionsChoice = new LeatherSeatOption(bikeChoice);
                customOptionsList.add(optionsChoice);
                break;
            case "lg":
                optionsChoice = new LeatherGripOption(bikeChoice);
                customOptionsList.add(optionsChoice);
                break;
            case "wt":
                optionsChoice = new WhiteTireOption(bikeChoice);
                customOptionsList.add(optionsChoice);
                break;
            case "none":
                break;
            default:
                System.out.println("You have made an invalid choice.");
                offerUpgrades();
        }
    }


    private void validateSomething(String type) {
        switch (type) {
            case "1":
                buyAccessories();
                break;
            case "2":
                buyBike();
                break;
            default:
                System.out.println("You have entered an invalid choice");
                buySomething();
        }
    }


}
