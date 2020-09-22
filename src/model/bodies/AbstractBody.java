package model.bodies;

import java.awt.Color;
import model.util.AVector;
import model.util.Equations;
import model.util.IVector;

/**
 * An abstract representation of a body.
 */
public abstract class AbstractBody implements IBody {
  protected final double mass;
  protected double charge;
  protected final AVector position;
  protected final AVector velocity;
  protected final Color color;

  public AbstractBody(double mass, double charge, AVector position, AVector velocity,
      Color color) {
    this.mass = mass;
    this.charge = charge;
    this.position = position;
    this.velocity = velocity;
    this.color = color;
  }

  @Override
  public IVector netForceFrom(IBody otherBody) {
    // calculate the force that the other body applies on this body, and then negate it
    return otherBody.netForceOn(this.mass, this.charge, this.position).scalarProduct(-1);
  }

  @Override
  public IVector netForceOn(double otherMass, double otherCharge, IVector otherPosition) {
    if (this.position.dimension() != otherPosition.dimension()) {
      throw new IllegalArgumentException(
          "Cannot calculate forces between bodies of different dimensions.");
    }
    else {
      // calculating the displacement vector between the two bodies
      IVector r = otherPosition.subtract(this.position);

      // calculate gravitational force
      IVector gravitationalForce = Equations.newtonsGravity(this.mass, otherMass, r);
      // calculate electric force
      IVector electricForce = Equations.coulombsLaw(this.charge, otherCharge, r);

      return gravitationalForce.add(electricForce);
    }
  }

  @Override
  public boolean overlaps(IBody otherBody) {
    // TODO: complete
  }

  @Override
  public void move() {
    // TODO: complete
  }

  @Override
  public void accelerate(IVector da) {
    // TODO: complete
  }

  /**
   * Rotate this body.
   */
  protected abstract void rotate();
}
