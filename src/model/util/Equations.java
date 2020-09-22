package model.util;

/**
 * Physical equations used throughout the physics engine.
 */
public class Equations {
  public static IVector newtonsGravity(double m1, double m2, IVector r) {
    return r.scalarProduct(-Constants.G * m1 * m2);
  }

  public static IVector coulombsLaw(double q1, double q2, IVector r) {
    return r.scalarProduct(Constants.k * q1 * q2);
  }
}
