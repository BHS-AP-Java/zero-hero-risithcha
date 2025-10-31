// Risith Kankanamge
// P2
// Zero-Hero - Part 2 & 3
// 10/07/2025

/*
 * GOAL: Interactive bakery simulation where users can play as baker, customer, or manage PTSA
 * INPUT: User choices through menus, names, numbers, yes/no answers
 * OUTPUT: Menu displays, transaction messages, status updates, cake baking results
 * EDGE CASES: Invalid menu choices, Customer trying to buy cake without enough money, Baker attempting to make premium cake without special ingredients, Trying to eat cake that's already finished, Empty cake inventory when customer wants to purchase, PTSA trying to spend more funds than available, User entering negative prices or amounts (handled by validation)
 */

package edu.bhscs;

import java.util.ArrayList;

public class Main {
  private static void initializeEconomy() {
    System.out.println("");
    System.out.println("Let's set up your bakery!");
    String bakeryName = player.getString("Enter your bakery name: ");
    mainStore = new Store(bakeryName, 15.50);
    schoolPTSA = new PTSA("Lockwood Elementary PTSA", 500.0);

    System.out.println();
    System.out.println("Your bakery economy is ready!");
  }

  // fields / properties
  private static Player player;
  private static Store mainStore;
  private static PTSA schoolPTSA;
  private static Baker currentBaker;
  private static Customer currentCustomer;
  private static ArrayList<Cake> availableCakes = new ArrayList<>();

  public static void main(String[] args) {
    // Constructor
    player = new Player();

    date10_27();

    String name = player.getString("What is your name?");
    int age = player.getInt("How old are you?");

    Cake cake = new Cake("Vanilla", "Chocolate", 5, 10, 3);
    cake.draw(name, String.valueOf(age));

    System.out.println("Welcome to the economy");
    System.out.println();

    // Initialize the bakery economy
    initializeEconomy();

    // Main game loop
    boolean playing = true;
    while (playing) {
      displayMainMenu();
      int choice = player.getInt("Enter your choice: ");

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
    player.close();
  }

  public static void date10_27() {
      Baker bob = new Baker("Bob");
      Table t = new Table(3, 15);
      Cake bDay = bob.bakes(5, "Suzzie");
      bDay.draw(t);
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
      //currentBaker = new Baker(player);
    }

    boolean bakerMode = true;
    while (bakerMode) {
      System.out.println();
      System.out.println("=== BAKER MENU ===");
      System.out.println("1. Take an order from a customer");
      System.out.println("2. Bake a cake");
      System.out.println("3. Apply for job at store");
      System.out.println("4. Return to main menu");

      int choice = player.getInt("Enter your choice: ");
      switch (choice) {
        case 1:
          takeOrderInteractive();
          break;
        case 2:
          Cake newCake = currentBaker.bakeCake();
          availableCakes.add(newCake);
          System.out.println("Cake added to inventory!");
          break;
        case 3:
          currentBaker.takeJob(mainStore);
          break;
        case 4:
          bakerMode = false;
          break;
        default:
          System.out.println("Invalid choice!");
      }
    }
  }

  private static void takeOrderInteractive() {
    if (currentCustomer == null) {
      System.out.println("No customer available! Please create a customer first.");
      return;
    }
    int price = player.getInt("Enter the price for the cake: $");
    currentBaker.takeOrder(price, currentCustomer);
  }

  private static void playAsCustomer() {
    if (currentCustomer == null) {
      String customerName = player.getString("Enter customer name: ");
      double budget = player.getDouble("Enter your budget: $");
      String favoriteFlavor = player.getString("Enter your favorite cake flavor: ");
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

      int choice = player.getInt("Enter your choice: ");
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
      // Cake cake = availableCakes.get(i);
      // System.out.println((i + 1) + ". " + cake.getFlavor() + " cake");
    }

    int cakeChoice = player.getInt("Pick a cake number: ") - 1;
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

      int choice = player.getInt("Enter your choice: ");
      switch (choice) {
        case 1:
          double amount = player.getDouble("Enter donation amount: $");
          String source = player.getString("Enter donation source: ");
          schoolPTSA.receiveDonation(amount, source);
          break;
        case 2:
          String eventName = player.getString("Enter event name: ");
          schoolPTSA.organizeEvent(eventName);
          break;
        case 3:
          double allocAmount = player.getDouble("Enter amount to allocate: $");
          String purpose = player.getString("Enter purpose: ");
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
    // for (Cake cake : availableCakes) {
    //   System.out.println(" - " + cake.getCakeStatus());
    // }

    if (currentBaker != null) {
      System.out.println();
      System.out.println("--- Baker Info ---");
      System.out.println("Name: " + currentBaker.name);
      System.out.println("Cash: $" + currentBaker.cash);
      if (currentBaker.placeOfWork != null) {
        System.out.println("Works at: " + currentBaker.placeOfWork.getName());
      }
    }

    if (currentCustomer != null) {
      System.out.println();
      System.out.println("--- Customer Info ---");
      currentCustomer.showCustomerStatus();
    }

    System.out.println();
    System.out.println("--- PTSA Info ---");
    schoolPTSA.showPTSAStatus();
    String alignment = "center";
    if (alignment.equals("center")) {
        System.out.println("hmmmmmmmmm");
    }
  }
}
