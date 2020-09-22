package model.bodies;

import java.awt.Color;
import model.util.Vector2D;

/**
 * An abstract representation of a body in a two-dimensional world.
 */
abstract class Abstract2DBody extends AbstractBody {
  protected final double spin;

  /**
   * Creates a new Abstract2DBody with the given characteristics.
   * @param mass
   * @param charge
   * @param spin
   * @param position
   * @param velocity
   * @param color
   */
  Abstract2DBody(double mass, double charge, double spin, Vector2D position, Vector2D velocity, Color color) {
    super(mass, charge, position, velocity, color);
    this.spin = spin;
  }
}
