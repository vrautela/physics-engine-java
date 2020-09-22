package model.util;

/**
 * An abstract representation of a vector.
 */
public abstract class AVector implements IVector {

  private final double[] components;
  private final int dimension;

  /**
   * Creates a vector with the given inputs as its components
   *
   * @param doubles an array containing the components of this vector
   */
  AVector(double... doubles) {
    this.components = doubles;
    this.dimension = this.components.length;
  }

  /**
   * Creates a new vector with the given components (using the factory method)
   *
   * @param components the components of the vector being created
   * @return a new vector with the given components
   * @throws IllegalArgumentException if the dimension of components is unequal to this vector's
   *                                  dimensions
   */
  abstract IVector create(double[] components) throws IllegalArgumentException;

  @Override
  public int dimension() {
    return this.dimension;
  }

  @Override
  public double[] components() {
    return this.components;
  }

  @Override
  public IVector add(IVector other) throws IllegalArgumentException {
    double[] otherComponents = other.components();

    int thisDim = this.dimension;
    int otherDim = otherComponents.length;

    if (thisDim != otherDim) {
      // TODO: print out the vectors being added?
      throw new IllegalArgumentException("Cannot add two vectors of different dimensions");
    } else {
      double[] addedComponents = new double[thisDim];
      for (int index = 0; index < thisDim; index += 1) {
        addedComponents[index] = this.components[index] + otherComponents[index];
      }

      return this.create(addedComponents);
    }
  }

  @Override
  public IVector subtract(IVector other) throws IllegalArgumentException {
    return this.add(other.scalarProduct(-1));
  }

  @Override
  public IVector scalarProduct(double k) {
    double[] scaledComponents = new double[this.dimension];
    for (int index = 0; index < this.dimension; index += 1) {
      scaledComponents[index] = k * this.components[index];
    }

    return this.create(scaledComponents);
  }

  @Override
  public IVector unitVector() throws IllegalArgumentException {
    if (this.magnitude() == 0) {
      throw new IllegalArgumentException("Unit vector undefined for the zero vector.");
    }
    else {
      return this.scalarProduct(1.0 / this.magnitude());
    }
  }

  @Override
  public double dot(IVector other) throws IllegalArgumentException {
    double[] otherComponents = other.components();

    int thisDim = this.dimension;
    int otherDim = otherComponents.length;

    if (thisDim != otherDim) {
      // TODO: print out the vectors being dotted?
      throw new IllegalArgumentException("Cannot dot two vectors of different dimensions");
    } else {
      double dotProduct = 0;

      for (int index = 0; index < this.dimension; index += 1) {
        dotProduct += (this.components[index] * otherComponents[index]);
      }

      return dotProduct;
    }
  }

  @Override
  public double magnitude() {
    return Math.sqrt(this.dot(this));
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    else if (!(other instanceof AVector)) {
      return false;
    }
    else {
      AVector otherVec = (AVector) other;
      if (otherVec.dimension != this.dimension) {
        return false;
      }
      else {
        double epsilon = Constants.epsilon;
        for (int index = 0; index < otherVec.dimension; index += 1) {
          if (Math.abs(this.components[index] - otherVec.components[index]) >= epsilon) {
            return false;
          }
        }

        return true;
      }
    }
  }

  // TODO: potential issue - hashCode() inconsistent with equals()
  @Override
  public int hashCode() {
    int hashCode = 0;
    for (int index = 0; index < this.dimension; index += 1) {
      hashCode += Double.hashCode(this.components[index]);
    }

    return hashCode;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("(");
    for (int index = 0; index < this.dimension; index += 1) {
      sb.append(String.format("%.3f", this.components[index])).append(", ");
    }

    String ret = sb.toString();
    return ret.substring(0, ret.length() - 2) + ")";
  }
}
