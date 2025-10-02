// Risith Kankanamge
// P2
// Zero-Hero
// 10/01/2025

/*
 * DESCRIPTION: Interactive bakery where you can be baker, customer, or run PTSA
 * INPUT: User picking what they wanna do and making choices
 * OUTPUT: Cool bakery simulation that changes based on what you do
 * EDGE CASE: People typing wrong stuff and different role interactions
 */

package edu.bhscs;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    // fields / properties
    private static Scanner scanner = new Scanner(System.in);
    private static Store mainStore;
    private static PTSA schoolPTSA;
    private static Baker currentBaker;
    private static Customer currentCustomer;
    private static ArrayList<Cake> availableCakes = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the economy");
        System.out.println();

        // Initialize the bakery economy
        initializeEconomy();

        // Main game loop
        boolean playing = true;
        while (playing) {
            displayMainMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    playAsBaker();
                    break;
                case 2:
                    playAsCustomer();
                    break;
                case 3:
                    managePTSA();
                    break;
                case 4:
                    viewStatusMenu();
                    break;
                case 5:
                    playing = false;
                    System.out.println("Thanks for playing! Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }

    private static void initializeEconomy() {
        System.out.println("");
        System.out.println("Let's set up your bakery!");
        System.out.print("Enter your bakery name: ");
        String bakeryName = scanner.nextLine();

        mainStore = new Store(bakeryName, 15.50);
        schoolPTSA = new PTSA("Lockwood Elementary PTSA", 500.0);

        System.out.println();
        System.out.println("Your bakery economy is ready!");
    }

    private static void displayMainMenu() {
        System.out.println();
        System.out.println("=== MAIN MENU ===");
        System.out.println("1. Play as Baker");
        System.out.println("2. Play as Customer");
        System.out.println("3. Manage PTSA");
        System.out.println("4. Status Menu");
        System.out.println("5. Exit");
        System.out.println("================");
    }

    private static void playAsBaker() {
        if (currentBaker == null) {
            System.out.print("Enter baker name: ");
            String bakerName = scanner.nextLine();
            currentBaker = new Baker(bakerName);
        }

        boolean bakerMode = true;
        while (bakerMode) {
            System.out.println();
            System.out.println("=== BAKER MENU ===");
            System.out.println("1. Bake a regular cake");
            System.out.println("2. Get special ingredients");
            System.out.println("3. Make premium cake");
            System.out.println("4. View baker status");
            System.out.println("5. Return to main menu");

            int choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    bakeCakeInteractive();
                    break;
                case 2:
                    currentBaker.getSpecialIngredients();
                    break;
                case 3:
                    makePremiumCakeInteractive();
                    break;
                case 4:
                    currentBaker.showBakerStatus();
                    break;
                case 5:
                    bakerMode = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void bakeCakeInteractive() {
        System.out.print("Enter cake flavor: ");
        String flavor = scanner.nextLine();
        System.out.print("Enter first ingredient: ");
        String ing1 = scanner.nextLine();
        System.out.print("Enter second ingredient: ");
        String ing2 = scanner.nextLine();
        System.out.print("Enter third ingredient: ");
        String ing3 = scanner.nextLine();

        Cake newCake = currentBaker.makeCake(flavor, ing1, ing2, ing3);
        availableCakes.add(newCake);
        System.out.println("Cake added to inventory!");
    }

    private static void makePremiumCakeInteractive() {
        if (!currentBaker.hasSpecialIngredients) {
            System.out.println("You need special ingredients first! Get them from the baker menu.");
            return;
        }

        System.out.print("Enter premium cake flavor: ");
        String flavor = scanner.nextLine();

        Cake premiumCake = currentBaker.makePremiumCake(flavor);
        availableCakes.add(premiumCake);
        System.out.println("Premium cake created and added to inventory!");
    }

    private static void playAsCustomer() {
        if (currentCustomer == null) {
            System.out.print("Enter customer name: ");
            String customerName = scanner.nextLine();
            double budget = getDoubleInput("Enter your budget: $");
            System.out.print("Enter your favorite cake flavor: ");
            String favoriteFlavor = scanner.nextLine();
            currentCustomer = new Customer(customerName, budget, favoriteFlavor);
        }

        boolean customerMode = true;
        while (customerMode) {
            System.out.println();
            System.out.println("=== CUSTOMER MENU ===");
            System.out.println("1. Visit the store");
            System.out.println("2. Buy a cake");
            System.out.println("3. Enjoy cake");
            System.out.println("4. Devour cake");
            System.out.println("5. View customer status");
            System.out.println("6. Return to main menu");

            int choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    mainStore.welcomeCustomer(currentCustomer);
                    break;
                case 2:
                    purchaseCakeInteractive();
                    break;
                case 3:
                    currentCustomer.enjoyCake();
                    break;
                case 4:
                    currentCustomer.devourCake();
                    break;
                case 5:
                    currentCustomer.showCustomerStatus();
                    break;
                case 6:
                    customerMode = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void purchaseCakeInteractive() {
        if (availableCakes.isEmpty()) {
            System.out.println("No cakes available! Ask the baker to make some first.");
            return;
        }

        System.out.println("Available cakes:");
        for (int i = 0; i < availableCakes.size(); i++) {
            Cake cake = availableCakes.get(i);
            System.out.println((i + 1) + ". " + cake.getFlavor() + " cake");
        }

        int cakeChoice = getIntInput("Pick a cake number: ") - 1;
        if (cakeChoice >= 0 && cakeChoice < availableCakes.size()) {
            Cake selectedCake = availableCakes.get(cakeChoice);
            double price = 15.50; // Use store's default cake price

            // Apply loyalty discount if possible
            if (currentCustomer.cakesPurchased >= 2) {
                price = currentCustomer.getLoyaltyDiscount(price);
                System.out.println("Loyalty discount applied!");
            }

            currentCustomer.purchaseCake(mainStore, selectedCake, price);
            schoolPTSA.receiveDonation(price, "cake sale");
        } else {
            System.out.println("That's not a valid cake number!");
        }
    }

    private static void managePTSA() {
        boolean ptsaMode = true;
        while (ptsaMode) {
            System.out.println();
            System.out.println("=== PTSA STUFF ===");
            System.out.println("1. Make a donation");
            System.out.println("2. Organize an event");
            System.out.println("3. Spend some funds");
            System.out.println("4. View PTSA status");
            System.out.println("5. Return to main menu");

            int choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    double amount = getDoubleInput("Enter donation amount: $");
                    System.out.print("Enter donation source: ");
                    String source = scanner.nextLine();
                    schoolPTSA.receiveDonation(amount, source);
                    break;
                case 2:
                    System.out.print("Enter event name: ");
                    String eventName = scanner.nextLine();
                    schoolPTSA.organizeEvent(eventName);
                    break;
                case 3:
                    double allocAmount = getDoubleInput("Enter amount to allocate: $");
                    System.out.print("Enter purpose: ");
                    String purpose = scanner.nextLine();
                    schoolPTSA.allocateFunds(allocAmount, purpose);
                    break;
                case 4:
                    schoolPTSA.showPTSAStatus();
                    break;
                case 5:
                    ptsaMode = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void viewStatusMenu() {
        System.out.println();
        System.out.println("=== STATUS MENU ===");
        System.out.println();
        System.out.println("Cakes available: " + availableCakes.size());
        for (Cake cake : availableCakes) {
            cake.getCakeStatus();
        }

        if (currentBaker != null) {
            System.out.println();
            System.out.println("--- Baker Info ---");
            currentBaker.showBakerStatus();
        }

        if (currentCustomer != null) {
            System.out.println();
            System.out.println("--- Customer Info ---");
            currentCustomer.showCustomerStatus();
        }

        System.out.println();
        System.out.println("--- PTSA Info ---");
        schoolPTSA.showPTSAStatus();
    }

    // Helper methods to make sure everything works smoothly
    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }

    private static double getDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        double result = scanner.nextDouble();
        scanner.nextLine();
        return result;
    }
}
