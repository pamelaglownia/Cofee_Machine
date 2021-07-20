package pl.glownia.pamela;

public class Order {
    private CoffeeMachine coffeeMachine;

    public Order(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

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

    void makeCoffee(CoffeeMachine coffeeMachine, KindOfCoffee coffee) {
        if (verifyRequiredIngredients(coffeeMachine, coffee)) {
            coffeeMachine.setWater(coffeeMachine.getWater() - coffee.getWater());
            coffeeMachine.setMilk(coffeeMachine.getMilk() - coffee.getMilk());
            coffeeMachine.setCoffeeBeans(coffeeMachine.getCoffeeBeans() - coffee.getCoffeeBeans());
            coffeeMachine.setMoney(coffeeMachine.getMoney() - coffee.getMoney());
            coffeeMachine.setMilk(coffeeMachine.getMilk() - coffee.getMilk());
            coffeeMachine.setCups(coffeeMachine.getCups() - 1);
        }
    }
}