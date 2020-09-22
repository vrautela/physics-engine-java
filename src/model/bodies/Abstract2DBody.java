package model.bodies;

import java.awt.Color;
import model.util.Vector2D;

/**
 * An abstract representation of a body in a two-dimensional world.
 */
abstract class Abstract2DBody implements IBody {
  /**
   * Things a 2D Body has:
   * - mass (number)
   * - charge (number)
   * - spin (number)
   * - position (2D vector)
   * - velocity (2D vector)
   * - size (also for viewing purposes)
   * - color (for viewing purposes)
   */

  final double mass;
  double charge;
  double spin;
  final Vector2D position;
  final Vector2D velocity;
  final Color color;

  /**
   *
   * @param mass
   * @param charge
   * @param spin
   * @param position
   * @param velocity
   * @param color
   */
  Abstract2DBody(double mass, double charge, double spin, Vector2D position, Vector2D velocity, Color color) {
    this.mass = mass;
    this.charge = charge;
    this.spin = spin;
    this.position = position;
    this.velocity = velocity;
    this.color = color;
  }
}
