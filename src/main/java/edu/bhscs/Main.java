// Risith Kankanamge
// P2
// Zero-Hero
// 09/19/2025

/*
 * DESCRIPTION: Creates and uses a Cake object
 * INPUT: None
 * OUTPUT: Cake details printed to console
 * EDGE CASE: None
 */

package edu.bhscs;

class Main {

  public static void main(String[] args) {

    Cake chocoCake = new Cake("chocolate", "flour", "eggs", "sugar");
    System.out.println("Cake flavor: " + chocoCake.getFlavor());
    chocoCake.addSweetness("extra sweet");
    System.out.println("Sweetness level: " + chocoCake.getSweetness());
    System.out.println("All ingredients: " + chocoCake.getAllIngredients());

    System.out.println("--- Time to eat! ---");
    System.out.println(chocoCake.getCakeStatus());

    // Take a few bites
    chocoCake.eat();
    chocoCake.eat();
    System.out.println("Bites left: " + chocoCake.getBitesLeft());

    // Eat multiple bites at once
    chocoCake.eatBites(3);
    System.out.println(chocoCake.getCakeStatus());

    // Finish the cake
    while (!chocoCake.isFinished()) {
      chocoCake.eat();
    }

    // Try to eat more (should say no more left)
    chocoCake.eat();
  }
}