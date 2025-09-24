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

class Main {

    public static void main(String[] args) {

        // Create a store and a person
        Store bakery = new Store("Cake Bake", 15.50);
        Person risith = new Person("Risith", 20.00);

        // Create cakes
        Cake chocolateCake = new Cake("chocolate", "flour", "eggs", "sugar");
        Cake vanillaCake = new Cake("vanilla", "flour", "eggs", "sugar");
        System.out.println();
        System.out.println("    GOING TO THE STORE    ");
        System.out.println();
        bakery.welcomeCustomer(risith);

        System.out.println();
        System.out.println("    BUYING A CAKE    ");
        System.out.println();
        risith.buyCake(bakery, chocolateCake, 15.50);

        System.out.println();
        System.out.println("    EATING THE CAKE    ");
        System.out.println();
        if (risith.hasCake()) {
            // Take a few bites
            risith.eatMyCake();
            risith.eatMyCake();

            // Finish the whole cake
            System.out.println("Time to finish this delicious cake!");
            risith.finishCake();

            // Try to eat more
            risith.eatMyCake();
        }

        System.out.println();
        System.out.println("    TRYING TO BUY ANOTHER CAKE (NOT ENOUGH MONEY)    ");
        System.out.println();
        Person poorCustomer = new Person("Bob", 10.00);
        bakery.welcomeCustomer(poorCustomer);
        poorCustomer.buyCake(bakery, vanillaCake, 15.50);
    }
}