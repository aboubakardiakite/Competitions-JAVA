package competition;
import competition.*;
import util.*;
import java.util.*;

public class CompetitionMain{
  public static void main(String[] args){
    Competitor c1 = new Competitor("Joel");
    Competitor c2 = new Competitor("Bouba");
    Competitor c3 = new Competitor("Lynx");
    Competitor c4 = new Competitor("Raven");
    Competitor c5 = new Competitor("Drift");
    Competitor c6 = new Competitor("Catalyst");
    Competitor c7 = new Competitor("Midas");
    Competitor c8 = new Competitor("Blastoff");
    List<Competitor> compet1 = new ArrayList<Competitor>();
    List<Competitor> compet2 = new ArrayList<Competitor>();
    Competition league = new League(compet1);
    league.addCompetitors(c1);
    league.addCompetitors(c2);
    league.addCompetitors(c3);
    league.addCompetitors(c4);
    Competition tournament = new Tournament(compet2);
    tournament.addCompetitors(c5);
    tournament.addCompetitors(c6);
    tournament.addCompetitors(c7);
    tournament.addCompetitors(c8);
    try{
      System.out.println("New League :");
      league.play();
      System.out.println("");
      league.ranking();
      System.out.println("");
      System.out.println("New Tournament :");
      tournament.play();
    }
    catch(NumberNotPowerOf2Exception e){
      System.out.println("Cannot launch a tournament with "+compet2.size()+" competitors!");
      System.out.println("Try again with a number of competitors to the power of 2");
    }
  }
}
