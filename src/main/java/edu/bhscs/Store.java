package edu.bhscs;

public class Store {
    // fields / properties
    String storeName;
    double cakePrice;

    // Constructor
    public Store(String storeName, double cakePrice) {
        this.storeName = storeName;
        this.cakePrice = cakePrice;
        System.out.println("Welcome to " + storeName + "! Cakes cost $" + cakePrice + " each.");
    }

    // Sell a cake to a customer
    boolean sellCake(Person customer, double price) {
        System.out.println(customer.getName() + " wants to buy a cake for $" + price);

        if (customer.getMoney() >= price) {
            // Customer has enough money
            customer.money -= price; // Deduct money
            System.out.println("Transaction successful! " + customer.getName() + " now has $" + customer.getMoney() + " left.");
            return true;
        } else {
            // Not enough money
            System.out.println("Sorry " + customer.getName() + ", you need $" + (price - customer.getMoney()) + " more to buy this cake!");
            return false;
        }
    }

    // Welcome a customer to the store
    void welcomeCustomer(Person customer) {
        System.out.println("Hello " + customer.getName() + "! Welcome to " + storeName + "!");
    }
}