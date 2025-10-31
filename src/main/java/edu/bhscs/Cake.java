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
  String frosting;
  int totalBites;
  int bitesEaten;
  int height;
  int width;
  int layers;

  // Constructor
  public Cake(String flavor, String frosting, int height, int width, int layers) {
    System.out.println("baking a " + flavor + " cake with " + frosting + " frosting");
    this.flavor = flavor;
    this.frosting = frosting;
    this.height = height;
    this.width = width;
    this.layers = layers;
    this.totalBites = height * layers;
    this.bitesEaten = 0;
  }

  public Cake() {
    this("Vanilla", "Chocolate", 3, 10, 1);
  }

  /*
  void draw() {
      String title = "baking a " + flavor + " cake with " + frosting + " frosting";
      int artWidth = Math.max(width + 6, title.length());

      // Print title
      System.out.println(title);

      // Candles and flames across the cake top
      String candlesLine = "";
      String flamesLine = "";
      for (int i = 0; i < artWidth - 4; i++) {
          candlesLine += 'i';
          flamesLine += '^';
      }
      System.out.println(candlesLine);
      System.out.println(flamesLine);

      // Frosting top (underscores)
      String top = "  ";
      for (int i = 0; i < artWidth - 4; i++) top += '_';
      System.out.println(top);

      // Frosting wavy line
      String wave = "/";
      for (int i = 0; i < artWidth - 3; i++) {
          wave += (i % 2 == 0) ? '~' : ' ';
      }
      wave += '\\';
      System.out.println(wave);

      // Layers
      for (int layer = 0; layer < layers; layer++) {
          String line = "|";
          for (int i = 0; i < artWidth - 2; i++) {
              line += (i % 3 == 0) ? '=' : '-';
          }
          line += "|";
          System.out.println(line);
      }

      // Cake body (height)
      for (int h = 0; h < height; h++) {
          String body = "|";
          for (int i = 0; i < artWidth - 2; i++) body += ' ';
          body += "|";
          System.out.println(body);
      }

      // Base
      String base = " ";
      for (int i = 0; i < artWidth - 2; i++) base += '-';
      System.out.println(base);

      // Info
      System.out.println();
      System.out.println("Flavor: " + flavor + " | Frosting: " + frosting + " | Layers: " + layers);
      System.out.println("Bites left: " + (totalBites - bitesEaten) + "/" + totalBites);
  }
  */

  public void draw(String name, String age) {
    String title = "Happy Birthday, " + name + "! You are " + age + " years old!";
    int artWidth = Math.max(width + 6, title.length());

    // Print title
    System.out.println(title);
    System.out.println("This is a " + flavor + " cake with " + frosting + " frosting.");

    // Candles and flames across the cake top
    String candlesLine = "";
    String flamesLine = "";
    for (int i = 0; i < artWidth - 4; i++) {
      candlesLine += 'i';
      flamesLine += '^';
    }
    System.out.println(candlesLine);
    System.out.println(flamesLine);

    // Frosting top (underscores)
    String top = "  ";
    for (int i = 0; i < artWidth - 4; i++) top += '_';
    System.out.println(top);

    // Frosting wavy line
    String wave = "/";
    for (int i = 0; i < artWidth - 3; i++) {
      wave += (i % 2 == 0) ? '~' : ' ';
    }
    wave += '\\';
    System.out.println(wave);

    // Layers
    for (int layer = 0; layer < layers; layer++) {
      String line = "|";
      for (int i = 0; i < artWidth - 2; i++) {
        line += (i % 3 == 0) ? '=' : '-';
      }
      line += "|";
      System.out.println(line);
    }

    // Cake body (height)
    for (int h = 0; h < height; h++) {
      String body = "|";
      for (int i = 0; i < artWidth - 2; i++) body += ' ';
      body += "|";
      System.out.println(body);
    }

    // Base
    String base = "|";
    for (int i = 0; i < artWidth - 2; i++) base += '_';
    base += "|";
    System.out.println(base);
  }

  public void draw(Table table) {
    String title = "Cake on a " + table.toString();
    int artWidth = Math.max(width + 6, title.length());

    // Print title
    System.out.println(title);
    System.out.println("This is a " + flavor + " cake with " + frosting + " frosting.");

    // Candles and flames across the cake top
    String candlesLine = "";
    String flamesLine = "";
    for (int i = 0; i < artWidth - 4; i++) {
      candlesLine += 'i';
      flamesLine += '^';
    }
    System.out.println(candlesLine);
    System.out.println(flamesLine);

    // Frosting top (underscores)
    String top = "  ";
    for (int i = 0; i < artWidth - 4; i++) top += '_';
    System.out.println(top);

    // Frosting wavy line
    String wave = "/";
    for (int i = 0; i < artWidth - 3; i++) {
      wave += (i % 2 == 0) ? '~' : ' ';
    }
    wave += '\\';
    System.out.println(wave);

    // Layers
    for (int layer = 0; layer < layers; layer++) {
      String line = "|";
      for (int i = 0; i < artWidth - 2; i++) {
        line += (i % 3 == 0) ? '=' : '-';
      }
      line += "|";
      System.out.println(line);
    }

    // Cake body (height)
    for (int h = 0; h < height; h++) {
      String body = "|";
      for (int i = 0; i < artWidth - 2; i++) body += ' ';
      body += "|";
      System.out.println(body);
    }

    // Base
    String base = "|";
    for (int i = 0; i < artWidth - 2; i++) base += '_';
    base += "|";
    System.out.println(base);
    // Draw the table beneath the cake
    System.out.println(); // Just here for testing...
    table.draw();
  }
}
