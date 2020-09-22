package view;

import java.util.List;
import model.bodies.IBody;

/**
 * An interface for a view of this physics engine. Displays all of the bodies in the simulation.
 */
public interface IView {

  /**
   * Displays each of the bodies in the given list.
   * @param bodies the given list of bodies
   */
  void displayBodies(List<IBody> bodies);
}
