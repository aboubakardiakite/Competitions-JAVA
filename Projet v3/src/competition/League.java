package competition;
import java.util.*;
import util.*;

public class League extends Competition {

  /**
   * Creates a league with the list of competitors passed in parameter
   * @param competitors the list of competitors
   */
  public League(List<Competitor> competitors){
    super(competitors);
  }

  /**
   * Plays the matches organized between the competitors whose list is in parameter
   * @param competitors the list of competitors
   */
  protected void play(List<Competitor> competitors){
    for (Competitor c : competitors){
      c.initPoint();
    }
    for (Competitor c1 : competitors){
        for (Competitor c2 : competitors){
          if (c1.getName() != c2.getName()){
            this.playMatch(c1,c2);
          }
        }
    }
  }

  /**
   * Returns the ranking of the competitors in descending order of points
   * @return the ranking of the competitors in descending order of points
   */
  public Map<Competitor, Integer> ranking(){
    Map<Competitor, Integer> rank = new HashMap<Competitor, Integer>();
    for (Competitor c : this.getCompetitors()){
      if (c.getPoints()==c.getMaxPoints())
        rank.put(c,c.getPoints());
      else
        rank.put(c,(c.getMaxPoints()-c.getPoints()));
      rank = MapUtil.sortByDescendingValue(rank);
    }
    Set<Competitor> comp = rank.keySet();
    Iterator<Competitor> cle = comp.iterator();
    System.out.println("*** Ranking ***");
    while (cle.hasNext()){
      Competitor a = cle.next();
      System.out.println(a.getName()+" - "+rank.get(a));
    }
    return rank;
  }
}
