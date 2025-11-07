// Risith Kankanamge
// P2
// Zero-Hero
// 11/07/2025

/*
 * DESCRIPTION: Cake that dynamically adjusts to table size and centers itself.
 * INPUT: Flavor, frosting, height, width, count, and recipient name.
 * OUTPUT: ASCII art of cakes centered on a table.
 * EDGE CASE: Cake with invalid dimensions.
 */

package edu.bhscs;

public class Cake implements Offsetable {
  String flavor;
  String frosting;
  int height;
  int width;
  int count;
  String recipientName;

  public Cake(String flavor, String frosting, int height, int width, int count, String recipientName) {
    this.flavor = flavor;
    this.frosting = frosting;
    this.height = height;
    this.width = width;
    this.count = count;
    this.recipientName = recipientName;
  }

  public int getWidth() {
    String message = "HAPPY BDAY";
    int minCakeWidth = message.length() + 2;
    int cakeInnerWidth = Math.max(width, minCakeWidth);
    return cakeInnerWidth + 4;
  }

  public void adjustToTable(Table table) {
    int tableWidth = table.getWidth();
    this.width = Math.max(10, tableWidth - 4);
  }

  public void draw(int offset) {
    drawWithOffset(offset);
  }

  public void drawWithOffset(int offset) {
    String message = "HAPPY BDAY";
    int minCakeWidth = message.length() + 2;
    int cakeInnerWidth = Math.max(width, minCakeWidth);

    // Candle logic
    int maxCandles = Math.max(3, Math.min(cakeInnerWidth / 2, 10));
    int candleCount = maxCandles;
    int candleSpacing = Math.max(1, (cakeInnerWidth - candleCount) / (candleCount + 1));
    int candleGroupWidth = candleCount + candleSpacing * (candleCount - 1);
    int candleLeftPadding = (cakeInnerWidth + 4 - candleGroupWidth) / 2;

    // Line 1: Candle flames
    for (int i = 0; i < offset + candleLeftPadding; i++) {
      System.out.print(" ");
    }
    for (int i = 0; i < candleCount; i++) {
      System.out.print("'");
      if (i < candleCount - 1) {
        for (int j = 0; j < candleSpacing; j++) {
          System.out.print(" ");
        }
      }
    }
    System.out.println();

    // Line 2: Candle bodies
    for (int i = 0; i < offset + candleLeftPadding; i++) {
      System.out.print(" ");
    }
    for (int i = 0; i < candleCount; i++) {
      System.out.print("|");
      if (i < candleCount - 1) {
        for (int j = 0; j < candleSpacing; j++) {
          System.out.print(" ");
        }
      }
    }
    System.out.println();

    // Line 3: Cake top border
    for (int i = 0; i < offset; i++) {
      System.out.print(" ");
    }
    System.out.print("+");
    for (int i = 0; i < cakeInnerWidth + 2; i++) {
      System.out.print("-");
    }
    System.out.print("+");
    System.out.println();

    // Cake body (height)
    for (int line = 0; line < height; line++) {
      for (int i = 0; i < offset; i++) {
        System.out.print(" ");
      }
      System.out.print("|");
      for (int i = 0; i < cakeInnerWidth + 2; i++) {
        if (line == height / 2 && i == 1) {
          int totalSpaces = cakeInnerWidth - message.length();
          int messageLeftSpaces = totalSpaces / 2;
          int messageRightSpaces = totalSpaces - messageLeftSpaces;
          for (int j = 0; j < messageLeftSpaces; j++) {
            System.out.print(" ");
          }
          System.out.print(message);
          for (int j = 0; j < messageRightSpaces; j++) {
            System.out.print(" ");
          }
          i += messageLeftSpaces + message.length() + messageRightSpaces - 1;
        } else {
          System.out.print(" ");
        }
      }
      System.out.print("|");
      System.out.println();
    }

    // Cake base
    for (int i = 0; i < offset; i++) {
      System.out.print(" ");
    }
    System.out.print("+");
    for (int i = 0; i < cakeInnerWidth + 2; i++) {
      System.out.print("-");
    }
    System.out.print("+");
    System.out.println();
  }

  public void draw(Table table) {
    if (recipientName != null && !recipientName.isEmpty()) {
      String title = "Cakes for " + recipientName;
      System.out.println(title);
      System.out.println();
    }
    for (int i = 0; i < count; i++) {
      int[] offsets = calculateOffsets(table);
      int cakeOffset = offsets[0];
      int tableOffset = offsets[1];
      drawCake(cakeOffset);
      drawTable(table, tableOffset);
      if (i < count - 1) {
        System.out.println();
      }
    }
  }

  private int[] calculateOffsets(Table myTable) {
    adjustToTable(myTable);
    int cakeWidth = this.getWidth();
    int tableWidth = myTable.getWidth();
    int offset = (cakeWidth - tableWidth) / 2;
    int cakeOffset = 0;
    int tableOffset = 0;
    if (offset < 0) {
      cakeOffset = Math.abs(offset);
      tableOffset = 0;
    } else {
      cakeOffset = 0;
      tableOffset = Math.abs(offset);
    }
    return new int[] {cakeOffset, tableOffset};
  }

  private void drawCake(int offset) {
    drawWithOffset(offset);
  }

  private void drawTable(Table table, int offset) {
    table.draw(offset);
  }

  @Override
  public void draw(Offsetable below) {
    int offset = getOffset(below);
    drawWithOffset(offset);
  }
}
