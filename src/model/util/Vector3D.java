package model.util;

/**
 * A class representing a vector in two dimensions.
 */
public class Vector3D extends AVector {
  public Vector3D(double x, double y, double z) {
    super(x, y, z);
  }

  @Override
  IVector create(double[] components) {
    int dim = components.length;
    if (dim != 3) {
      throw new IllegalArgumentException(
          "Cannot create a 3D vector from an array of " + dim + " elements");
    }

    return new Vector3D(components[0], components[1], components[2]);
  }
}