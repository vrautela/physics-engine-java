package model.util;

/**
 * An interface representing a vector.
 */
// TODO: perhaps make a method that returns the components instead of having two adds and dots?
public interface IVector {

  /**
   * Returns the dimension of this vector
   * @return the dimension of this vector
   */
  int dimension();

  /**
   * Returns an array representing the components of this vector (in Cartesian coordinates).
   * @return the aforementioned array
   */
  double[] components();

  /**
   * Adds the {@code other} vector to this vector.
   *
   * @param other the vector to be added to this one
   * @return the result of adding this vector to the {@code other} vector
   * @throws IllegalArgumentException if the {@code other} vector has different dimensions from this
   *                                  vector
   */
  IVector add(IVector other) throws IllegalArgumentException;

  /**
   * Subtracts the {@code other} vector from this vector.
   *
   * @param other the vector to be subtracted this one
   * @return the result of subtracting this vector by the {@code other} vector
   * @throws IllegalArgumentException if the {@code other} vector has different dimensions from this
   *                                  vector
   */
  IVector subtract(IVector other) throws IllegalArgumentException;

  /**
   * Multiplies this vector by the scalar, {@code k}.
   *
   * @param k the scaling factor
   * @return the result of multiplying this vector by the scalar, {@code k}.
   */
  // TODO: should I be using an double or some other numerical datatype like BigInteger?
  IVector scalarProduct(double k);

  /**
   * Returns the unit vector in the same direction as this vector.
   * @return the unit vector in the same direction as this vector
   * @throws IllegalArgumentException if the given input is the zero vector
   */
  IVector unitVector() throws IllegalArgumentException;

  /**
   * Computes the dot product of this vector and the {@code other} vector.
   *
   * @param other the vector to be dotted with this vector
   * @return the dot product of this vector and the {@code other} vector
   * @throws IllegalArgumentException if the {@code other} vector has different dimensions from this
   *                                  vector
   */
  // TODO: should I be using an double or some other numerical datatype like Bigdoubleeger?
  double dot(IVector other) throws IllegalArgumentException;

  /**
   * Returns the magnitude of this vector.
   * @return the magnitude of this vector
   */
  double magnitude();
}
