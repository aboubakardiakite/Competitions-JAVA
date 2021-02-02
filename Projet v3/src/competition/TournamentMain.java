package competition;
import competition.*;
import util.*;
import io.*;
import java.util.*;

public class TournamentMain{
  public static void main(String[] args){
    List<Competitor> compet1 = new ArrayList<Competitor>();
    try{
      Competition tournament = new Tournament(compet1);
      System.out.println("Enter a number of competitors before starting a Tournament :");
      int choice = Input.readInt();
      int i = choice;
      int j = 1;
      while (i>0){
        tournament.addCompetitors(new Competitor("competitor "+j));
        i -= 1;
        j += 1;
      }
      System.out.println("New Tournament :");
      System.out.println("");
      tournament.play();
      tournament.ranking();
    }
    catch(NumberNotPowerOf2Exception e){
      System.out.println("Cannot launch a tournament with "+compet1.size()+" competitors!");
      System.out.println("Try again with a number of competitors to the power of 2");
    }
    catch(java.io.IOException t){
      int choix=0;
    }
  }
}
