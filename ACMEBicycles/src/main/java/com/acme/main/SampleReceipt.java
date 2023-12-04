package com.acme.main;

import com.acme.model.AbstractBike;
import com.acme.model.Accessories;

import java.util.ArrayList;

public class SampleReceipt {

    private double total = 0.0;
    ArrayList<AbstractBike> bikeCart;
    ArrayList<AbstractBike> upgradeCart;
    ArrayList<Accessories> accessoriesCart;

    public SampleReceipt(ArrayList<AbstractBike> bikeList,
                         ArrayList<AbstractBike> upgradeList,
                         ArrayList<Accessories> accessoryList) {
        bikeCart = bikeList;
        upgradeCart = upgradeList;
        accessoriesCart = accessoryList;
        showTitle();
        showColumnHeader();
        showBikeCart();
        showAccessoryCart();
        showTotals();
    }

    private void showTitle() {
        String company = String.format("%30s" , "ACME Bicycle Company");
        String address = String.format("%33s", "123 Main St, City, ST, Zip");
        String phone = String.format("%27s", "(000) 000 - 0000");
        System.out.println(company);
        System.out.println(address);
        System.out.println(phone);
        showStars();
        String cash = String.format("%25s", "MONEY RECEIPT");
        System.out.println(cash);
        showStars();
    }

    private void showColumnHeader() {
        String price = String.format("%28s |", "Price");
        System.out.println("| Description |" + price);
    }

    private void showBikeCart() {
        if(!bikeCart.isEmpty()) {
            for(AbstractBike bike : bikeCart) {
                System.out.println(bike);
                System.out.println("\tFrame Color: " +
                        bike.getFrameColor());
                total += bike.getPrice().doubleValue();
                String bikePrice = String.format("%30s",
                        "$" + bike.getPrice());
                System.out.println("\tBike Price: " +
                        bikePrice);
                if(!upgradeCart.isEmpty()) {
                    showUpgradeCart(bike);
                }
                System.out.println();
            }
        }
    }

    private void showUpgradeCart(AbstractBike bike) {
        for(AbstractBike upgrade : upgradeCart) {
            if(upgrade.toString().equals(bike.toString())) {
                String customPrice = String.format("%22s",
                        "$" + upgrade.getOptionAmount());
                System.out.print("\t"+upgrade.getOptionName());
                System.out.println(customPrice);
                total += upgrade.getOptionAmount().doubleValue();
            }
        }
    }

    private void showAccessoryCart() {
        if(!accessoriesCart.isEmpty()) {
            for(Accessories item : accessoriesCart) {
                System.out.print("\t"+ item.getItemName());
                String price = String.format("%35s", "$" +
                        item.getPrice());
                System.out.println(price);
                System.out.println();
                total += item.getPrice().doubleValue();
            }
        }
    }

    private void showTotals() {
        double tax = 1.07;
        double totalWithTax = total * tax;
        double taxAmount = totalWithTax - total;
        showStars();
        System.out.print("Sub Total");
        System.out.printf("%27s %.2f%n", "$", total);
        System.out.print("Sales Tax");
        System.out.printf("%28s %.2f%n", "$", taxAmount);
        System.out.print("Total");
        System.out.printf("%31s %.2f%n", "$", totalWithTax);
    }

    private void showStars() {
        for(int i = 0; i < 40; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

}
