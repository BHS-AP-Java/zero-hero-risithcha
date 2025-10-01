// Risith Kankanamge
// P2
// Zero-Hero
// 10/01/2025

/*
 * DESCRIPTION: Baker who makes cakes and gets better over time
 * INPUT: Baker name
 * OUTPUT: Cake baking and skill improvement messages
 * EDGE CASE: Baker trying to use special ingredients they don't have
 */

package edu.bhscs;

public class Baker {
    // fields / properties
    String name;
    int skillLevel;
    int cakesMade;
    boolean hasSpecialIngredients;

    // Constructor
    public Baker(String name) {
        this.name = name;
        this.skillLevel = 1; // Start as novice baker
        this.cakesMade = 0;
        this.hasSpecialIngredients = false;
        System.out.println("Baker " + name + " is ready to start baking (Skill Level: " + skillLevel + ")");
    }

    //Methods

    // Get the baker's name
    String getName() {
        return this.name;
    }

    // Get current skill level
    int getSkillLevel() {
        return this.skillLevel;
    }

    // Make a basic cake
    Cake makeCake(String flavor, String ingredient1, String ingredient2, String ingredient3) {
        System.out.println("Baker " + name + " is crafting a " + flavor + " cake...");
        Cake newCake = new Cake(flavor, ingredient1, ingredient2, ingredient3);

        // Baker gains experience with each cake made
        cakesMade++;

        // Add special touches based on skill level
        if (skillLevel >= 2) {
            newCake.addSweetness("perfectly balanced");
            System.out.println("Baker " + name + " is a professional so something good is added...");
        }

        // Improve skill level after making multiple cakes
        if (cakesMade % 3 == 0) {
            skillLevel++;
            System.out.println("Baker " + name + " has improved! New skill level: " + skillLevel);
        }

        return newCake;
    }

    // Get special ingredients
    void getSpecialIngredients() {
        if (!hasSpecialIngredients) {
            hasSpecialIngredients = true;
            System.out.println("Baker " + name + " now has premium ingredients!");
        } else {
            System.out.println("Baker " + name + " already has special ingredients stocked.");
        }
    }

    // Create a premium cake using special ingredients
    Cake makePremiumCake(String flavor) {
        if (!hasSpecialIngredients) {
            System.out.println("Baker " + name + " needs special ingredients first!");
            return makeCake(flavor, "regular flour", "regular eggs", "regular sugar");
        }

        System.out.println("Baker " + name + " is creating a premium " + flavor + " cake with special ingredients!");
        Cake premiumCake = new Cake(flavor, "organic flour", "farm-fresh eggs", "pure cane sugar");
        premiumCake.addSweetness("exquisitely crafted");

        // Premium cakes count toward experience
        cakesMade++;

        // Skill improvement check
        if (cakesMade % 3 == 0) {
            skillLevel++;
            System.out.println("Baker " + name + " has mastered new techniques! Skill level: " + skillLevel);
        }

        return premiumCake;
    }

    // Display baker's current status
    void showBakerStatus() {
        System.out.println("=== BAKER STATUS ===");
        System.out.println("Name: " + name);
        System.out.println("Skill Level: " + skillLevel);
        System.out.println("Cakes Made: " + cakesMade);
        System.out.println("Has Special Ingredients: " + hasSpecialIngredients);
        System.out.println("==================");
    }
}
