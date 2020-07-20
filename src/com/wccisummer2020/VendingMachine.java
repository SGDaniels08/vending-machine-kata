package com.wccisummer2020;

import java.math.BigDecimal;
import java.util.Collection;

public class VendingMachine {

    // Instance Variables
    private BigDecimal totalValueInserted;
    private BigDecimal colaCost= new BigDecimal(1.00);
    private BigDecimal chipCost = new BigDecimal(0.50);
    private BigDecimal candyCost = new BigDecimal(0.65);



    private Collection<Product> inventory;

    // Constructor
    public VendingMachine(BigDecimal totalValueInserted){
        this.totalValueInserted = totalValueInserted;
        //this.inventory = inventory;
    }

        // Getters


    public BigDecimal getTotalValueInserted() {
        return totalValueInserted;
    }

//    public Collection<Product> getInventory() {
//        return inventory;
//    }

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
            System.out.println("Thank you");
            System.out.println("Your change is" + totalValueInserted.subtract(colaCost));
            totalValueInserted = BigDecimal.ZERO;
            return new Cola();
        } else if (userChoice.equals("2") && totalValueInserted.compareTo(chipCost) >= 0) {
            System.out.println("Thank you");
            System.out.println("Your change is" + totalValueInserted.subtract(chipCost));
            totalValueInserted = BigDecimal.ZERO;
            return new Chips();
        } else if (userChoice.equals("3") && totalValueInserted.compareTo(candyCost) >= 0) {
            System.out.println("Thank you");
            System.out.println("Your change is" + totalValueInserted.subtract(candyCost));
            totalValueInserted = BigDecimal.ZERO;
            return new Candy();
        }else {
            if (userChoice.equals("1")){
                System.out.println(colaCost);
            }else if (userChoice.equals("2")){
                System.out.println(chipCost);
            }else if(userChoice.equals("3")){
                System.out.println(candyCost);
            }
            return null;
        }


    }
    public void displayStatus(){
        if(totalValueInserted.compareTo(BigDecimal.ZERO) > 0.0){
            System.out.println("You inserted" + totalValueInserted);
        }else
            System.out.println("Insert coin");

    }
}
