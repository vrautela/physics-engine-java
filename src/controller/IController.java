package controller;

import model.IModel;
import view.IView;

/**
 * An interface for a controller of this physic's engine. Keeps track of the ticking clock and
 * instructs all bodies to move with every tick.
 */
public interface IController {

  /**
   * Starts simulating the interaction between the bodies in the model and displaying them in the
   * view.
   */
  void run();
}
