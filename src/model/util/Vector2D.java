package model.util;

/**
 * A class representing a vector in two dimensions.
 */
public class Vector2D extends AVector {
  public Vector2D(double x, double y) {
    super(x, y);
  }

  @Override
  IVector create(double[] components) {
    int dim = components.length;
    if (dim != 2) {
      throw new IllegalArgumentException(
          "Cannot create a 2D vector from an array of " + dim + " elements");
    }

    return new Vector2D(components[0], components[1]);
  }
}
