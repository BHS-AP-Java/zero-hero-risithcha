// Risith Kankanamge
// P2
// Zero-Hero
// 10/01/2025

/*
 * DESCRIPTION: Customer who buys cakes and gets more satisfied and loyal
 * INPUT: Name and money
 * OUTPUT: Customer satisfaction and loyalty changes
 * EDGE CASE: Customer becoming so loyal they get discounts
 */

package edu.bhscs;

public class Customer {
    // fields / properties
    String name;
    double money;
    Cake ownedCake;
    int satisfactionLevel;
    int cakesPurchased;
    boolean isLoyalCustomer;
    String favoredFlavor;

    // Constructor
    public Customer(String name, double money, String favoredFlavor) {
        this.name = name;
        this.money = money;
        this.satisfactionLevel = 5; // Start with neutral satisfaction (1-10 scale)
        this.cakesPurchased = 0;
        this.isLoyalCustomer = false;
        this.favoredFlavor = favoredFlavor;
        System.out.println("Customer " + name + " arrives with $" + money + " and loves " + favoredFlavor + " cakes!");
    }

    // Methods

    // Get customer name
    String getName() {
        return this.name;
    }

    // Get current money
    double getMoney() {
        return this.money;
    }

    // Get satisfaction level
    int getSatisfactionLevel() {
        return this.satisfactionLevel;
    }

    // Purchase a cake from a store
    void purchaseCake(Store store, Cake cake, double price) {
        System.out.println("Customer " + name + " is considering buying a " + cake.getFlavor() + " cake...");

        boolean purchaseSuccessful = store.sellCake(this, price);
        if (purchaseSuccessful) {
            this.ownedCake = cake;
            this.cakesPurchased++;

            // Check if this matches their favored flavor
            if (cake.getFlavor().equals(favoredFlavor)) {
                satisfactionLevel += 2;
                System.out.println("Customer " + name + " is extra happy! It's their favorite " + favoredFlavor + " cake!");
            } else {
                satisfactionLevel += 1;
                System.out.println("Customer " + name + " is pleased with their purchase!");
            }

            // Become loyal customer after multiple purchases
            if (cakesPurchased >= 3 && !isLoyalCustomer) {
                isLoyalCustomer = true;
                System.out.println("Customer " + name + " has become a loyal customer after " + cakesPurchased + " purchases!");
            }

        } else {
            // Decrease satisfaction when can't afford cake
            satisfactionLevel -= 1;
            System.out.println("Customer " + name + " is disappointed they can't afford the cake...");
        }
    }

    // Enjoy the purchased cake
    void enjoyCake() {
        if (ownedCake != null && !ownedCake.isFinished()) {
            System.out.println("Customer " + name + " is enjoying their delicious cake!");
            ownedCake.eat();

            // Eating cake increases satisfaction
            if (satisfactionLevel < 10) {
                satisfactionLevel++;
                System.out.println("Customer " + name + " feels happier! (Satisfaction: " + satisfactionLevel + "/10)");
            }
        } else if (ownedCake != null && ownedCake.isFinished()) {
            System.out.println("Customer " + name + " has finished their cake and wants more!");
        } else {
            System.out.println("Customer " + name + " has no cake to enjoy!");
        }
    }

    // Finish entire cake quickly
    void devourCake() {
        if (ownedCake != null && !ownedCake.isFinished()) {
            System.out.println("Customer " + name + " eats the entire cake");
            while (!ownedCake.isFinished()) {
                ownedCake.eat();
            }
            // Big satisfaction boost for finishing a whole cake
            satisfactionLevel = Math.min(10, satisfactionLevel + 2);
            System.out.println("Customer " + name + " is very satisfied! (Satisfaction: " + satisfactionLevel + "/10)");
        } else {
            System.out.println("Customer " + name + " has no cake to devour!");
        }
    }

    // Check if customer has a cake
    boolean hasCake() {
        return ownedCake != null && !ownedCake.isFinished();
    }

    // Get loyalty discount if possible
    double getLoyaltyDiscount(double originalPrice) {
        if (isLoyalCustomer) {
            double discount = originalPrice * 0.1; // 10% discount for loyal customers
            System.out.println("Loyal customer " + name + " gets a $" + String.format("%.2f", discount) + " discount!");
            return originalPrice - discount;
        }
        return originalPrice;
    }

    // Display customer status
    void showCustomerStatus() {
        System.out.println("=== CUSTOMER STATUS ===");
        System.out.println("Name: " + name);
        System.out.println("Money: $" + money);
        System.out.println("Satisfaction Level: " + satisfactionLevel + "/10");
        System.out.println("Cakes Purchased: " + cakesPurchased);
        System.out.println("Loyal Customer: " + isLoyalCustomer);
        System.out.println("Favorite Flavor: " + favoredFlavor);
        System.out.println("=====================");
    }

    // Pay for a cake and return the amount paid
    int pay(int price) {
        if (this.money >= price) {
            this.money -= price;
            System.out.println(this.name + " pays $" + price);
            return price;
        } else {
            System.out.println(this.name + " doesn't have enough money!");
            return 0;
        }
    }

    // Receive a cake
    void takeCake(Cake cake) {
        this.ownedCake = cake;
        this.cakesPurchased++;
        System.out.println(this.name + " receives a " + cake.getFlavor() + " cake!");
    }
}
