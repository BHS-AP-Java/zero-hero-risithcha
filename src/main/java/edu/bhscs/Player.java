// Risith Kankanamge
// P2
// Zero-Hero
// 10/07/2025

/*
 * DESCRIPTION: Player/User class that wraps Scanner for all user input
 * INPUT: Various user inputs through Scanner
 * OUTPUT: Prompts and collected responses
 * EDGE CASE: Invalid input
 */

package edu.bhscs;

import java.util.Scanner;

public class Player {
    // fields / properties
    private Scanner scanner;

    // Constructor
    public Player() {
        this.scanner = new Scanner(System.in);
    }

    public Player(String name) {
        this.scanner = new Scanner(System.in);
    }

    // Methods

    // gets integer from user with error checking
    public int getInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }

    // gets double from user with error checking
    public double getDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        double result = scanner.nextDouble();
        scanner.nextLine();
        return result;
    }

    // asks user yes or no question
    public String getYesNo(String prompt) {
        System.out.print(prompt + " (y/n): ");
        String answer = scanner.nextLine().toLowerCase();
        while (!answer.equals("y") && !answer.equals("n")) {
            System.out.print("Please enter 'y' or 'n': ");
            answer = scanner.nextLine().toLowerCase();
        }
        return answer;
    }

    // gets name from user
    public String getName() {
        System.out.print("Enter name: ");
        return scanner.nextLine();
    }

    // asks user any question and gets their answer
    public String giveAnswer(String prompt) {
        System.out.print(prompt + " ");
        return scanner.nextLine();
    }

    // gets any string from user
    public String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // closes scanner when done
    public void close() {
        scanner.close();
    }
}
