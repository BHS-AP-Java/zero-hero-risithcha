// Risith Kankanamge
// P2
// Zero-Hero
// 09/19/2025

/*
 * DESCRIPTION: Person goes to store, buys cake, and eats it
 * INPUT: None
 * OUTPUT: Store transaction and cake eating
 * EDGE CASE: Not enough money to buy cake
 */

package edu.bhscs;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to the economy");
        System.out.println();

        // Set up the bakery stuff
        Store bakery = new Store("Sweet Bakery", 15.50);
        Baker chef = new Baker("Marcel");
        Customer alice = new Customer("Alice", 50.00, "chocolate");
        Customer bob = new Customer("Bob", 25.00, "vanilla");
        PTSA schoolPTSA = new PTSA("Lockwood Elementary PTSA", 200.00);

        System.out.println();
        System.out.println("First let's see the baker make some cakes");

        // Baker creates cakes and gets better
        Cake firstCake = chef.makeCake("chocolate", "flour", "eggs", "sugar");
        System.out.println();
        firstCake.getCakeStatus();

        System.out.println();
        System.out.println("Now Alice is gonna buy and eat a cake");

        alice.showCustomerStatus();
        System.out.println();

        bakery.welcomeCustomer(alice);
        alice.purchaseCake(bakery, firstCake, 15.50);

        // PTSA gets money from the sale
        schoolPTSA.receiveDonation(15.50, "cake sale");
        System.out.println();

        // Watch the cake get eaten
        System.out.println("Alice is now going to eat the cake");
        firstCake.showCakeEvolution();

        alice.enjoyCake();
        alice.enjoyCake();
        firstCake.showCakeEvolution();

        alice.devourCake();
        firstCake.showCakeEvolution();

        System.out.println();
        System.out.println("Baker is getting better at making cakes");

        chef.showBakerStatus();
        System.out.println();

        // More cakes = better skills
        Cake secondCake = chef.makeCake("vanilla", "flour", "eggs", "sugar");
        Cake thirdCake = chef.makeCake("strawberry", "flour", "eggs", "sugar");

        System.out.println();
        chef.showBakerStatus();

        System.out.println();
        System.out.println("Time for some fancy premium cakes");

        chef.getSpecialIngredients();
        Cake premiumCake = chef.makePremiumCake("red velvet");
        System.out.println("Premium cake ingredients: " + premiumCake.getAllIngredients());
        System.out.println("Premium cake sweetness: " + premiumCake.getSweetness());

        System.out.println();
        System.out.println("Bob's gonna buy multiple cakes and become a loyal customer");

        bakery.welcomeCustomer(bob);

        // Bob buys his first cake
        bob.purchaseCake(bakery, secondCake, 15.50);
        schoolPTSA.receiveDonation(15.50, "cake sale");
        bob.enjoyCake();
        bob.showCustomerStatus();
        System.out.println();

        // Second cake
        bob.purchaseCake(bakery, thirdCake, 15.50);
        schoolPTSA.receiveDonation(15.50, "cake sale");
        bob.devourCake();

        // Third cake with loyalty discount
        double discountedPrice = bob.getLoyaltyDiscount(15.50);
        bob.purchaseCake(bakery, premiumCake, discountedPrice);
        schoolPTSA.receiveDonation(discountedPrice, "discounted cake sale");

        System.out.println();
        bob.showCustomerStatus();

        System.out.println();
        System.out.println("PTSA is trying to reach their fundraising goal");

        schoolPTSA.showPTSAStatus();
        schoolPTSA.organizeEvent("Bake Sale Extravaganza");
        System.out.println();
        schoolPTSA.showPTSAStatus();

        System.out.println();
        System.out.println("No dinero?");

        Customer poorCustomer = new Customer("Charlie", 10.00, "lemon");
        bakery.welcomeCustomer(poorCustomer);

        Cake expensiveCake = chef.makePremiumCake("tiramisu");
        poorCustomer.purchaseCake(bakery, expensiveCake, 15.50);
        poorCustomer.showCustomerStatus();

        System.out.println();
        System.out.println("FINAL STATS :0");
        System.out.println();

        chef.showBakerStatus();
        System.out.println();
        alice.showCustomerStatus();
        System.out.println();
        bob.showCustomerStatus();
        System.out.println();
        poorCustomer.showCustomerStatus();
        System.out.println();
        schoolPTSA.showPTSAStatus();

        System.out.println();
    }
}
