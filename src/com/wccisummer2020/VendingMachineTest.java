package com.wccisummer2020;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;


public class VendingMachineTest {

    @Test
    public void vendingMachineTakesQuarterRegistersTwentyFiveCents() {
        // Arrangement
        VendingMachine testMachine = new VendingMachine();
        Quarter testQuarter = new Quarter();
        BigDecimal testDecimal = new BigDecimal(.25);

        // Activation and Assertion
        assertEquals(testDecimal, testMachine.readCoin(testQuarter));
    }
}
