// Risith Kankanamge
// P2
// Zero-Hero
// 11/07/2025

/*
 * DESCRIPTION: Baker who creates cakes for customers.
 * INPUT: Number of cakes and recipient name.
 * OUTPUT: Cakes with dynamic properties.
 * EDGE CASE: Baker without a name.
 */

package edu.bhscs;

public class Baker {
  // Fields / Properties
  String name;

  // Constructor
  Baker(String name) {
    this.name = name;
    System.out.println("Baker " + this.name + " is ready to work!");
  }

  // Methods
  Cake bakes(int count, String recipientName) {
    return new Cake("Vanilla", "Chocolate", 3, 10, count, recipientName);
  }

}
