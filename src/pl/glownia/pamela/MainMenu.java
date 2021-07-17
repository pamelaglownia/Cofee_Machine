package pl.glownia.pamela;

import java.util.Scanner;

public class MainMenu {
    static int water = 400;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int cups = 9;
    static int money = 550;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        printCoffeeMachineState();
        makeDecision(scan);
    }

    static void printCoffeeMachineState() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }

    static void makeDecision(Scanner scan) {
        String decision = "";
        do {
            System.out.println("\nWrite action(buy, fill, take, remaining, exit): ");
            decision = scan.next();
            while (!(decision.equalsIgnoreCase("buy") || decision.equalsIgnoreCase("fill") || decision.equalsIgnoreCase("take")
                    || decision.equalsIgnoreCase("remaining") || decision.equalsIgnoreCase("exit"))) {
                System.out.println("Incorrect value. Try again:");
                decision = scan.next();
            }
            if (decision.equalsIgnoreCase("buy")) {
                System.out.println("Do you want to buy coffee: 1- espresso, 2- latte, 3-cappuccino or 4-go back to the main menu?");
                int coffeeNumber = scan.nextInt();
                if (coffeeNumber == 1) {
                    makeEspresso();
                } else if (coffeeNumber == 2) {
                    makeLatte();
                } else if (coffeeNumber == 3) {
                    makeCappuccino();
                } else if (coffeeNumber == 4) {
                    makeDecision(scan);
                } else {
                    System.out.println("Wrong number.");
                }
            } else if (decision.equalsIgnoreCase("fill")) {
                fillCoffeeMachine(scan);
            } else if (decision.equalsIgnoreCase("take")) {
                takeMoney();
            } else if (decision.equalsIgnoreCase("remaining")) {
                printCoffeeMachineState();
            }
        } while (!(decision.equalsIgnoreCase("exit")));
        System.out.println("Thank you! Bye!");
    }

    static void makeEspresso() {
        water -= 250;
        coffeeBeans -= 16;
        money += 4;
        cups -= 1;
        printCoffeeMachineState();
    }

    static void makeLatte() {
        water -= 350;
        milk -= 75;
        coffeeBeans -= 20;
        money += 7;
        cups -= 1;
        printCoffeeMachineState();
    }

    static void makeCappuccino() {
        water -= 200;
        milk -= 100;
        coffeeBeans -= 12;
        money += 6;
        cups -= 1;
        printCoffeeMachineState();
    }

    static void fillCoffeeMachine(Scanner scan) {
        System.out.println("Write how many ml of water you want to add: ");
        int addWater = scan.nextInt();
        water += addWater;
        System.out.println("Write how many ml of milk you want to add: ");
        int addMilk = scan.nextInt();
        milk += addMilk;
        System.out.println("Write how many grams of coffee beans you want to add: ");
        int addCoffeeBeans = scan.nextInt();
        coffeeBeans += addCoffeeBeans;
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        int addDisposableCups = scan.nextInt();
        cups += addDisposableCups;
        printCoffeeMachineState();
    }

    static void takeMoney() {
        System.out.println("I take you $" + money + ".");
        money = 0;
        printCoffeeMachineState();
    }
}