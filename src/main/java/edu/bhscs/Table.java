// Risith Kankanamge
// P2
// Zero-Hero
// 11/07/2025
/*
 * DESCRIPTION: Table that supports dynamic width and customizable legs/top.
 * INPUT: Height, width, leg style, and top style.
 * OUTPUT: ASCII art of a table with legs at both ends.
 * EDGE CASE: Table with invalid dimensions.
 */

package edu.bhscs;

public class Table {
  private int height;
  private int width;
  private int legs = 2;
  private String legString = "|";
  private String topString = "-";

  public Table(int height, int width) {
    this.height = height;
    this.width = width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getWidth() {
    return width;
  }

  public void setLegs(String leg) {
    this.legString = leg;
  }

  public void setTop(String top) {
    this.topString = top;
  }

  public void setLegCount(int legs) {
    this.legs = Math.max(2, legs);
  }

  public void draw(int offset) {
    // Top border (fencepost: top at both ends)
    for (int i = 0; i < offset; i++) System.out.print(" ");
    for (int i = 0; i < width; i++) {
      int charIndex = i % topString.length();
      System.out.print(topString.substring(charIndex, charIndex + 1));
    }
    System.out.println();

    // Legs (fencepost: legs at both ends)
    for (int h = 0; h < height; h++) {
      for (int i = 0; i < offset; i++) System.out.print(" ");
      for (int i = 0; i < width; i++) {
        // Evenly spaced legs
        boolean isLeg = false;
        for (int l = 0; l < legs; l++) {
          int legPos = (int) Math.round(l * (width - 1.0) / (legs - 1));
          if (i == legPos) isLeg = true;
        }
        if (isLeg) {
          int charIndex = (i % legString.length());
          System.out.print(legString.substring(charIndex, charIndex + 1));
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}
