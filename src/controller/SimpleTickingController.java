package controller;

import model.IModel;
import view.IView;

/**
 * An implementation of the controller, that uses Euler's method to
 */
public class SimpleTickingController implements IController {
  private final IModel m;
  private final IView v;
  private final int numTicksPerSecond;
  private final boolean finiteTicks;
  private final int numTicksTotal;

  /**
   * @param m
   * @param v
   */
  SimpleTickingController(IModel m, IView v, int numTicksPerSecond, boolean finiteTicks,
      int numTicksTotal) {
    this.m = m;
    this.v = v;
    this.numTicksPerSecond = numTicksPerSecond;
    this.finiteTicks = finiteTicks;
    this.numTicksTotal = numTicksTotal;
  }


  @Override
  public void run() {
    // note the start time
    // call the model to tick
    // get the results from the model and pass it on to the view to display
    // note the end time
    // have the function wait for the appropriate amount of time ( (1000.0 / numTicks) - (endTime - startTime) )
    // call run again
  }
}
