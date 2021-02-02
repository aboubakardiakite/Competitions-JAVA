package observer;
import competition.*;
import java.util.*;

public class CompetitionEvent extends java.util.EventObject {

  /**
   * Creates the Competition event class
   */
  public CompetitionEvent(Competition source) {
    super(source);
  }
}
