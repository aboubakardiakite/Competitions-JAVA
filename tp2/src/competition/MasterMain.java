package competition;
import competition.*;
import competition.methode.*;
import util.*;
import io.*;
import java.util.*;

public class MasterMain{
  public static void main(String[] args){
    List<Competitor> compet1 = new ArrayList<Competitor>();
    Methode methode = null;
    int groupe = 0;
    try{
      Competition master = null;
      System.out.println("Please enter the number corresponding to the mode of your Master :");
      System.out.println("SelectFirst (1)   SelectFirstTwo (2)    SelectFirstTwoAndBestThirds (3)");
      int choix = Input.readInt();
      while ((choix != 1)&&(choix != 2)&&(choix != 3)){
        System.out.println("Please enter the number corresponding to the mode of your Master :");
        System.out.println("SelectFirst (1)   SelectFirstTwo (2)    SelectFirstTwoAndBestThirds (3)");
        choix = Input.readInt();
      }
      if (choix == 1){
          methode = new SelectFirst();
      }
      else if (choix == 2){
        methode = new SelectFirstTwo();
      }
      else{
        methode = new SelectFirstTwoAndBestThirds();
      }
      System.out.println("Enter a number of competitors before starting a Master :");
      int choix1 = Input.readInt();
      System.out.println("Number of groups :");
      groupe = Input.readInt();
      master = new Master(compet1, groupe, methode);
      int i = choix1;
      int j = 1;
      while (i>0){
        System.out.println("Enter the name of the competitor "+j+" :");
        String name = Input.readString();
        master.addCompetitors(new Competitor(name));
        i -= 1;
        j += 1;
      }
      System.out.println("New Master :");
      System.out.println("");
      master.play();
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
