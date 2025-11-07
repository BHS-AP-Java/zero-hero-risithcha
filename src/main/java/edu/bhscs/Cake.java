// Risith Kankanamge
// P2
// Zero-Hero
// 11/07/2025

/*
 * DESCRIPTION: Cake that dynamically adjusts to table size.
 * INPUT: Flavor, frosting, height, width, count, and recipient name.
 * OUTPUT: ASCII art of cakes centered on a table.
 * EDGE CASE: Cake with invalid dimensions.
 */

package edu.bhscs;

public class Cake {
  String flavor;
  String frosting;
  int height;
  int width;
  int count;
  String recipientName;

  public Cake(
      String flavor, String frosting, int height, int width, int count, String recipientName) {
    this.flavor = flavor;
    this.frosting = frosting;
    this.height = height;
    this.width = width;
    this.count = count;
    this.recipientName = recipientName;
  }

  public Cake(String flavor, String frosting, int height, int width) {
    this(flavor, frosting, height, width, 1, "");
  }

  public Cake() {
    this("Vanilla", "Chocolate", 3, 10, 1, "");
  }

  public int getWidth() {
    String message = "HAPPY BDAY";
    int minCakeWidth = message.length() + 2;
    // Use a dynamic width that can adjust to table size
    int cakeInnerWidth = Math.max(width, minCakeWidth);
    // Actual printed width is inner width + 4 (2 for padding + 2 for borders)
    return cakeInnerWidth + 4;
  }

  public void adjustToTable(Table table) {
    // Dynamically adjust cake width to fit table nicely
    int tableWidth = table.getWidth();
    // Make cake slightly smaller than table for aesthetics
    this.width = Math.max(10, tableWidth - 4);
  }

  public void draw(int offset) {
    // Draw logic refactored!
    drawWithOffset(offset);
  }

  public void drawWithOffset(int offset) {
    // Use cake fields for dynamic sizing
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
    for (int i = 0; i < offset + candleLeftPadding; i++) System.out.print(" ");
    for (int i = 0; i < candleCount; i++) {
      System.out.print("'");
      if (i < candleCount - 1) for (int j = 0; j < candleSpacing; j++) System.out.print(" ");
    }
    System.out.println();

    // Line 2: Candle bodies
    for (int i = 0; i < offset + candleLeftPadding; i++) System.out.print(" ");
    for (int i = 0; i < candleCount; i++) {
      System.out.print("|");
      if (i < candleCount - 1) for (int j = 0; j < candleSpacing; j++) System.out.print(" ");
    }
    System.out.println();

    // Line 3: Cake top border
    for (int i = 0; i < offset; i++) System.out.print(" ");
    System.out.print("+");
    for (int i = 0; i < cakeInnerWidth + 2; i++) System.out.print("-");
    System.out.print("+");
    System.out.println();

    // Cake body (height)
    for (int line = 0; line < height; line++) {
      for (int i = 0; i < offset; i++) System.out.print(" ");
      System.out.print("|");
      for (int i = 0; i < cakeInnerWidth + 2; i++) {
        if (line == height / 2 && i == 1) {
          int totalSpaces = cakeInnerWidth - message.length();
          int messageLeftSpaces = totalSpaces / 2;
          int messageRightSpaces = totalSpaces - messageLeftSpaces;
          for (int j = 0; j < messageLeftSpaces; j++) System.out.print(" ");
          System.out.print(message);
          for (int j = 0; j < messageRightSpaces; j++) System.out.print(" ");
          i += messageLeftSpaces + message.length() + messageRightSpaces - 1;
        } else {
          System.out.print(" ");
        }
      }
      System.out.print("|");
      System.out.println();
    }

    // Cake base
    for (int i = 0; i < offset; i++) System.out.print(" ");
    System.out.print("+");
    for (int i = 0; i < cakeInnerWidth + 2; i++) System.out.print("-");
    System.out.print("+");
    System.out.println();
  }

  public void draw(Table table) {
    // Print title if recipient name exists
    if (recipientName != null && !recipientName.isEmpty()) {
      String title = "Cakes for " + recipientName;
      System.out.println(title);
      System.out.println();
    }

    // Draw multiple cakes
    for (int i = 0; i < count; i++) {
      // MATH CHUNK
      int[] offsets = calculateOffsets(table);
      int cakeOffset = offsets[0];
      int tableOffset = offsets[1];

      // DRAW CHUNK
      drawCake(cakeOffset);
      drawTable(table, tableOffset);

      // Add spacing between cakes if not the last one
      if (i < count - 1) {
        System.out.println();
      }
    }
  }

  // Helper method MATH CHUNK
  private int[] calculateOffsets(Table myTable) {
    // Dynamically adjust cake to table before calculating
    adjustToTable(myTable);

    int cakeWidth = this.getWidth();
    int tableWidth = myTable.getWidth();
    int offset = (cakeWidth - tableWidth) / 2;
    int cakeOffset = 0;
    int tableOffset = 0;

    if (offset < 0) {
      // Table is bigger - offset the cake
      cakeOffset = Math.abs(offset);
      tableOffset = 0;
    } else {
      // Cake is bigger - offset the table
      cakeOffset = 0;
      tableOffset = Math.abs(offset);
    }

    return new int[] {cakeOffset, tableOffset};
  }

  // Helper method: Draw cake with offset
  private void drawCake(int offset) {
    drawWithOffset(offset);
  }

  // Helper method: Draw table with offset
  private void drawTable(Table table, int offset) {
    table.draw(offset);
  }
}
