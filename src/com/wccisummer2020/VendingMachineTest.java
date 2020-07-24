package com.wccisummer2020;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

public class VendingMachineTest {

/*    @Test
    public void vendingMachineTakesQuarterRegistersTwentyFiveCents() {
        // Arrangement
        VendingMachine testMachine = new VendingMachine(BigDecimal.ZERO);
        Quarter testQuarter = new Quarter();
        BigDecimal testDecimal = new BigDecimal(".25");

        testMachine.readCoin(testQuarter);
        // Activation and Assertion

        assertEquals(testDecimal, testMachine.getTotalValueInserted());
    }

    @Test
    public void vendingMachineTakesPennyRegistersNothing() {
        // Arrangement
        VendingMachine testMachine = new VendingMachine(BigDecimal.ZERO);
        Penny testPenny = new Penny();
        BigDecimal testDecimal = new BigDecimal("0");

        testMachine.readCoin(testPenny);
        // Activation and Assertion

        assertEquals(testDecimal, testMachine.getTotalValueInserted());
    }

    @Test
    public void vendingMachineTakesNickelRegistersFiveCents() {
        // Arrangement
        VendingMachine testMachine = new VendingMachine(BigDecimal.ZERO);
        Nickel testNickel = new Nickel();
        BigDecimal testDecimal = new BigDecimal("0.05");

        testMachine.readCoin(testNickel);
        // Activation and Assertion

        assertEquals(testDecimal, testMachine.getTotalValueInserted());
    }

    @Test
    public void vendingMachineTakesDimeRegistersTenCents() {
        // Arrangement
        VendingMachine testMachine = new VendingMachine(BigDecimal.ZERO);
        Dime testDime = new Dime();
        BigDecimal testDecimal = new BigDecimal("0.10");

        testMachine.readCoin(testDime);
        // Activation and Assertion

        assertEquals(testDecimal, testMachine.getTotalValueInserted());
    }

    @Test
    public void vendingMachineTakesNickelAndDimeRegistersFifteenCents() {
        // Arrangement
        VendingMachine testMachine = new VendingMachine(BigDecimal.ZERO);
        Nickel testNickel = new Nickel();
        Dime testDime = new Dime();
        BigDecimal testDecimal = new BigDecimal("0.15");

        // Activation
        testMachine.readCoin(testNickel);
        testMachine.readCoin(testDime);

        // Assertion
        assertEquals(testDecimal, testMachine.getTotalValueInserted());
    }

    @Test
    public void vendingMachineEmptyDisplaysInsertCoin() {
        //Arrangement
        VendingMachine testMachine = new VendingMachine(BigDecimal.ZERO);
        String testString = testMachine.displayStatus();
        // Assertion
        assertEquals("Insert coin", testString);
    }

    @Test
    public void vendingMachineHasMoneyDisplaysMoney() {
        //Arrangement
        VendingMachine testMachine = new VendingMachine(BigDecimal.ZERO);
        Quarter testQuarter = new Quarter();
        testMachine.readCoin(testQuarter);
        String testString = testMachine.displayStatus();
        // Assertion
        assertEquals("You inserted 0.25", testString);
    }

    @Test
    public void selectColaWithEnoughMoneyDispensesCola() {
        // Arrangement
        VendingMachine testMachine = new VendingMachine(BigDecimal.ONE);
        Product testProduct = testMachine.selectProduct("1");

        // Activation and Assertion
        assertEquals("cola", testProduct.getProductType());
    }

    @Test
    public void selectChipsWithEnoughMoneyDispensesCola() {
        // Arrangement
        VendingMachine testMachine = new VendingMachine(BigDecimal.ONE);
        Product testProduct = testMachine.selectProduct("2");

        // Activation and Assertion
        assertEquals("chips", testProduct.getProductType());
    }

    @Test
    public void selectCandyWithEnoughMoneyDispensesCola() {
        // Arrangement
        VendingMachine testMachine = new VendingMachine(BigDecimal.ONE);
        Product testProduct = testMachine.selectProduct("3");

        // Activation and Assertion
        assertEquals("candy", testProduct.getProductType());
    }

    @Test
    public void checkDisplayAfterPurchaseNoMoneyInMachine() {
        // Arrangement
        VendingMachine testMachine = new VendingMachine(BigDecimal.ONE);

        // Activation
        Product testProduct = testMachine.selectProduct("3");

        // Assertion
        assertEquals(BigDecimal.ZERO, testMachine.getTotalValueInserted());
    }

    @Test
    public void pressReturnCoinZeroesOutMachine() {
        // Arrangement
        VendingMachine testMachine = new VendingMachine(BigDecimal.ONE);

        // Activation
        testMachine.returnCoin();

        // Assertion
        assertEquals(BigDecimal.ZERO, testMachine.getTotalValueInserted());
    }
*/
    @Test
    public void inventorySuccessfullyAddedToMachine() {
        // Arrangement
        Collection<Product> testInventory = new ArrayList<>();
        Cola cola1 = new Cola();
        Cola cola2 = new Cola();
        Cola cola3 = new Cola();
        Chips chips1 = new Chips();
        Chips chips2 = new Chips();
        Candy candy1 = new Candy();

        testInventory.add(cola1);
        testInventory.add(cola2);
        testInventory.add(cola3);
        testInventory.add(chips1);
        testInventory.add(chips2);
        testInventory.add(candy1);

        // Activation
        VendingMachine testMachine = new VendingMachine(BigDecimal.ZERO, testInventory);

        // Assertion
        assertEquals(testInventory, testMachine.getInventory());
    }

    @Test
    public void buyColaRemovesColaFromInventory() {
        // Arrangement
        Collection<Product> testInventory = new ArrayList<>();
        Cola cola1 = new Cola();
        Cola cola2 = new Cola();
        Cola cola3 = new Cola();
        testInventory.add(cola1);
        testInventory.add(cola2);
        testInventory.add(cola3);

        Chips chips1 = new Chips();
        Chips chips2 = new Chips();
        testInventory.add(chips2);
        testInventory.add(chips1);

        Candy candy1 = new Candy();
        testInventory.add(candy1);

        int sizeBeforePurchase = testInventory.size();

        VendingMachine testMachine = new VendingMachine(BigDecimal.ONE, testInventory);

        // Activation
        testMachine.selectProduct("1");

        // Assertion
        assertEquals(sizeBeforePurchase - 1, testMachine.getInventory().size());
    }

    @Test
    public void hasColaMethodWorks() {
        // Arrangement
        Collection<Product> testInventory = new ArrayList<>();
        Cola cola1 = new Cola();
        Cola cola2 = new Cola();
        Cola cola3 = new Cola();
        testInventory.add(cola1);
        testInventory.add(cola2);
        testInventory.add(cola3);

        Chips chips1 = new Chips();
        Chips chips2 = new Chips();
        testInventory.add(chips2);
        testInventory.add(chips1);

        Candy candy1 = new Candy();
        testInventory.add(candy1);

        VendingMachine testMachine = new VendingMachine(BigDecimal.ONE, testInventory);

        // Assertion
        assertTrue(testMachine.hasCola());

    }

    @Test
    public void ifNotExactChangeAsksForExactChange() {
        // Arrangement
        Collection<Product> testInventory = new ArrayList<>();
        Cola cola1 = new Cola();
        Cola cola2 = new Cola();
        Cola cola3 = new Cola();
        testInventory.add(cola1);
        testInventory.add(cola2);
        testInventory.add(cola3);

        Chips chips1 = new Chips();
        Chips chips2 = new Chips();
        testInventory.add(chips2);
        testInventory.add(chips1);

        Candy candy1 = new Candy();
        testInventory.add(candy1);

        VendingMachine testMachine = new VendingMachine(BigDecimal.ONE, testInventory);

        // Activation and Assertion
        assertEquals(null, testMachine.selectProduct("2"));

    }

}
