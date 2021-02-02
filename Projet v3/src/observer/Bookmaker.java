package observer;
import competition.*;
import observer.*;
import java.util.*;

public class Bookmaker implements MatchListener {
	private Competitor c1;
	private Competitor c2;
	private Map<Competitor, Integer> cotes;

	/**
   	 * Creates a new Bookmaker
   	 */
	public Bookmaker(){
		this.cotes = new HashMap<Competitor, Integer>();
		this.c1 = null;
		this.c2 = null;
	}

	/**
   	 * Increases the competitor's rating as a parameter
   	 * @param c the competitor whose rating we want to increase
   	 */
	public void addCote(Competitor c){
		Integer newCote = (Integer) this.cotes.get(c).intValue()+1;
		this.cotes.replace(c,this.cotes.get(c),newCote);
	}

	/**
   	 * Reduces the competitor's rating as a parameter
   	 * @param c the competitor whose rating we want to reduce
   	 */
	public void subCote(Competitor c){
		Integer newCote = (Integer) this.cotes.get(c).intValue()-1;
		if (this.cotes.get(c).intValue()==1){
			;
		}
		else{
			this.cotes.replace(c,this.cotes.get(c),newCote);
		}
	}

	/**
   	 * Announces information relating to the ratings of the competitors
   	 */
	public void annonce(MatchEvent event) {
		Match match = (Match) event.getSource();
		c1 = match.getCompetitor1();
		c2 = match.getCompetitor2();
		if (!(this.cotes.containsKey(c1))){
			this.cotes.put(c1,5);
		}
		if (!(this.cotes.containsKey(c2))){
			this.cotes.put(c2,5);
		}
		System.out.println("");
		System.out.println("Voici les cotes des deux competiteurs :");
		System.out.println(c1.getName()+" : " +this.cotes.get(c1));
		System.out.println(c2.getName()+" : " +this.cotes.get(c2));
	}

	/**
   	 * Reacts and updates the ratings of the competitors in relation to the results of the matches
   	 */
	public void reactToResult(MatchEvent event) {
		Match match = (Match) event.getSource();
		this.subCote(match.winner());
		this.addCote(match.loser());
		System.out.println("");
		System.out.println("Mise à jour des cotes : ");
		System.out.println(c1.getName()+" : " +this.cotes.get(c1));
		System.out.println(c2.getName()+" : " +this.cotes.get(c2));
	}

}
