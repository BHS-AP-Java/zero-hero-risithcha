// Risith Kankanamge
// P2
// Zero-Hero
// 10/07/2025

/*
 * DESCRIPTION: Baker who takes orders from Player and makes cakes
 * INPUT: Player instructions
 * OUTPUT: Cakes and transactions
 * EDGE CASE: Baker without a job or flour
 */

package edu.bhscs;

public class Baker {
    // PROPERTIES AND FIELDS
    Player p;
    Flour f;
    Store placeOfWork;
    int cash;
    String name;

    // CONSTRUCTOR
    Baker(Player p) {
        this.p = p;
        this.name = p.getString("Enter baker name: ");
        this.f = new Flour(); // Give baker some default flour
        this.cash = 0;
        System.out.println("Baker " + this.name + " is ready to work!");
    }

    // METHODS
    void takeOrder(int price, Customer c) {
        cash += c.pay(price);
        // c.takeCake(bakeCake());
    }

    Cake bakeCake() {
        // String answer = this.p.giveAnswer("what cake do you you want?");
        // return new Cake(answer, this.f);
        return null;
    }

    void takeJob(Store bakery) {
        String doYouWantToWorkHere = this.p.giveAnswer("Do you want to work at " + bakery.getName());
        if (doYouWantToWorkHere.equals("y")) {
            this.placeOfWork = bakery;
            System.out.println(this.name + " now works at " + bakery.getName());
        }
    }
}
