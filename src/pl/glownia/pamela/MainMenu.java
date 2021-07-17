package pl.glownia.pamela;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int water = 400;
        int milk = 540;
        int coffeeBeans = 120;
        int cups = 9;
        int money = 550;
        printCoffeeMachineState(water, coffeeBeans, money, cups, milk);

        System.out.println();
        System.out.println("**********");
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }

    static void printCoffeeMachineState(int water, int coffeeBeans, int money, int cups, int milk) {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }

    static void calculateIngredients(Scanner scan) {
        System.out.println("How many cups of coffee you will need:");
        int cups = scan.nextInt();
        int water = cups * 200;
        int milk = cups * 50;
        int coffeeBeans = cups * 15;
        System.out.println("For " + cups + " cups of coffee you will need:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
    }

    static void checkIfIsRequiredAmountOfIngredients(Scanner scan) {
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scan.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scan.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int coffeeBeans = scan.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scan.nextInt();

        int availableWater = water / 200;
        int availableMilk = milk / 50;
        int availableCoffeeBeans = coffeeBeans / 15;
        int availableCups;
        if (availableWater <= availableMilk && availableWater <= availableCoffeeBeans) {
            availableCups = availableWater;
        } else if (availableMilk <= availableWater && availableMilk <= availableCoffeeBeans) {
            availableCups = availableMilk;
        } else {
            availableCups = availableCoffeeBeans;
        }
        if (availableCups > 0) {
            if (water >= cups * 200) {
                if (milk >= cups * 50) {
                    if (coffeeBeans >= cups * 15) {
                        availableCups = availableCups - cups;
                        if (availableCups > 0) {
                            System.out.println("Yes, I can make that amount of coffee (and even " + availableCups + " more than that)");
                        } else {
                            System.out.println("Yes, I can make that amount of coffee");
                        }
                    }
                }
            } else {
                System.out.println("No, I can make only " + availableCups + " cup(s) of coffee");
            }
        } else {
            System.out.println("No, I can make only 0 cup(s) of coffee");
        }
    }
}