package com.wccisummer2020;

import java.math.BigDecimal;

public class VendingMachine {

    // Instance Variables
    private Collection<Product> inventory;

    // Constructor

    // Getters

    // Other methods
    public BigDecimal readCoin(Coin insertedCoin) {

        BigDecimal value;

        if (insertedCoin.getCoinType().equals("quarter")) {
            value = new BigDecimal(.25);
        } else if (insertedCoin.getCoinType().equals("dime")) {
            value = new BigDecimal(.10);
        } else if (insertedCoin.getCoinType().equals("nickel")) {
            value = new BigDecimal(.05);
        } else {
            value = new BigDecimal(0);
        }

        return value;
    }
    /* readCoin(), readUserRequest() */
}
