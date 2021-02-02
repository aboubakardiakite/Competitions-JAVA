package observer;
import competition.*;
import competition.methode.*;
import java.util.*;

public class MainObserver {

	public static void main(String[] args) {
		try{
			Competitor c1 = new Competitor("Joel");
			Competitor c2 = new Competitor("Aboubakar");
			Competitor c3 = new Competitor("Muaka");
			Competitor c4 = new Competitor("Diakite");
			Competition competition = new Master(new ArrayList<Competitor>(),2,new SelectFirst());
			competition.addCompetitors(c1);
			competition.addCompetitors(c2);
			competition.addCompetitors(c3);
			competition.addCompetitors(c4);
			Bookmaker b = new Bookmaker();
			JournalistMatch jm = new JournalistMatch();
			JournalistCompetition jc = new JournalistCompetition();
			competition.addMatchListener(jm);
			competition.addMatchListener(b);
			competition.addCompetitionListener(jc);
			competition.play();
		}
		catch(NumberNotPowerOf2Exception e){
      ;
    }
	}
}
