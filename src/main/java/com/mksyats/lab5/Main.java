package com.mksyats.lab5;

import com.mksyats.lab5.sweets.*;
import com.mksyats.lab5.gift.Gift;

/**
 * Entry point of the application that demonstrates the functionality of the {@link Gift} and
 * {@link Sweet} classes, along with their specific implementations like {@link Candy},
 * {@link Cookie}, and {@link Cake}.
 */
public class Main {

  /**
   * Main method that serves as the entry point of the application.
   *
   * <p>The method performs the following operations:
   * <ol>
   *   <li>Creates an array of {@link Sweet} objects, including {@link Candy}, {@link Cookie},
   *   and {@link Cake} instances</li>
   *   <li>Constructs a {@link Gift} object using the array of sweets.</li>
   *   <li>Sorts the sweets in the gift using the {@link Gift#sortSweets()} method and
   *   prints the sorted list.</li>
   *   <li>Searches for a sweet within a specific cocoa amount range using the
   *   {@link Gift#findSweetByCocoaAmount(double, double)} method and displays the result.</li>
   *   <li>Catches and handles exceptions that might occur, such as invalid inputs, ensuring
   *   graceful program termination with an appropriate error message.</li>
   * </ol>
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    try {
      Sweet[] sweets = {new Candy("Mint Bliss", 10.5f, 0.267, "Mint"),
          new Cookie("Creamy Surprise", 30f, 0.35, true),
          new Cookie("Oat Crunch", 20.4f, 0.155, false),
          new Candy("Choco Delight", 20.3f, 0.5, "Chocolate"),
          new Cake("Forest Fantasy", 500.35f, 0.6), new Cake("Vanilla Dream", 260f, 0.2),
          new Cookie("Choco Chip Treat", 25.8f, 0.4, false),
          new Candy("Golden Caramel", 12.25f, 0.125, "Caramel"),
          new Cake("Molten Magic", 350.25f, 0.7),
          new Candy("Berry Burst", 18f, 0.3, "Strawberry"),
      };

      Gift gift = new Gift(10f, sweets);

      gift.sortSweets();
      System.out.println("Gift with sorted sweets:\n" + gift);

      Sweet sweet = gift.findSweetByCocoaAmount(0.3, 0.4);
      if (sweet != null) {
        System.out.println("Founded sweet: " + sweet);
      } else {
        System.out.println("Gift does not contain sweet with such cocoa amount.");
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage() + ".");
      System.exit(1);
    }
  }
}
