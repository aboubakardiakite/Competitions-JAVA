package competition;
import java.util.*;

public class Tournament extends Competition {

  /**
   * Creates a tournament with the list of competitors passed in parameter
   * @param competitors the list of competitors
   */
  public Tournament(List<Competitor> competitors){
    super(competitors);
  }

  /**
   * Plays the matches organized between the competitors whose list is in parameter
   * @param competitors the list of competitors
   */
  protected void play(List<Competitor> competitors) throws NumberNotPowerOf2Exception{
    int i = competitors.size();
    int j = competitors.size();
    int u = 0;
    List<Competitor> competitors1 = new ArrayList<Competitor>();
    List<Competitor> competitors2 = new ArrayList<Competitor>(competitors);
    if ((i != 0) && ((i & (i - 1)) == 0)){ //condition pour tester si un nombre est puissance de 2
      while(j!=1){
        System.out.println(u+1+"e tour :");
        while(i>j/2){ 
          int n1 = (int)(Math.random() * i);
          int n2 = (int)(Math.random() * i);
          while ((n1 == n2) || ((competitors2.get(n1).getPoints()!=competitors2.get(n2).getPoints())||(competitors2.get(n1).getPoints()!=u))){
            n1 = (int)(Math.random() * i);
            n2 = (int)(Math.random() * i);
          }
          this.playMatch(competitors2.get(n1),competitors2.get(n2));
          if (competitors2.get(n1).getPoints()>competitors2.get(n2).getPoints()){
            competitors1.add(competitors2.get(n2));
            competitors2.remove(n2);
          }
          else{
            competitors1.add(competitors2.get(n1));
            competitors2.remove(n1);
          }
          i = i-1;
        }
        System.out.println("");  //juste pour une meilleure présentation
        u +=1;
        j = j/2;
        i = j;
      }
      System.out.println("The tournament winner is "+competitors2.get(0).getName()+" !");
      for (Competitor c : competitors1){
        competitors2.add(c);
      }
    }
    else{
      throw new NumberNotPowerOf2Exception();
    }
  }
}
