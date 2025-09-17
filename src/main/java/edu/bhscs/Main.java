// Risith Kankanamge
// P2
// Zero-Hero
// 09/12/2025

/*
 * DESCRIPTION: Whatever Mr. Reiber says
 * INPUT: We don't know about input yet
 * OUTPUT: Some cool works in the command line terminal thing
 * EDGE CASE: They are all edge cases at the moment
 */

package edu.bhscs;

/*
public class Main {
  // this is an example of a 'char' constant
  // because it is global, it should be in capital letters
  public static final char A = 'a';

  public static void main(String[] args) {
    int someNumber = 67;

    // for-loop control structure! :o
    for (int i = 0; i < 2; i++) {
      System.out.println("Run " + (i + 1) + ":");
      // call to a method that prints the lines
      replacementIsTheGatewayToAbstractions(someNumber);
      System.out.println("---"); // line between the runs
    }
  }

  // method that contains the lines to be printed
  public static void replacementIsTheGatewayToAbstractions(int someNumber) {
    System.out.println("67!" + A + someNumber);
    System.out.print(A + "?" + A + someNumber);
    System.out.print(A + A + someNumber);
    System.out.println();

    // if/else control structure! :)
    if (someNumber > 50) {
      System.out.println("this is neet");
    } else {
      System.out.println("this is not neet");
    }

    System.out.println();
    System.out.println();
    System.out.println("OK I am done");
  }
}
*/
class Main {

  public static final char A = 'a';
  public static final float FLOAT = 214.1234f;

  public static void main(String[] args) {

    Awesome steve = new Awesome("steve");
    Awesome sue = new Awesome("sue");
    Awesome linda = new Awesome("linda");
    Awesome john = new Awesome("john");
    System.out.println(steve.getName());
    System.out.println(sue.getName());
    System.out.println(linda.getName());
    System.out.println(john.getName());
  }

  public static int awesome() {

    return 3;
  }

  public static String pushup(String food) {

    return "Sweat " + food;
  }
}
