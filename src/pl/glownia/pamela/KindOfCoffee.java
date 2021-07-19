package pl.glownia.pamela;

public enum KindOfCoffee {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);

    private int water;
    private int milk;
    private int coffeeBeans;
    private int money;


    KindOfCoffee(int water, int milk, int coffeeBeans, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.money = money;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public int getMoney() {
        return money;
    }
}