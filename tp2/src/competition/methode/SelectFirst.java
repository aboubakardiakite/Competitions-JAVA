package competition.methode;
import java.util.*;
import util.*;
import competition.*;

public class SelectFirst implements Methode {

  /**
   * Select the first competitor in each league from the list passed in parameter
	 * @param league the list of leagues
   * @return the list of selected competitors
   */
 	public List<Competitor> selection(List<League> league){
		List<Competitor> theFinaliste= new ArrayList<Competitor>();
		for(League l : league) {
      Map<Competitor, Integer> liste = new HashMap<Competitor, Integer>();
      for (Competitor c2 : l.getCompetitors()){
        liste.put(c2,c2.getPoints());
        liste = MapUtil.sortByDescendingValue(liste);
      }
      List<Competitor> l1 = new ArrayList<Competitor>(liste.keySet());
      theFinaliste.add(l1.get(0)); //selectionne le premier de chaque poule
		}
		return theFinaliste;
  }
}
