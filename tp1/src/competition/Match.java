package competition;
import competition.*;

public class Match {

  private Competitor competitor1;
  private Competitor competitor2;

  /**
   * Creates a match between the two competitors in parameter
   * @param competitor1 the first competitor
   * @param competitor2 the second competitor
   */
  public Match(Competitor competitor1, Competitor competitor2){
    this.competitor1 = competitor1;
    this.competitor2 = competitor2;
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
    if (this.competitor1.getPoints()>this.competitor2.getPoints()){
      return this.competitor1;
    }
    else{
      return this.competitor2;
    }
  }

  /**
   * Randomly chooses a competitor between two then returns him
   * @return the competitor chosen randomly
   */
  public Competitor play(){
    Competitor tab[] = {this.competitor1,this.competitor2};
    int n = (int)(Math.random() * 2);
    tab[n].addPoint();
    return tab[n];
  }

  /**
   * Returns the string representation of the match
   * @return the name of the match
   */
  public String toString(){
    return this.competitor1.getName()+" vs "+this.competitor2.getName()+" --> "+this.winner().getName()+" wins!";
  }
}
