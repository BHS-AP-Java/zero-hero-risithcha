package edu.bhscs;

public class App {
    public static void main(String[] args) {
        date_10_21();
        System.out.println("I am the app!");
    }

    public static void date_10_21() {
        Player user = new Player("Usario P. Player");

        String name = user.giveAnswer("What is your name?");
        String age = user.giveAnswer("How old are you?");

        new Cake().draw(name, age);
    }
}
