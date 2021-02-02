package competition;
import competition.*;
import util.*;
import java.util.*;
import observer.*;

public abstract class Competition {

  private final List<Competitor> competitors;
  private final ArrayList<MatchListener> matchListeners = new ArrayList<MatchListener>();
  private final ArrayList<CompetitionListener> competitonListeners = new ArrayList<CompetitionListener>();

  /**
   * Creates a competition with the list of competitors passed in parameter
   * @param competitors the list of competitors
   */
  public Competition(List<Competitor> competitors){
    this.competitors = competitors;
  }

  /**
   * Adds the listener in parameter in the list of listeners for competition matches
   * @param l the listener we want to add
   */
  public synchronized void addMatchListener(MatchListener l) {
    if (matchListeners.contains(l)){
      return ;
    }
    matchListeners.add(l);
  }

  /**
   * remove the listener in parameter from the list of listeners for competition matches
   * @param l the listener we want to remove
   */
  public synchronized void removeMatchListener(MatchListener l){
    matchListeners.remove(l);
  }

  /**
   * Manages the announcements of the listeners for the match in parameters
   * @param the match for which we manage the announcements
   */
  private void annonceMatchListener(Match match) {
    ArrayList<MatchListener> tl = new ArrayList<MatchListener>(matchListeners);
    if (tl.size() == 0) {
      return;
    }
    MatchEvent event = new MatchEvent(match);
    for (MatchListener listener : tl) {
      listener.annonce(event);
    }
  }

  /**
   * Manages the reactions of the listeners for the match in parameters
   * @param the match for which we manage the reactions
   */
  private void reactMatchListener(Match match) {
    ArrayList<MatchListener> tl = new ArrayList<MatchListener>(matchListeners);
    if (tl.size() == 0) {
      return;
    }
    MatchEvent event = new MatchEvent(match);
    for (MatchListener listener : tl) {
      listener.reactToResult(event);
    }
  }

  /**
   * Adds the listener in parameter in the list of competition listeners
   * @param l the listener we want to add
   */
  public synchronized void addCompetitionListener(CompetitionListener l) {
    if (competitonListeners.contains(l)){
      return ;
    }
    competitonListeners.add(l);
  }

  /**
   * remove the listener in parameter from the list of competition listeners
   * @param l the listener we want to remove
   */
  public synchronized void removeCompetitionListener(CompetitionListener l){
    competitonListeners.remove(l);
  }

  /**
   * Manages the reactions of the competition listeners
   */
  private void reactCompetitionListener() {
    ArrayList<CompetitionListener> tl = new ArrayList<CompetitionListener>(competitonListeners);
    if (tl.size() == 0) {
      return;
    }
    CompetitionEvent event = new CompetitionEvent(this);
    for (CompetitionListener listener : tl) {
      listener.reactEnd(event);
    }
  }

  /**
   * Manages the announcements of the competition listeners
   */
  private void annonceCompetitionListener() {
    ArrayList<CompetitionListener> tl = new ArrayList<CompetitionListener>(competitonListeners);
    if (tl.size() == 0) {
      return;
    }
    CompetitionEvent event = new CompetitionEvent(this);
    for (CompetitionListener listener : tl) {
      listener.annonceCompetition(event);
    }
  }

  /**
   * Returns the list of competitors
   * @return the list of competitors
   */
  public List<Competitor> getCompetitors(){
    return this.competitors;
  }

  /**
   * Returns the winner of the competition
   * @return the winner of the competition
   */
  public Competitor winner(){
    Map<Competitor, Integer> rank = new HashMap<Competitor, Integer>();
    for (Competitor c : this.competitors){
      rank.put(c,c.getPoints());
    }
    rank = MapUtil.sortByDescendingValue(rank);
    return (Competitor) rank.keySet().toArray()[0];
  }

  /**
   * Returns the list of listeners for competition matches
   * @return the list of listeners for competition matches
   */
  public List<MatchListener> getMatchListener(){
    return matchListeners;
  }

  /**
   * Returns the list of competition listeners
   * @return the list of competition listeners
   */
  public List<CompetitionListener> getCompetitionListener(){
    return competitonListeners;
  }

  /**
   * Adds the competitor passed in parameter in the list of competitors
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
    Match match = new Match(competitor1,competitor2);
    annonceMatchListener(match);
    match.play();
    reactMatchListener(match);
    System.out.println("-----------------------------------------------");
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
    this.annonceCompetitionListener();
    this.play(this.competitors);
    this.reactCompetitionListener();
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
