package pl.glownia.pamela;

import java.util.Scanner;

public class Order {

    boolean verifyRequiredIngredients(CoffeeMachine coffeeMachine, KindOfCoffee coffee) {
        if (coffeeMachine.getWater() < coffee.getWater()) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (coffeeMachine.getMilk() < coffee.getMilk()) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (coffeeMachine.getCoffeeBeans() < coffee.getCoffeeBeans()) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        } else if (coffeeMachine.getCups() < 1) {
            System.out.println("Sorry, not enough cups!");
            return false;
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        }
    }

    void chooseCoffee(CoffeeMachine coffeeMachine) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Type what kind of coffee would you like to buy: espresso, latte, cappuccino or return (to the main menu)?");
        String coffeeChoice = scan.next();
        if (coffeeChoice.equalsIgnoreCase(KindOfCoffee.ESPRESSO.name())) {
            makeCoffee(coffeeMachine, KindOfCoffee.ESPRESSO);
        } else if (coffeeChoice.equalsIgnoreCase(KindOfCoffee.LATTE.name())) {
            makeCoffee(coffeeMachine, KindOfCoffee.LATTE);
        } else if (coffeeChoice.equalsIgnoreCase(KindOfCoffee.CAPPUCCINO.name())) {
            makeCoffee(coffeeMachine, KindOfCoffee.CAPPUCCINO);
        } else if (coffeeChoice.equalsIgnoreCase("return")) {
            System.out.println("...Returning to main menu.");
        } else {
            System.out.println("Wrong value. \n...Returning to main menu.");
        }
    }

    void makeCoffee(CoffeeMachine coffeeMachine, KindOfCoffee coffee) {
        if (verifyRequiredIngredients(coffeeMachine, coffee)) {
            coffeeMachine.setWater(coffeeMachine.getWater() - coffee.getWater());
            coffeeMachine.setMilk(coffeeMachine.getMilk() - coffee.getMilk());
            coffeeMachine.setCoffeeBeans(coffeeMachine.getCoffeeBeans() - coffee.getCoffeeBeans());
            coffeeMachine.setMoney(coffeeMachine.getMoney() + coffee.getMoney());
            coffeeMachine.setMilk(coffeeMachine.getMilk() - coffee.getMilk());
            coffeeMachine.setCups(coffeeMachine.getCups() - 1);
        }
    }
}