// Risith Kankanamge
// P2
// Zero-Hero
// 11/07/2025

/*
 * DESCRIPTION: Interface for objects that can be centered and drawn relative to another.
 * INPUT: None directly; implemented by Cake, Cup, Table.
 * OUTPUT: Provides centering and drawing contract.
 * EDGE CASE: None.
 */

package edu.bhscs;

public interface Offsetable {
  int getWidth();

  // Default centering logic — always clamps to 0 so alignment never goes negative.
  default int getOffset(Offsetable below) {
    if (below == null) return 0;
    return Math.max(0, (below.getWidth() - this.getWidth()) / 2);
  }

  // Each Offsetable thing knows how to draw itself
  // relative to whatever is beneath it.
  void draw(Offsetable below);
}