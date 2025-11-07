// Risith Kankanamge
// P2
// Zero-Hero
// 11/07/2025

/*
 * DESCRIPTION: Cup that dynamically adjusts and centers itself on a table.
 * INPUT: Label (optional, width is dynamic).
 * OUTPUT: ASCII art of a cup centered on a table.
 * EDGE CASE: Cup with invalid width.
 */

package edu.bhscs;

public class Cup implements Offsetable {
  // Fields / Properties
  private int width;
  private String label;

  // Constructor
  public Cup(String label) {
    this.label = label;
  }

  // Methods
  public int getWidth() {
    return width;
  }

  public void adjustToTable(Table table) {
    int tableWidth = table.getWidth();
    this.width = Math.max(8, tableWidth - 2);
  }

  public void draw(Table table) {
    int[] offsets = calculateOffsets(table);
    int cupOffset = offsets[0];
    int tableOffset = offsets[1];
    drawCup(cupOffset);
    drawTable(table, tableOffset);
  }

  private int[] calculateOffsets(Table myTable) {
    adjustToTable(myTable);
    int cupWidth = this.getWidth();
    int tableWidth = myTable.getWidth();
    int offset = (cupWidth - tableWidth) / 2;
    int cupOffset = 0;
    int tableOffset = 0;
    if (offset < 0) {
      cupOffset = Math.abs(offset);
      tableOffset = 0;
    } else {
      cupOffset = 0;
      tableOffset = Math.abs(offset);
    }
    return new int[] {cupOffset, tableOffset};
  }

  private void drawCup(int offset) {
    drawWithOffset(offset);
  }

  private void drawTable(Table table, int offset) {
    table.draw(offset);
  }

  private void drawWithOffset(int offset) {
    // Top rim
    for (int i = 0; i < offset; i++) {
      System.out.print(" ");
    }
    System.out.print("  ");
    for (int i = 0; i < width - 4; i++) {
      System.out.print(".");
    }
    System.out.println();
    // Sides and label (label goes on middle row if it exists)
    int rows = 3;
    int labelRow = 1; // middle row
    for (int row = 0; row < rows; row++) {
      for (int i = 0; i < offset; i++) {
        System.out.print(" ");
      }
      System.out.print("  |");
      if (row == labelRow && !label.isEmpty()) {
        int pad = width - 6 - label.length();
        int left = pad / 2;
        int right = pad - left;
        for (int i = 0; i < left; i++) {
          System.out.print(" ");
        }
        System.out.print(label);
        for (int i = 0; i < right; i++) {
          System.out.print(" ");
        }
      } else {
        for (int i = 0; i < width - 6; i++) {
          System.out.print(" ");
        }
      }
      System.out.print("|]");
      System.out.println();
    }
    // Bottom rim
    for (int i = 0; i < offset; i++) {
      System.out.print(" ");
    }
    System.out.print("  ");
    for (int i = 0; i < width - 4; i++) {
      System.out.print("-");
    }
    System.out.println();
  }

  @Override
  public void draw(Offsetable below) {
    int offset = getOffset(below);
    drawWithOffset(offset);
  }
}
