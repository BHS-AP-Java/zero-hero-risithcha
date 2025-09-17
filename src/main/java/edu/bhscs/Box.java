// Risith Kankanamge
// P2
// Zero-Hero
// 09/17/2025

/*
 * DESCRIPTION:
 * INPUT:
 * OUTPUT:
 * EDGE CASE:
 */

package edu.bhscs;

// Custom TYPE Box
public class Box {

  // Color of the Box
  private String color;

  // Constructor
  public Box(String color) {
    this.color = color;
  }

  // Method
  public void show() {
    System.out.println("I am a " + color + " box");
  }
}

// Showcasing the custom TYPE Box
class BoxShow {
  public static void main(String[] args) {
    Box box1 = new Box("red");
    Box box2 = new Box("blue");
    box1.show();
    box2.show();
  }
}
