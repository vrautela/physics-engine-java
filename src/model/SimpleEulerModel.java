package model;

import java.util.List;
import model.bodies.IBody;

/**
 * An implementation of the model that approximates the motion of bodies using Euler's method.
 */
public class SimpleEulerModel implements IModel {
  // TODO: how to ensure that all the bodies have the same dimension?
  private int simulationTimeRatio;
  private List<IBody> bodies;

  /**
   *
   * @param simulationTimeRatio
   * @param bodies
   */
  public SimpleEulerModel(int simulationTimeRatio, List<IBody> bodies) {
    this.simulationTimeRatio = simulationTimeRatio;
    this.bodies = bodies;
  }

  @Override
  public void addBody(IBody body) {

  }

  @Override
  public void removeBody(IBody body) throws IllegalArgumentException {

  }

  @Override
  public void setSimulationTimeRatio(int SimTimeToRealTime) throws IllegalArgumentException {

  }

  @Override
  public void tick(int numTicksPerSecond) {
    // TODO: implement the Euler's method logic here
  }
}
