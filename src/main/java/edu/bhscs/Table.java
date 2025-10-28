// Risith Kankanamge
// P2
// Zero-Hero
// 10/27/2025

/*
 * DESCRIPTION: Table with adjustable legs and width that can display beneath cakes
 * INPUT: Number of legs and table width
 * OUTPUT: ASCII art table with evenly spaced legs
 * EDGE CASE: Single leg table (can't use fencepost formula), legs wider than table width
 */

package edu.bhscs;

public class Table {
    private int legs;
    private int width;
    private String legString;
    private String topString;

    public Table(int legs, int width) {
        this.legs = legs;
        this.width = width;
        this.legString = "|";
        this.topString = "_";
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }    public void setLegs(String leg) {
        this.legString = leg;
    }

    public void setTop(String top) {
        this.topString = top;
    }

    /**
     * Draws the table with evenly spaced legs.
     * A solution to the Fencepost Problem! :)
     * - We need legs at both ends of the table. Spaces go between legs
     */
    public void draw() {
        // Draw the table top using loops
        for (int i = 0; i < width; i++) {
            // Use modulo to cycle through the topString characters repeatedly
            int charIndex = i % topString.length();
            System.out.print(topString.substring(charIndex, charIndex + 1));
        }
        System.out.println();

        // Draw the legs with even spacing
        // the Fencepost Problem solution was to calculate space between legs (total width minus space taken by legs), divided by the number of GAPS (which is legs - 1)
        if (legs == 1) {
            // This is for the case if there is a single leg in the middle
            // Can't use Fencepost formula because (legs - 1) = 0, which is division by zero.
            int legPosition = width / 2;  // Division to find center position
            for (int i = 0; i < width; i++) {
                if (i == legPosition) {
                    System.out.print(legString);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        } else if (legs > 1) {
            // Calculate spaces between legs
            int totalLegSpace = legs * legString.length();  // Total chars taken up by all legs
            int remainingSpace = width - totalLegSpace;     // Chars left over for spaces between legs
            int gaps = legs - 1;  // Fencepost Problem! Number of gaps is one less than posts
            int spaceBetweenLegs = remainingSpace / gaps;   // Base number of spaces per gap
            int extraSpace = remainingSpace % gaps;         // Leftover spaces from division (the remainder)              // Draw the legs with calculated spacing
            for (int legNum = 0; legNum < legs; legNum++) {
                // Draw the leg
                System.out.print(legString);

                // Draw spaces after the leg (but not after the last leg)
                if (legNum < legs - 1) {  // Fencepost Problem! Don't add space after last leg
                    int spacesToAdd = spaceBetweenLegs;  // Start with base number of spaces
                    if (legNum < extraSpace) {
                        spacesToAdd++;  // Distribute extra space evenly to first few gaps
                    }
                    // Print the spaces between this leg and the next
                    for (int s = 0; s < spacesToAdd; s++) {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Table with " + legs + " legs and width " + width;
    }
}