package competition;

public class Competitor {

  private String name;
  private int points;
  private int maxPoints;

  /**
   * Create a competitor with the name entered in parameter
   * @param name the name of the competitor
   */
  public Competitor(String name){
    this.name = name;
    this.points = 0;
    this.maxPoints = 0;
  }

  /**
   * Returns the number of competitor's points
   * @return the number of competitor's points
   */
  public int getPoints(){
    return this.points;
  }

  /**
   * Returns the total points obtained by a competitor
   * @return the total points obtained by a competitor
   */
  public int getMaxPoints(){
    return this.maxPoints;
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
    this.maxPoints +=1;
  }

  /**
   * Resets the competitor's points
   */
  public void initPoint(){
    this.points =0;
  }

  /**
   * Returns the string representation of the competitor
   * @return the name of the competitor
   */
  public String toString(){
    return this.name+", "+this.points+" point(s)";
  }
}
