package model.bodies;

import java.awt.Color;
import model.util.Vector3D;

/**
 * An abstract representation of a body in a three-dimensional world.
 */
abstract class Abstract3DBody extends AbstractBody {
  protected final Vector3D spin;

  /**
   *
   * @param mass
   * @param charge
   * @param position
   * @param velocity
   * @param color
   * @param spin
   */
  public Abstract3DBody(double mass, double charge, Vector3D position,
      Vector3D velocity, Color color, Vector3D spin) {
    super(mass, charge, position, velocity, color);
    this.spin = spin;
  }
}