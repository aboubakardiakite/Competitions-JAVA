package competition;
import competition.*;
import util.*;
import java.util.*;

public abstract class Competition {

  private final List<Competitor> competitors;

  /**
   * Creates a competition with the list of competitors passed in parameter
   * @param competitors the list of competitors
   */
  public Competition(List<Competitor> competitors){
    this.competitors = competitors;
  }

  /**
   * Returns the list of competitors
   * @return the list of competitors
   */
  public List<Competitor> getCompetitors(){
    return this.competitors;
  }

  /**
   * Adds the competitor passed as a parameter in the list of competitors
   * @param competitor the competitor we want to add
   */
  public void addCompetitors(Competitor competitor){
    this.competitors.add(competitor);
  }

  /**
   * Organize the matches between the competitors
   * @param competitor1 the first competitor
   * @param competitor2 the second competitor
   */
  protected void playMatch(Competitor competitor1, Competitor competitor2){
    Match match1 = new Match(competitor1,competitor2);
    match1.play();
    System.out.println(match1.toString());
  }

  /**
   * Plays the matches organized between the competitors whose list is in parameter
   * @param competitors the list of competitors
   */
  protected abstract void play(List<Competitor> competitors) throws NumberNotPowerOf2Exception;

  /**
   * Start the competition
   */
  public void play() throws NumberNotPowerOf2Exception{
    this.play(this.competitors);
  }

  /**
   * Returns the ranking of the competitors in descending order of points
   * @return the ranking of the competitors in descending order of points
   */
  public Map<Competitor, Integer> ranking(){
    Map<Competitor, Integer> rank = new HashMap<Competitor, Integer>();
    for (Competitor c : this.competitors){
      rank.put(c,c.getPoints());
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
