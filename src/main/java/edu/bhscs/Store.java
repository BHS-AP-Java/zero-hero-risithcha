// Risith Kankanamge
// P2
// Zero-Hero
// 10/01/2025

/*
 * DESCRIPTION: Store that sells cakes and handles transactions
 * INPUT: Store name and cake price
 * OUTPUT: Transaction success/failure messages
 * EDGE CASE: Customer not having enough money for cake
 */

package edu.bhscs;

public class Store {
  // fields / properties
  String storeName;
  double cakePrice;

  // Constructor
  public Store(String storeName, double cakePrice) {
    this.storeName = storeName;
    this.cakePrice = cakePrice;
    System.out.println("Welcome to " + storeName + "! Cakes cost $" + cakePrice + " each.");
  }

  // Methods

  // Get store name
  String getName() {
    return this.storeName;
  }

  // Sell a cake to a customer
  boolean sellCake(Person customer, double price) {
    System.out.println(customer.getName() + " wants to buy a cake for $" + price);

    if (customer.getMoney() >= price) {
      // Customer has enough money
      customer.money -= price; // Deduct money
      System.out.println(
          "Transaction successful! "
              + customer.getName()
              + " now has $"
              + customer.getMoney()
              + " left.");
      return true;
    } else {
      // Not enough money
      System.out.println(
          "Sorry "
              + customer.getName()
              + ", you need $"
              + (price - customer.getMoney())
              + " more to buy this cake!");
      return false;
    }
  }

  // Sell a cake to a customer
  boolean sellCake(Customer customer, double price) {
    System.out.println(customer.getName() + " wants to buy a cake for $" + price);

    if (customer.getMoney() >= price) {
      // Customer has enough money
      customer.money -= price; // Deduct money
      System.out.println(
          "Transaction successful! "
              + customer.getName()
              + " now has $"
              + customer.getMoney()
              + " left.");
      return true;
    } else {
      // Not enough money
      System.out.println(
          "Sorry "
              + customer.getName()
              + ", you need $"
              + (price - customer.getMoney())
              + " more to buy this cake!");
      return false;
    }
  }

  // Welcome a customer to the store
  void welcomeCustomer(Person customer) {
    System.out.println("Hello " + customer.getName() + "! Welcome to " + storeName + "!");
  }

  // Welcome a customer to the store
  void welcomeCustomer(Customer customer) {
    System.out.println("Hello " + customer.getName() + "! Welcome to " + storeName + "!");
  }
}
