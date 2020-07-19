package com.wccisummer2020;

public abstract class Coin {
    // Instance Variables
    private String coinType;

    // Constructor
    public Coin(String coinType) {
        this.coinType = coinType;
    }

    // Getter
    public String getCoinType() {
        return coinType;
    }
}
