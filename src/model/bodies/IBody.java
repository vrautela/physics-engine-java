package model.bodies;

import model.util.IVector;

/**
 * An interface representing a generalized body.
 */
public interface IBody {

  /**
   * Calculates the net force vector on this body as a result of its interactions with {@code
   * otherBody}.
   *
   * @param otherBody the body interacting with this one
   * @return the net force vector on this body
   */
  // TODO: Should I have an IllegalArgumentException in the signature
  //  (in case the other IBody is not of the same dimensions as this one)?
  IVector netForceFrom(IBody otherBody);

  /**
   * Does this body overlap with the given {@code otherBody}?
   * @param otherBody the body that could be overlapping with this one
   * @return whether this body overlaps with the given one
   */
  // TODO: Should I have an IllegalArgumentException in the signature
  //  (in case the other IBody is not of the same dimensions as this one)?
  boolean overlaps(IBody otherBody);

  /**
   * Moves this body by its current velocity.
   */
  // TODO: How should I specify for how long this body should move on one tick?
  void move();

  /**
   * Accelerates this body by the given vector, {@code da}.
   *
   * @param da this body's current acceleration
   */
  // TODO: How should I specify for how long this body should accelerate on one tick?
  // TODO: Should I have an IllegalArgumentException in the signature
  //  (in case the IVector has incorrect dimensions)?
  void accelerate(IVector da);
}
