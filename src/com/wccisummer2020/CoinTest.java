package com.wccisummer2020;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinTest {

    @Test
    public void makingAPennyCreatesAPenny() {
        // Arrangement + Activation
        Penny testPenny = new Penny();

        // Assertion
        assertEquals("penny", testPenny.getCoinType());
    }

    @Test
    public void makingANickelCreatesANickel() {
        // Arrangement + Activation
        Nickel testNickel = new Nickel();

        // Assertion
        assertEquals("nickel", testNickel.getCoinType());
    }

    @Test
    public void makingADimeCreatesADime() {
        // Arrangement + Activation
        Dime testDime = new Dime();

        // Assertion
        assertEquals("dime", testDime.getCoinType());
    }


    @Test
    public void makingAQuarterCreatesAQuarter() {
        // Arrangement + Activation
        Quarter testQuarter = new Quarter();

        // Assertion
        assertEquals("quarter", testQuarter.getCoinType());
    }


}
