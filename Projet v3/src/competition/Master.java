package competition;
import competition.methode.*;
import java.util.*;
import util.*;
import observer.*;

public class Master extends Competition {

  private Methode methode;
  private int nbpoule;
  private List<League> league;
  private List<League> league1;
  private Tournament tournament;

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
    this.league1 = new ArrayList<League>();
    this.tournament = null;
  }

  /**
   * Returns the list of leagues of this master
   * @return the list of leagues of this master
   */
  public List<League> getLeague(){
    return this.league;
  }

  /**
   * Returns the tournament of this master
   * @return the tournament of this master
   */
  public Tournament getTournament(){
    return this.tournament;
  }

  /**
   * Returns the winner of this master
   * @return the winner of this master
   */
  public Competitor winner(){
    return this.getTournament().winner();
  }

  /**
   * Organize the group stage with the list of competitors in parameter
   * @param competitors the list of competitors
   */
   public List<League> createPoules(List<Competitor> competitors) throws NumberNotPowerOf2Exception{
     if (competitors.size()%this.nbpoule==0){
       List<Competitor> competitors2 = new ArrayList<Competitor>(competitors);
       int u = competitors2.size();
       int i = this.nbpoule;
       int j = 0;
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
     }
     return this.league;
   }

   /**
    * Play the group stage with the list of competitors in parameter
    * @param competitors the list of competitors
    */
   public void playLeague(List<Competitor> competitors) throws NumberNotPowerOf2Exception{
     List<League> ligue = createPoules(competitors);
     int i = this.methode.selection(ligue).size();
     int v = 1;
     if ((i != 0) && ((i & (i - 1)) == 0)){
       for (League l : ligue){
         System.out.println("");
         System.out.println("Group "+v+" :");
         for (MatchListener m : this.getMatchListener()){
           l.addMatchListener(m);
         }
         l.play();
         v +=1;
       }
     }
     else{
       throw new NumberNotPowerOf2Exception();
     }
   }

  /**
   * Start the final phase of this master
   */
  public void playTournament() throws NumberNotPowerOf2Exception{
    tournament = new Tournament(this.methode.selection(this.league));
    System.out.println("");
    System.out.println("Final Phase :");
    for (MatchListener m : this.getMatchListener()){
      tournament.addMatchListener(m);
    }
    tournament.play();
  }

  /**
   * Plays the matches organized between the competitors whose list is in parameter
   * @param competitors the list of competitors
   */
  protected void play(List<Competitor> competitors) throws NumberNotPowerOf2Exception{
    this.playLeague(competitors);
    this.playTournament();
  }

  /**
   * Returns the ranking of the competitors in descending order of points
   * @return the ranking of the competitors in descending order of points
   */
  public Map<Competitor, Integer> ranking(){
    Map<Competitor, Integer> rank = new HashMap<Competitor, Integer>();
    int n = 1;
    System.out.println("");
    System.out.println("*** Ranking Master ***");
    for (League l : this.league){
      System.out.println("");
      System.out.println("Groupe "+n+" :");
      l.ranking();
      n+=1;
    }
    System.out.println("");
    System.out.println("Final Phase :");
    this.tournament.ranking();
    return rank;
  }
}
