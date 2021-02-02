package competition.methode;
import java.util.*;
import util.*;
import competition.*;

public interface Methode {

	/**
   * Select competitors from the list of leagues passed in parameter
	 * @param league the list of leagues
   * @return the list of selected competitors
   */
	public List<Competitor> selection(List<League> league);
}
