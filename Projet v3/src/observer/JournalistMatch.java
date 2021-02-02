package observer;
import competition.*;
import observer.*;

public class JournalistMatch implements MatchListener {

	/**
   	 * Reacts to the results of the matches
   	 */
	public void reactToResult(MatchEvent event) {
		Match match = (Match) event.getSource();
		System.out.println("");
		System.out.println("Victoire de "+match.winner().getName());
	}

	/**
   	 * Announces matches
   	 */
	public void annonce(MatchEvent event) {
		Match match = (Match) event.getSource();
		Competitor c1 = match.getCompetitor1();
		Competitor c2 = match.getCompetitor2();
		System.out.println("");
		System.out.println("Affiche du jour : "+c1.getName()+" VS "+c2.getName());
	}
}
