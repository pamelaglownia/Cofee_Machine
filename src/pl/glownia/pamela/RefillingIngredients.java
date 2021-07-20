package pl.glownia.pamela;

import java.util.Scanner;

public class RefillingIngredients {

    void fillCoffeeMachine(CoffeeMachine coffeeMachine) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add: ");
        int addWater = scan.nextInt();
        coffeeMachine.setWater(coffeeMachine.getWater() + addWater);
        System.out.println("Write how many ml of milk you want to add: ");
        int addMilk = scan.nextInt();
        coffeeMachine.setMilk(coffeeMachine.getMilk() + addMilk);
        System.out.println("Write how many grams of coffee beans you want to add: ");
        int addCoffeeBeans = scan.nextInt();
        coffeeMachine.setCoffeeBeans(coffeeMachine.getCoffeeBeans() + addCoffeeBeans);
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        int addDisposableCups = scan.nextInt();
        coffeeMachine.setCups(coffeeMachine.getCups() + addDisposableCups);
        coffeeMachine.printCoffeeMachineState();
    }
}
