package competition;

public class Competitor {

  private String name;
  private int points;

  /**
   * Create a competitor with the name entered in parameter
   * @param name the name of the competitor
   */
  public Competitor(String name){
    this.name = name;
    this.points = 0;
  }

  /**
   * Returns the number of competitor's points
   * @return the number of competitor's points
   */
  public int getPoints(){
    return this.points;
  }

  /**
   * Returns the name of the competitor
   * @return the name of the competitor
   */
  public String getName(){
    return this.name;
  }

  /**
   * Add one point to the competitor
   */
  public void addPoint(){
    this.points +=1;
  }
  
  public void reInitPoint(){
      this.points=0;
  }

  /**
   * Returns the string representation of the competitor
   * @return the name of the competitor
   */
  public String toString(){
    return this.name+", "+this.points+" point(s)";
  }
}
