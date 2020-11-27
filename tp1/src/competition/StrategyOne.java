package competition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StrategyOne implements Strategy {
	
	
	List<Competitor> lesFinaliste = new ArrayList<Competitor>();
	
	
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
				
			
			System.out.println(" -------------------------------------------1------------------------");
		}
		return theFinaliste;
	
	}
	
}
