package model;

import model.bodies.IBody;

/**
 * The interface for a model of this physics engine. Add more conrete functionality here.
 */
public interface IModel {

  /**
   * Adds the given body to this model.
   * @param body the body to be added
   */
  void addBody(IBody body);

  /**
   * Removes the given body from this model.
   * @param body the body to be removed
   * @throws IllegalArgumentException if the given body is not present in this model
   */
  void removeBody(IBody body) throws IllegalArgumentException;

  /**
   * Adjust the model so that one second in the real world corresponds to {@code SimTimeToRealTime}
   * seconds in the simulation.
   *
   * @param SimTimeToRealTime - the ratio of simulation time (in seconds) to the real world time (in
   *                          seconds)
   * @throws IllegalArgumentException if the ratio is negative
   */
  void setSimulationTimeRatio(int SimTimeToRealTime) throws IllegalArgumentException;

  /**
   * Move each body to its new location depending on the forces acting on it.
   */
  void tick(int numTicksPerSecond);

  //void editBody()
}
