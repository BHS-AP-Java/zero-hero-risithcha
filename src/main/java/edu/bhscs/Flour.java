// Risith Kankanamge
// P2
// Zero-Hero
// 10/07/2025

/*
 * DESCRIPTION: Flour resource used by bakers to make cakes
 * INPUT: None
 * OUTPUT: Flour properties
 * EDGE CASE: Running out of flour (if we track quantity)
 */

package edu.bhscs;

public class Flour {
  // fields / properties
  private String type;
  private int quality;

  // Constructor
  public Flour() {
    this.type = "all-purpose";
    this.quality = 5;
  }

  public Flour(String type, int quality) {
    this.type = type;
    this.quality = quality;
  }

  // Methods
  public String getType() {
    return this.type;
  }

  public int getQuality() {
    return this.quality;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setQuality(int quality) {
    this.quality = quality;
  }
}
