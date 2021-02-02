package observer;
import competition.*;
import java.util.*;

public interface MatchListener extends java.util.EventListener{

	/**
  	 * Reacts to the results of the matches
   	 */
	public void reactToResult(MatchEvent match);

	/**
   	 * Announces matches
   	 */
	public void annonce(MatchEvent match);
}
