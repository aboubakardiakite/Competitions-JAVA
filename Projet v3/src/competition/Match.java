package competition;
import competition.*;
import observer.*;
import java.util.*;

public class Match {

  private Competitor competitor1;
  private Competitor competitor2;
  private Competitor winner;
  private Competitor loser;
  private ArrayList<MatchListener> matchListeners = new ArrayList<MatchListener>();
  /**
   * Creates a match between the two competitors in parameter
   * @param competitor1 the first competitor
   * @param competitor2 the second competitor
   */
  public Match(Competitor competitor1, Competitor competitor2){
    this.competitor1 = competitor1;
    this.competitor2 = competitor2;
    this.winner = null;
    this.loser = null;
  }

  /**
   * Returns the first competitor
   * @return the first competitor
   */
  public Competitor getCompetitor1(){
    return this.competitor1;
  }

  /**
   * Returns the second competitor
   * @return the second competitor
   */
  public Competitor getCompetitor2(){
    return this.competitor2;
  }

  /**
   * Returns the winner of the match between two competitors
   * @return the winner of the match between two competitors
   */
  public Competitor winner(){
    return this.winner;
  }

  /**
   * Returns the loser of the match between two competitors
   * @return the loser of the match between two competitors
   */
  public Competitor loser(){
    return this.loser;
  }

  /**
   * Randomly chooses a competitor between two then returns him
   * @return the competitor chosen randomly
   */
  public Competitor play(){
    Competitor tab[] = {this.competitor1,this.competitor2};
    int n = (int)(Math.random() * 2);
    tab[n].addPoint();
    this.loser = tab[(n+1)%2];
    this.winner = tab[n];
    return tab[n];
  }

  /**
   * Returns the string representation of the match
   * @return the name of the match
   */
  public String toString(){
    return this.competitor1.getName()+" vs "+this.competitor2.getName()+" --> "+this.winner.getName()+" wins!";
  }
}
