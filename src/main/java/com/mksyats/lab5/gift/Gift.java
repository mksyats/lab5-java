package com.mksyats.lab5.gift;

import java.util.Arrays;

import com.mksyats.lab5.sweets.Sweet;

/**
 * Represents a gift that contains a collection of sweets.
 */
public class Gift {

  private final float weight;
  private final Sweet[] sweets;

  /**
   * Constructs a new {@code Gift} instance with the specified weight and array of sweets.
   *
   * @param weight the base weight of the gift without the sweets, in grams; must be non-negative
   * @param sweets the array of sweets contained in the gift; cannot be null
   * @throws IllegalArgumentException if the weight is negative or the sweets array is null
   */
  public Gift(float weight, Sweet[] sweets) {
    if (weight < 0) {
      throw new IllegalArgumentException("weight value cannot be negative");
    }
    this.weight = weight;

    if (sweets == null) {
      throw new IllegalArgumentException("sweets array cannot be null");
    }
    this.sweets = sweets;
  }

  /**
   * Calculates the total weight of this gift, including its own weight and the combined weight of
   * all sweets.
   *
   * @return the total weight of the gift in grams
   */
  public float getWeight() {
    float weight = this.weight;
    for (Sweet sweet : sweets) {
      weight += sweet.getWeight();
    }
    return weight;
  }

  /**
   * Sorts the array of sweets in ascending order based on their weight. The sorting uses the
   * natural order defined by the {@link Sweet#compareTo(Sweet)} method.
   */
  public void sortSweets() {
    Arrays.sort(sweets);
  }

  /**
   * Finds and returns the first sweet in the array with a cocoa content within the specified
   * range.
   *
   * @param min the minimum cocoa content (inclusive), as a fraction between 0 and 1
   * @param max the maximum cocoa content (inclusive), as a fraction between 0 and 1
   * @return the first sweet matching the specified cocoa content range, or {@code null} if no match
   * is found
   * @throws IllegalArgumentException if the range is invalid
   */
  public Sweet findSweetByCocoaAmount(double min, double max) {
    if (min < 0 || max > 1 || min > max) {
      throw new IllegalArgumentException("invalid cocoa amount boundaries");
    }

    for (Sweet sweet : sweets) {
      if (sweet.getCocoaAmount() >= min && sweet.getCocoaAmount() <= max) {
        return sweet;
      }
    }
    return null;
  }

  /**
   * Returns a string representation of this gift, including its total weight, base weight, and a
   * list of sweets it contains.
   *
   * @return a formatted string representation of the gift
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(
        String.format("%s\n\ttotal weight: %.2fg (own weight: %.2fg)\n\tsweets:\n",
            getClass().getSimpleName(), getWeight(), weight));
    for (Sweet sweet : sweets) {
      sb.append("\t\t").append(sweet).append("\n");
    }
    return sb.toString();
  }
}
