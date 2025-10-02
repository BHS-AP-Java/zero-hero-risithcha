// Risith Kankanamge
// P2
// Zero-Hero
// 10/01/2025

/*
 * DESCRIPTION: Delicious cake that can be baked, customized, and eaten bite by bite
 * INPUT: Flavor and ingredients
 * OUTPUT: Cake creation and eating messages
 * EDGE CASE: Trying to eat cake that's already finished
 */

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

    // Constructor
    public Cake(String flavor, String ingredient1, String ingredient2, String ingredient3) {
        System.out.println("baking a delicious " + flavor + " cake with " + ingredient1 + ", " + ingredient2 + ", " + ingredient3);
        this.flavor = flavor;
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.ingredient3 = ingredient3;
        this.totalBites = 10; // Cake has 10 bites
        this.bitesEaten = 0;
    }

    // Methods
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
            System.out.println("Taking a bite of " + flavor + " cake! Amazing!");
            if (bitesEaten == totalBites) {
                System.out.println("Cake is all gone! Fatty!");
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

    // Method to show how cake changes over time
    void showCakeEvolution() {
        System.out.println("=== CAKE EVOLUTION STATUS ===");
        System.out.println("Flavor: " + flavor);
        System.out.println("Ingredients: " + getAllIngredients());
        if (sweetness != null) {
            System.out.println("Sweetness level: " + sweetness);
        }
        System.out.println("Bites eaten: " + bitesEaten + "/" + totalBites);

        // Show different states of the cake
        if (bitesEaten == 0) {
            System.out.println("State: Fresh and untouched");
        } else if (bitesEaten < totalBites / 3) {
            System.out.println("State: Lightly sampled");
        } else if (bitesEaten < (2 * totalBites) / 3) {
            System.out.println("State: Half-eaten");
        } else if (bitesEaten < totalBites) {
            System.out.println("State: Nearly finished");
        } else {
            System.out.println("State: Completely consumed");
        }
        System.out.println("============================");
    }
}
