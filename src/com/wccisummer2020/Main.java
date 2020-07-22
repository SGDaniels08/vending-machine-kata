package com.wccisummer2020;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Penny userPenny = new Penny();
        Nickel userNickel = new Nickel();
        Dime userDime = new Dime();
        Quarter userQuarter = new Quarter();

        Collection<Product> inventory = new ArrayList<>();
        Cola cola1 = new Cola();
        Cola cola2 = new Cola();
        Cola cola3 = new Cola();
        Chips chips1 = new Chips();
        Chips chips2 = new Chips();
        Candy candy1 = new Candy();

        inventory.add(cola1);
        inventory.add(cola2);
        inventory.add(cola3);
        inventory.add(chips1);
        inventory.add(chips2);
        inventory.add(candy1);


        VendingMachine VM= new VendingMachine(BigDecimal.ZERO, inventory);
	while(true){
	    VM.displayStatus();
        System.out.println("Choose 1 to Insert Coin");
        System.out.println("Choose 2 to Pick a Product");
        System.out.println("Choose 3 to Quit");
        String userInput= input.nextLine();

        if(userInput.equals("1")){
            System.out.println("What kind of coin?");
            System.out.println("1 for Penny");
            System.out.println("2 for Nickel");
            System.out.println("3 for Dime");
            System.out.println("4 for Quarter");
            userInput = input.nextLine();
            if (userInput.equals("1")){
                VM.readCoin(userPenny);
            }else if (userInput.equals("2")){
                VM.readCoin(userNickel);
            }else if (userInput.equals("3")){
                VM.readCoin(userDime);
            }else if (userInput.equals("4")) {
                VM.readCoin(userQuarter);
            }else
                System.out.println("Not an option");
        }else if(userInput.equals("2")){
            System.out.println("What kind of product?");
            System.out.println("1 for Cola");
            System.out.println("2 for Chips");
            System.out.println("3 for Candy");
            userInput = input.nextLine();
            VM.selectProduct(userInput);
            }else if(userInput.equals("3")){
            System.out.println("Have a good day");
            break;
            }
    }

    }
}
