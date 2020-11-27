package competition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Master extends Competition{
				
				private Strategy strategy;
				public int nbPoules; 
				public Map<Integer,ArrayList<Competitor>> lesPoules;
				private List<League> league;
				public Master(List<Competitor> competitors,int nbPoules,Strategy strategie) {
					super(competitors);
					this.nbPoules = nbPoules;
					this.strategy = strategie;
					this.league = new ArrayList<League>();
			
					this.lesPoules = new HashMap<Integer,ArrayList<Competitor>>();
					
				}
				
				public int getNbPoules() {
					return this.nbPoules;
				}
				
				
				public void creerPoules() {
					int cp=1;
					for(Competitor c: this.competitors) {
						if(!this.lesPoules.containsKey(cp)) {
							this.lesPoules.put(cp,new ArrayList<Competitor>());
							this.lesPoules.get(cp).add(c);
							
						}else {
							this.lesPoules.get(cp).add(c);
								
						}
						cp= (cp % this.nbPoules) +1 ;
					}
				}
				
				public Map<Integer,ArrayList<Competitor>> getLestPoules(){
					return this.lesPoules;
				}
				
				
				public List<League> getnbLeague(){
					return this.league;
				}
				
				
				
				public void faireLeague() {
					Set<Integer> lesCles = this.lesPoules.keySet();
					Iterator<Integer> it_cle = lesCles.iterator();
					while(it_cle.hasNext()) {
						Integer a = it_cle.next();
						this.league.add(new League(this.lesPoules.get(a)));
						
					}
				}
				
				
				protected void play(List<Competitor> competitors) throws NumberNotPowerOf2Exception {
							List<Competitor> competitor = new ArrayList<Competitor>();
							try{
								competitor = this.strategy.selection(this.league);
								Tournament tournois = new Tournament(competitor);
								tournois.play(competitor);
							}catch(NumberNotPowerOf2Exception e){
						        System.out.println("Try again with a number of competitors to the power of 2");
						    }
							    
			
					
				}
			
				

	

}
