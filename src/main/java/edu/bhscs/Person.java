package edu.bhscs;

public class Person {
    // fields / properties
    String name;
    double money;
    Cake ownedCake;

    // Constructor
    public Person(String name, double money) {
        this.name = name;
        this.money = money;
        System.out.println(name + " has $" + money + " to spend!");
    }

    // Get the name of the person
    String getName() {
        return this.name;
    }

    // Get the amount of money the person has
    double getMoney() {
        return this.money;
    }

    // Buy a cake from the store
    void buyCake(Store store, Cake cake, double price) {
        boolean purchaseSuccessful = store.sellCake(this, price);
        if (purchaseSuccessful) {
            this.ownedCake = cake;
            System.out.println(name + " successfully bought a " + cake.getFlavor() + " cake!");
        }
    }

    // Eat a piece of the owned cake
    void eatMyCake() {
        if (ownedCake != null && !ownedCake.isFinished()) {
            System.out.println(name + " is eating their cake...");
            ownedCake.eat();
        } else if (ownedCake != null && ownedCake.isFinished()) {
            System.out.println(name + " has no cake left to eat!");
        } else {
            System.out.println(name + " doesn't have a cake to eat!");
        }
    }

    // Finish the entire owned cake
    void finishCake() {
        if (ownedCake != null && !ownedCake.isFinished()) {
            System.out.println(name + " is devouring their entire cake!");
            while (!ownedCake.isFinished()) {
                ownedCake.eat();
            }
        } else {
            System.out.println(name + " has no cake to finish!");
        }
    }

    // Check if the person has a cake that is not finished
    boolean hasCake() {
        return ownedCake != null && !ownedCake.isFinished();
    }
}