// Risith Kankanamge
// P2
// Zero-Hero
// 11/07/2025

/*
 * DESCRIPTION: Entry point for the program.
 * INPUT: None directly; uses hardcoded values for Baker, Table, and Cake.
 * OUTPUT: Draws cakes on a table with dynamic adjustments.
 * EDGE CASE: None.
 */

package edu.bhscs;

public class Main {
  public static void main(String[] args) {
    date10_27();
  }

  public static void date10_27() {
    Baker bob = new Baker("Bob");
    Table t = new Table(3, 15);
    Cake bDay = bob.bakes(5, "Suzzie");
    bDay.draw(t);
  }
}
