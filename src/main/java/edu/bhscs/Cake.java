package edu.bhscs;

public class Cake {
  // fields / properties
  String flavor;
  String ingredient1;
  String ingredient2;
  String ingredient3;
  String sweetness;
  int totalBites;
  int bitesEaten;

  // Need to construct delicious
  public Cake(String flavor, String ingredient1, String ingredient2, String ingredient3) {
    System.out.println("baking a delicious " + flavor + " cake with... " + ingredient1 + ", " + ingredient2 + ", " + ingredient3);
    this.flavor = flavor;
    this.ingredient1 = ingredient1;
    this.ingredient2 = ingredient2;
    this.ingredient3 = ingredient3;
    this.totalBites = 10; // Cake has 10 bites
    this.bitesEaten = 0;
  }

  String getFlavor() {
    return this.flavor;
  }

  void addSweetness(String sweetness) {
    this.sweetness = sweetness;
  }

  String getSweetness() {
    return this.sweetness;
  }

  String getAllIngredients() {
    return this.ingredient1 + ", " + this.ingredient2 + ", " + this.ingredient3;
  }

  // Eating methods
  void eat() {
    if (bitesEaten < totalBites) {
      bitesEaten++;
      System.out.println("Taking a bite of " + flavor + " cake! Delicious!");
      if (bitesEaten == totalBites) {
        System.out.println("Cake is all gone! That was amazing!");
      }
    } else {
      System.out.println("No more cake left to eat!");
    }
  }

  void eatBites(int bites) {
    for (int i = 0; i < bites; i++) {
      eat();
      if (bitesEaten == totalBites) break;
    }
  }

  int getBitesLeft() {
    return totalBites - bitesEaten;
  }

  boolean isFinished() {
    return bitesEaten >= totalBites;
  }

  String getCakeStatus() {
    return "Cake status: " + bitesEaten + "/" + totalBites + " bites eaten";
  }
}
