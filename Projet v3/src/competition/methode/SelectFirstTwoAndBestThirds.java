package competition.methode;
import java.util.*;
import util.*;
import competition.*;

public class SelectFirstTwoAndBestThirds implements Methode {

  /**
   * Select the first two competitors in each league from the list passed in parameter then select the two best third
	 * @param league the list of leagues
   * @return the list of selected competitors
   */
 	public List<Competitor> selection(List<League> league){
    List<Competitor> theFinaliste = new ArrayList<Competitor>();
    List<Competitor> third = new ArrayList<Competitor>();
    for(League l : league) {
      Map<Competitor, Integer> liste = new HashMap<Competitor, Integer>();
      for (Competitor c2 : l.getCompetitors()){
        liste.put(c2,c2.getPoints());
        liste = MapUtil.sortByDescendingValue(liste);
      }
      List<Competitor> l1 = new ArrayList<Competitor>(liste.keySet());
      theFinaliste.add(l1.get(0)); //selectionne le premier de chaque poule
      theFinaliste.add(l1.get(1)); //selectionne le deuxième de chaque poule
      third.add(l1.get(2));
		}
    Map<Competitor, Integer> liste1 = new HashMap<Competitor, Integer>();
    for (Competitor c : third){
      liste1.put(c,c.getPoints());
      liste1 = MapUtil.sortByDescendingValue(liste1);
    }
    List<Competitor> l2 = new ArrayList<Competitor>(liste1.keySet());
    theFinaliste.add(l2.get(0)); //selectionne le premier meilleur troisième
    theFinaliste.add(l2.get(1)); //selectionne le second meilleur troisième
		return theFinaliste;
  }
}
