package competition;
import competition.methode.*;
import java.util.*;
import util.*;

public class Master extends Competition {

  private Methode methode;
  private int nbpoule;
  private List<League> league;

  /**
   * Create a Master with the list of competitors and a selection method passed as a parameter
   * @param competitors the list of competitors
   * @param methode the method of selecting the competitors
   */
  public Master(List<Competitor> competitors, int nbpoule, Methode methode){
    super(competitors);
    this.methode = methode;
    this.nbpoule = nbpoule;
    this.league = new ArrayList<League>();
  }


  /**
   * Play the group stage with the list of competitors in parameter
   * @param competitors the list of competitors
   */
   public void playLeague(List<Competitor> competitors) throws NumberNotPowerOf2Exception{
     List<Competitor> competitors2 = new ArrayList<Competitor>(competitors);
     int u = competitors2.size();
     int i = this.nbpoule;
     int j = 0;
     int v = 1;
     while (i!=0){
       league.add(new League(new ArrayList<Competitor>()));
       i = i-1;
     }
     while (u!=0){
       while (j<=this.nbpoule-1){
         int n1 = (int)(Math.random() * u);
         this.league.get(j).addCompetitors(competitors2.get(n1));
         competitors2.remove(competitors2.get(n1));
         u -= 1;
         j += 1;
       }
       j = 0;
     }
     for (League l : this.league){
       System.out.println("Group "+v+" :");
       l.play();
       l.ranking();
       System.out.println("-------------------------------------------------------------");
       v +=1;
     }
   }

   /**
    * Start the final phase
    */
  public void playTournament() throws NumberNotPowerOf2Exception{
    Competition tournament = new Tournament(this.methode.selection(this.league));
    System.out.println("");
    System.out.println("Final Phase :");
    tournament.play();
    tournament.ranking();
  }

  /**
   * Plays the matches organized between the competitors whose list is in parameter
   * @param competitors the list of competitors
   */
  protected void play(List<Competitor> competitors) throws NumberNotPowerOf2Exception{
    this.playLeague(competitors);
    this.playTournament();
  }
}
