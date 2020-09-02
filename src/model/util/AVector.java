package model.util;

import java.util.Arrays;

/**
 * An abstract representation of a vector.
 */
abstract class AVector implements IVector {

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
  public IVector add(IVector other) throws IllegalArgumentException {
    return other.add(this.components);
  }

  @Override
  public IVector add(double[] otherComponents) throws IllegalArgumentException {
    // TODO: perhaps abstract out this dimension error-checking behavior to its own method?
    double otherDim = this.components.length;
    if (this.dimension != otherDim) {
      // TODO: print out the vectors being added?
      throw new IllegalArgumentException("Cannot add two vectors of different dimensions");
    } else {
      double[] addedComponents = new double[this.dimension];
      for (int index = 0; index < this.dimension; index += 1) {
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
  public IVector unitVector() {
    return this.scalarProduct(1.0 / this.magnitude());
  }

  @Override
  public double dot(IVector other) throws IllegalArgumentException {
    return other.dot(this.components);
  }

  @Override
  public double dot(double[] otherComponents) throws IllegalArgumentException {
    double otherDim = otherComponents.length;

    if (this.dimension != otherDim) {
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
}
