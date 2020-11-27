package competition;
import java.util.*;

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
    for (Competitor c1 : competitors){
        for (Competitor c2 : competitors){
          if (c1.getName() != c2.getName()){
            this.playMatch(c1,c2);
          }
        }
      }
  }
}
