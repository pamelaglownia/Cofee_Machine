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
        String decision;
        do {
            System.out.println("\nWrite action(buy, fill, take, remaining, exit): ");
            decision = scan.next();
            while (!(decision.equalsIgnoreCase("buy") || decision.equalsIgnoreCase("fill") || decision.equalsIgnoreCase("take") || decision.equalsIgnoreCase("remaining") || decision.equalsIgnoreCase("exit"))) {
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
        int rWater = 250;
        int rMilk = 0;
        int rCoffeeBeans = 16;
        int rCups = 1;
        if (verifyRequiredIngredients(rWater, rMilk, rCoffeeBeans, rCups)) {
            water -= rWater;
            coffeeBeans -= rCoffeeBeans;
            money += 4;
            cups -= rCups;
        }
    }

    static void makeLatte() {
        int rWater = 350;
        int rMilk = 75;
        int rCoffeeBeans = 20;
        int rCups = 1;
        if (verifyRequiredIngredients(rWater, rMilk, rCoffeeBeans, rCups)) {
            water -= rWater;
            milk -= rMilk;
            coffeeBeans -= rCoffeeBeans;
            money += 7;
            cups -= rCups;
        }
    }

    static void makeCappuccino() {
        int rWater = 200;
        int rMilk = 100;
        int rCoffeeBeans = 12;
        int rCups = 1;
        if (verifyRequiredIngredients(rWater, rMilk, rCoffeeBeans, rCups)) {
            water -= rWater;
            milk -= rMilk;
            coffeeBeans -= rCoffeeBeans;
            money += 6;
            cups -= rCups;
        }
    }

    static boolean verifyRequiredIngredients(int rWater, int rMilk, int rCoffeeBeans, int rCups) {
        if (water < rWater) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (milk < rMilk) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (coffeeBeans < rCoffeeBeans) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        } else if (cups < rCups) {
            System.out.println("Sorry, not enough cups!");
            return false;
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        }
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
    }

    static void takeMoney() {
        System.out.println("I take you $" + money + ".");
        money = 0;
    }
}