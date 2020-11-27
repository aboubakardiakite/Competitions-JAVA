package competition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StrategyDeux implements Strategy {
	
	
	List<Competitor> lesFinaliste = new ArrayList<Competitor>();
	List<Competitor> troisieme = new ArrayList<Competitor>();
	
	@Override
	public List<Competitor> selection(List<League> league) throws NumberNotPowerOf2Exception {	
		List<Competitor> theFinaliste= new ArrayList<Competitor>();
		for(League l : league) {
			l.play();
			Map<Competitor, Integer> rank = l.ranking();
			Set<Competitor> lesCles1 = rank.keySet();
			Iterator<Competitor> it_cle1 = lesCles1.iterator();
			Competitor a = it_cle1.next();
			theFinaliste.add(a);
			Competitor a1 = it_cle1.next();
			theFinaliste.add(a1);
			Competitor a3 = it_cle1.next();
			troisieme.add(a3);

			System.out.println(" -------------------------------------------1------------------------");
		}
		 theFinaliste = this.meilleurTrois(theFinaliste);
		return theFinaliste;
	
	}
	
	
	
	public List<Competitor> meilleurTrois(List<Competitor> competitors){
		int cp=0;
		List<Competitor> competitor = new ArrayList<Competitor>();
		for(Competitor c : this.troisieme) {
			for(Competitor c1 : this.troisieme) {
					if(c.getPoints() < c1.getPoints()) {
						if(!competitor.contains(c1)  && cp!=2) {
							competitor.add(c1);
						}
					}
					cp=cp+1;
			}
			 
		}
		for(Competitor c : competitor) {
			competitors.add(c);
		}
		return competitors;
	}
}