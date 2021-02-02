package observer;
import competition.*;
import java.util.*;

public interface CompetitionListener extends java.util.EventListener{

	/**
   	 * Announces the start of a competition
   	 */
	public void annonceCompetition(CompetitionEvent event);

	/**
   	 * Announces the end of a competition
   	 */
	public void reactEnd(CompetitionEvent compet);
}
