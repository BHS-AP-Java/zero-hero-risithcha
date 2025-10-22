// Risith Kankanamge
// P2
// Zero-Hero
// 10/21/2025

/*
 * DESCRIPTION: Reiber's plug and run code
 * INPUT: User's name and age
 * OUTPUT: A cake with the user's name and age
 * EDGE CASE: User does not provide a name or age
 */

package edu.bhscs;

public class App {
  public static void main(String[] args) {

    Player user = new Player("Usario P. Player");

    String name = user.giveAnswer("What is your name?");
    String age  = user.giveAnswer("How old are you?");

    new Cake().draw(name, age);
  }
}
