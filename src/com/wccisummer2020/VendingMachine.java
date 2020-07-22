package com.wccisummer2020;

import java.math.BigDecimal;
import java.util.Collection;

public class VendingMachine {

    // Instance Variables
    private BigDecimal totalValueInserted;
    private BigDecimal colaCost = new BigDecimal(1.00);
    private BigDecimal chipCost = new BigDecimal(0.50);
    private BigDecimal candyCost = new BigDecimal(0.65);


    private Collection<Product> inventory;

    // Constructor
    public VendingMachine(BigDecimal totalValueInserted, Collection<Product> inventory) {
        this.totalValueInserted = totalValueInserted;
        this.inventory = inventory;
    }

    // Getters


    public BigDecimal getTotalValueInserted() {
        return totalValueInserted;
    }

    public Collection<Product> getInventory() {
        return inventory;
    }

    // Other methods
    public void readCoin(Coin insertedCoin) {

        BigDecimal value;

        if (insertedCoin.getCoinType().equals("quarter")) {
            value = new BigDecimal(".25");
        } else if (insertedCoin.getCoinType().equals("dime")) {
            value = new BigDecimal(".10");
        } else if (insertedCoin.getCoinType().equals("nickel")) {
            value = new BigDecimal(".05");
        } else {
            value = new BigDecimal("0");
        }
        totalValueInserted = totalValueInserted.add(value);
    }

    /* readCoin(), readUserRequest() */
    public Product selectProduct(String userChoice) {

        if (userChoice.equals("1") && totalValueInserted.compareTo(colaCost) >= 0) {

            if (hasCola()) {
                System.out.println("Thank you");
                System.out.println("Your change is" + totalValueInserted.subtract(colaCost));

                for (Product product : inventory) {
                    if (product.getProductType().equals("cola")) {
                        inventory.remove(product);
                        break;
                    }
                }

                totalValueInserted = BigDecimal.ZERO;
                return new Cola();
            } else {
                System.out.println("Sold out");
                return null;
            }
        }

        if (userChoice.equals("2") && totalValueInserted.compareTo(chipCost) >= 0) {

            if (hasChips()) {
                System.out.println("Thank you");
                System.out.println("Your change is" + totalValueInserted.subtract(chipCost));
                for (Product product : inventory) {
                    if (product.getProductType().equals("chips")) {
                        inventory.remove(product);
                        break;
                    }
                }
                totalValueInserted = BigDecimal.ZERO;
                return new Chips();
            }
        } else {
            System.out.println("Sold out");
            return null;
        }


        if (userChoice.equals("3") && totalValueInserted.compareTo(candyCost) >= 0) {
            if (hasCandy()) {
                System.out.println("Thank you");
                System.out.println("Your change is" + totalValueInserted.subtract(candyCost));
                for (Product product : inventory) {
                    if (product.getProductType().equals("candy")) {
                        inventory.remove(product);
                        break;
                    }
                }
                totalValueInserted = BigDecimal.ZERO;
                return new Candy();
            }
        } else {
            System.out.println("Sold out");
            return null;
        }


        if (userChoice.equals("1")) {
            System.out.println(colaCost);
        } else if (userChoice.equals("2")) {
            System.out.println(chipCost);
        } else if (userChoice.equals("3")) {
            System.out.println(candyCost);
        }
        return null;


    }

    public String displayStatus() {
        if (totalValueInserted.compareTo(BigDecimal.ZERO) > 0.0) {
            System.out.println("You inserted" + totalValueInserted);
            return "You inserted " + totalValueInserted;
        } else
            System.out.println("Insert coin");
        return "Insert coin";
    }

    public void returnCoin() {
        totalValueInserted = BigDecimal.ZERO;
    }

    public boolean hasCola() {

        for (Product product : inventory) {
            if (product.getProductType().equals("cola")) {
                return true;
            }
        }
        return false;
    }

    public boolean hasChips() {

        for (Product product : inventory) {
            if (product.getProductType().equals("chips")) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCandy() {

        for (Product product : inventory) {
            if (product.getProductType().equals("candy")) {
                return true;
            }
        }
        return false;
    }
}
