package observer;
import competition.*;
import java.util.*;

public class MatchEvent extends java.util.EventObject {

  /**
   * Creates the Match event class
   */
  public MatchEvent(Match source) {
    super(source);
  }
}
